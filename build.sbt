scalaOrganization in ThisBuild := "org.typelevel"
scalaVersion      in ThisBuild := "2.11.8"

scalacOptions in Global ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-unchecked",
  "-feature",
  "-Xlint",
  "-Xfatal-warnings",
  "-Ywarn-dead-code",
  "-Yliteral-types"
)

libraryDependencies in Global ++= Seq(
  "com.chuusai"   %% "shapeless" % "2.3.2",
  "org.typelevel" %% "cats"      % "0.7.0",
  "org.scalactic" %% "scalactic" % "2.2.6" % Test,
  "org.scalatest" %% "scalatest" % "2.2.6" % Test
)

lazy val common =
  project.in(file("common"))

lazy val representations =
  project.in(file("representations")).dependsOn(common)

lazy val csv =
  project.in(file("csv")).dependsOn(common)

lazy val literaltypes =
  project.in(file("literaltypes")).dependsOn(common)

lazy val json =
  project.in(file("json")).dependsOn(common)

lazy val numfields =
  project.in(file("numfields")).dependsOn(common)

lazy val migrations =
  project.in(file("migrations")).dependsOn(common)

lazy val root = project.in(file("."))
  .aggregate(
    representations,
    csv,
    literaltypes,
    json,
    numfields,
    migrations
  )
