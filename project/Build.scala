import sbt._
import Keys._
import play.Play.autoImport._
import play.sbt.routes.RoutesKeys.routesImport

object ApplicationBuild extends Build {
  lazy val root = (project in file(".")).settings(
    name := "play-iso-example-slick",
    version := "1.1",
    scalaVersion := "2.11.6",
    routesImport ++= Seq(
      "playiso.macros.MappedToBase._", "playiso.bind.Route._",
      "com.foo.model.key._"
    ),
    libraryDependencies ++= Seq(
      "play-iso-slick" %% "play-iso-slick" % "1.1",
      "play-iso-build-slick" %% "play-iso-build-slick" % "1.1",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test",
      "org.scalatestplus" %% "play" % "1.4.0-M3" % "test",
      "com.typesafe.slick" %% "slick" % "3.0.0",
      "org.slf4j" % "slf4j-nop" % "1.6.4"
    ),
    resolvers ++= Seq(
      Resolver.file(
        "play-iso-slick local", 
        file(s"${Path.userHome.absolutePath}/.ivy2/local/play-iso-slick")
      )(Resolver.ivyStylePatterns),
      Resolver.url(
        "play-iso-slick remote",
        url("https://raw.githubusercontent.com/godenji/play-iso/slick-3.0/releases/")
      )(Resolver.ivyStylePatterns)
    )
  ).enablePlugins(play.sbt.PlayScala)
}
