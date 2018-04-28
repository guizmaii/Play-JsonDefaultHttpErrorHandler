name := """PlayScala-JsonDefaultHttpErrorHandler"""
organization := "com.guizmaii"

version := "1.0-SNAPSHOT"

scalafmtOnCompile := true
scalafmtCheck := true
scalafmtSbtCheck := true

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.6"

libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.1" % "provided"
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.guizmaii.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.guizmaii.binders._"
