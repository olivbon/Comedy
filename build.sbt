name := "Comedy"

version := "0.1"

scalaVersion := "2.12.8"

val opRabbitVersion = "2.1.0"

libraryDependencies ++= Seq(
  "com.lightbend.akka" %% "akka-stream-alpakka-csv" % "2.0.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.31",
  "com.spingo" %% "op-rabbit-core"        % opRabbitVersion,
  "com.spingo" %% "op-rabbit-akka-stream" % opRabbitVersion,
)
