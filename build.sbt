ThisBuild / scalaVersion := "2.13.2"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test,
  "org.typelevel" %% "cats-core" % "2.1.1",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.atnos" %% "eff" % "5.9.0"
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

scalacOptions += "-Ypartial-unification"

lazy val root = (project in file("."))
  .settings(name := "scala-example")
