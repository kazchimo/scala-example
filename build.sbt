ThisBuild / scalaVersion := "2.13.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test,
  "org.typelevel" %% "cats-core" % "2.1.1"
)

lazy val root = (project in file("."))
  .settings(name := "scala-example")
