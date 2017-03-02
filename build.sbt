val slick = "com.typesafe.slick" %% "slick" % "3.2.0"
val slickHikari = "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0"
val h2 = "com.h2database" % "h2" % "1.4.187"

lazy val loggo4j2 = project
  .settings(inThisBuild(Seq(
    scalaVersion := "2.11.8",
    name := "log4j2",
    libraryDependencies ++= Seq(
      "org.apache.logging.log4j" % "log4j-slf4j-impl" % "2.8",
      "org.apache.logging.log4j" %% "log4j-api-scala" % "2.8",
      h2,
      slick
    )
  )))

// lazy val loggoScalog = project
//   .settings(inThisBuild(Seq(
//     scalaVersion := "2.12.1",
//     name := "scalog",
//     libraryDependencies ++= Seq(
//       "io.rbricks" %% "scalog-backend" % "0.2.0",
//       h2,
//       slick
//     )
//   )))


// lazy val loggoLogback = project
//   .settings(inThisBuild(Seq(
//     scalaVersion := "2.12.1",
//     name := "logback",
//     libraryDependencies ++= Seq(
//       "ch.qos.logback" % "logback-classic" % "0.9.28",
//       h2,
//       slick
//     )
//   )))


// lazy val loggoTinylog = project
//   .settings(inThisBuild(Seq(
//     scalaVersion := "2.11.8",
//     name := "tinylog",
//     libraryDependencies ++= Seq(
//       "org.tinylog" % "tinylog" % "1.2",
//       "org.tinylog" % "slf4j-binding" % "1.2",
//       h2,
//       slick
//     )
//   )))
