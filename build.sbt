ThisBuild / scalaVersion := "2.13.2"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test,
  "org.typelevel" %% "cats-core" % "2.1.1",
  "com.chuusai" %% "shapeless" % "2.3.3"
)

lazy val root = (project in file("."))
  .settings(name := "scala-example")
