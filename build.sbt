name := """patientmanager"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

CoffeeScriptKeys.bare := true

libraryDependencies ++= Seq(
  "com.typesafe.play" 		%% 	"play-slick" 	% "0.8.0",
  "com.typesafe.slick"      %%  "slick"         % "2.1.0",
  "com.github.aselab" %% "scala-activerecord" % "0.3.0",
  "com.github.aselab" %% "scala-activerecord-play2" % "0.3.0",
  "com.github.aselab" %% "scala-activerecord-specs" % "0.3.0" % "test",
  jdbc
)

emberJsVersion := "1.7.0"

