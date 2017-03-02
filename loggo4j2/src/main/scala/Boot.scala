package loggo

import org.apache.logging.log4j.scala.Logging

import scala.concurrent.ExecutionContext.Implicits.global

import slick.jdbc.H2Profile.api._

object Models {
  case class User(
    id: Int,
    username: String
  )

  class Users(tag: Tag) extends Table[User](tag, "users") {
    def id = column[Int]("id", O.PrimaryKey)
    def name = column[String]("name")
    def * = (id, name) <> (User.tupled, User.unapply)
  }

  object Users extends TableQuery[Users](new Users(_))
}

object Boot extends App with Logging {
  import scala.concurrent.Await
  import scala.concurrent.duration._

  import Models._

  val timeout = 10 seconds

  val db = Database.forConfig("h2mem1")

  try {
    val setup = DBIO.seq(
      Users.schema.create,
      Users ++= Seq(
        User(1, "Gabro"),
        User(2, "Dani")
      )
    )

    Await.result(db.run(setup), timeout)

    val futureUser = db.run(Users.result)

    val user = Await.result(futureUser, timeout)

    logger.info("this is an info log")
    logger.error(user)
  } finally db.close
}
