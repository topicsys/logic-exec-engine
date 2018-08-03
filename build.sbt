name := baseDirectory.value.getName

organization := "systems.topic"

version := "0.0.1-SNAPSHOT"

crossScalaVersions := Seq(
  /*"2.11.7", 多余，不需要两个*/
  "2.11.11",
  /*"2.12.2", 有一些编译问题：`the interface is not a direct parent`。*/
  "2.12.6")

lazy val scalaSettings = Seq(
  scalaVersion := "2.12.6"
)

lazy val root = Project(id = "engine", base = file("."))
  .dependsOn(/*lang*/)
  .settings(scalaSettings,
    aggregate in update := false
  )

// 启用对 java8 lambda 语法的支持。
scalacOptions += "-Xexperimental"

exportJars := true

// 注意：在 sbt 1.+版本，如果增加新包，必须置为false, 否则不会去网络下载。
offline := true

// 解决生成文档报错导致 jitpack.io 出错的问题。
publishArtifact in packageDoc := false

// 如果要用 jitpack 打包的话就加上，打完了再注掉。
resolvers += "jitpack" at "https://jitpack.io"
resolvers += Resolver.mavenCentral

libraryDependencies ++= Seq(
  "com.github.dedge-space" % "scala-lang" % "b4af0e13e2",
  "com.github.dedge-space" % "reflow" % "95c6e6ee49",

  "org.ow2.asm" % "asm" % "6.2",
  "org.apache.bcel" % "bcel" % "6.2",

  "junit" % "junit" % "[4.12,)" % Test,
  "org.scalatest" %% "scalatest" % "3.2.0-SNAP7" % Test
)
