name := "akka-kamon-integration"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "kamon-bintray" at "https://bintray.com/kamon-io/releases"
)

libraryDependencies ++= {
  val akkaVersion = "2.4.17"
  val kamonVersion = "0.6.6"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
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

fork in run := true
    