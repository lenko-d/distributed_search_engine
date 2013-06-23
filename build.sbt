name := "DistributedSearchEngine"

version := "0.1"

scalaVersion := "2.9.1"


resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

unmanagedClasspath in Runtime <+= (baseDirectory) map { bd => Attributed.blank(bd / "resources") }

libraryDependencies ++= Seq(
"com.typesafe.akka" % "akka-actor" % "2.0.2",
"com.typesafe.akka" % "akka-remote" % "2.0.2",
"com.typesafe.akka" % "akka-kernel" % "2.0.2"
)
