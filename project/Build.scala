import sbt._
import Keys._
import play.Play.autoImport._
import play.sbt.routes.RoutesKeys.routesImport

object ApplicationBuild extends Build {
  lazy val root = (project in file(".")).settings(
    name := "play-iso-example",
    version := "1.0",
    scalaVersion := "2.11.6",
    routesImport ++= Seq(
      "playiso.RouteBindable._",
      "com.foo.model.key._"
    ),
    libraryDependencies ++= Seq(
      "play-iso" %% "play-iso" % "1.0",
      "org.scalatest" %% "scalatest" % "2.2.1" % "test",
      "org.scalatestplus" %% "play" % "1.4.0-M3" % "test"
    ),
    resolvers ++= Seq(
      Resolver.file(
        "play-iso local", 
        file(s"${Path.userHome.absolutePath}/.ivy2/local/play-iso")
      )(Resolver.ivyStylePatterns),
      Resolver.url(
        "play-iso remote", 
        url("https://github.com/godenji/play-iso/releases/")
      )(Resolver.ivyStylePatterns)
    )
  ).enablePlugins(play.sbt.PlayScala)
}
