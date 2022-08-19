scalaVersion := "3.1.3"
name := "scala-zio-rest"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.0",
  "dev.zio" %% "zio-json" % "0.3.0-RC10",
  "dev.zio" %% "zio-logging-slf4j-bridge" % "2.0.1",
  "io.d11" %% "zhttp" % "2.0.0-RC10",
  "io.getquill" %% "quill-zio" % "3.19.0",
  "io.getquill" %% "quill-jdbc-zio" % "3.19.0",
  "com.h2database" % "h2" % "2.1.214"
)
