ThisBuild / scalaVersion := "2.13.2"

resolvers ++= Seq(
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)

val circeVersion = "0.13.0"
val circeDependencies = Seq(
  "io.circe"     %% "circe-core"           % circeVersion,
  "io.circe"     %% "circe-generic"        % circeVersion,
  "io.circe"     %% "circe-parser"         % circeVersion,
  "io.circe"     %% "circe-generic-extras" % circeVersion,
  "com.dripower" %% "play-circe"           % "2712.0",
  "io.circe"     %% "circe-shapes"         % circeVersion
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.2.0-M4" % Test,
  "org.typelevel" %% "cats-core" % "2.1.1",
  "com.chuusai" %% "shapeless" % "2.3.3",
  "org.atnos" %% "eff" % "5.9.0"
) ++ circeDependencies

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

scalacOptions += "-Ypartial-unification"

lazy val root = (project in file("."))
  .settings(name := "scala-example")
