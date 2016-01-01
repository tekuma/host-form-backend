import scala.io.Source

name := """be-tekuma-host-form"""

updateOptions := updateOptions.value.withCachedResolution(true)

name := "be-tekuma-host-form"
version := Source.fromFile("VERSION").getLines().buffered.head
organization := "com.tekuma.host.form"

libraryDependencies ++= Seq(
  "mysql" % "mysql-connector-java" % "5.1.38",
  "junit" % "junit" % "4.12"
)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator

enablePlugins(PlayJava, PlayEbean)

// Heroku
herokuAppName in Compile := "ancient-sea-8793"