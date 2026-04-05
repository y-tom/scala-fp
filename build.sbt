ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.8.2"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.20"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.20" % Test
libraryDependencies += "org.scalatestplus" %% "mockito-5-12" % "3.2.19.0" % Test
libraryDependencies += "org.mockito" % "mockito-core" % "5.11.0" % Test

scalacOptions ++= Seq("-encoding", "UTF-8")

ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

lazy val root = (project in file("."))
  .settings(
    name := "scala-fp"
  )
