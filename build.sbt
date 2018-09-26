name := """PlayScala-CompileTimeDI-JsonDefaultHttpErrorHandler"""
organization := "com.guizmaii"

version := "1.0"

scalafmtOnCompile := true
scalafmtCheck := true
scalafmtSbtCheck := true

lazy val root = (project in file(".")).enablePlugins(PlayService)

scalaVersion := "2.12.6"

libraryDependencies ++= Seq(akkaHttpServer, filters)
libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
