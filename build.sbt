import scala.io.Source

name := """be-tekuma-host-form"""

updateOptions := updateOptions.value.withCachedResolution(true)

name := "be-tekuma-host-form"
version := Source.fromFile("VERSION").getLines().buffered.head
organization := "com.tekuma.host.form"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "junit" % "junit" % "4.10"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

enablePlugins(PlayJava, PlayEbean)

// Heroku
herokuAppName in Compile := "ancient-sea-8793"