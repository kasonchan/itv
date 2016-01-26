val name = "itv"

lazy val buildSettings = Seq(
  organization := "com.kasonchan",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.11.7"
)

lazy val compilerOptions = Seq(
  "-encoding", "UTF-8",
  "-feature",
  "-Ylog-classpath",
  "-deprecation"
)

val testDependencies = Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5",
  "org.scalatest" %% "scalatest" % "2.2.5"
)

val baseSettings = Seq(
  libraryDependencies ++= testDependencies.map(_ % "test"),
  scalacOptions in(Compile, console) := compilerOptions
)

lazy val allSettings = baseSettings ++ buildSettings

lazy val itv = project.in(file("."))
  .settings(moduleName := name)
  .settings(allSettings: _*)
  .settings(
    libraryDependencies ++= testDependencies
  )
