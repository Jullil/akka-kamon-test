
name := "akka-kamon-integration"

version := "1.0"

//javacOptions ++= Seq("-source", "1.8", "-target", "1.8")

scalaVersion := "2.11.8"

//scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

resolvers ++= Seq[Resolver](
  "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases",
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/"
)

libraryDependencies ++= {
  val akkaVersion = "2.4.17"
  val kamonVersion = "0.6.6"
  val akkaHttpVersion = "10.0.4"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
//    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
//    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
//    "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
//    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
//    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "test",
//    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
    "ch.qos.logback" % "logback-classic" % "1.1.7",
    "io.kamon" %% "kamon-core" % kamonVersion,
//    "io.kamon" %% "kamon-system-metrics" % kamonVersion,
    "io.kamon" %% "kamon-akka-2.4" % kamonVersion,
//    "io.kamon" %% "kamon-akka-remote-2.4" % kamonVersion,
//    "io.kamon" %% "kamon-akka-http" % kamonVersion,
//    "io.kamon" %% "kamon-scala" % kamonVersion,
    "io.kamon" %% "kamon-autoweave" % "0.6.5"
  )
}
    