play-iso-example
===================

Description
-----------

This is the companion project to [play-iso](https://github.com/godenji/play-iso); here you will find
setup instructions as well as play-iso sample tests. 
Slick users please switch to the [play-iso-example-slick](https://github.com/godenji/play-iso-example/tree/slick-3.0) branch. 


Setup
-----------

Included [`Build.scala`](https://github.com/godenji/play-iso-example/blob/master/project/Build.scala) 
illustrates setup for a *non-Slick* Play 2.4 project. 
If Play 2.3.x support is needed please file an issue, or better, become a contributor and issue a pull request ;-)

Required bits in your `build.scala(.sbt)`:

    import play.sbt.routes.RoutesKeys.routesImport
    ...

    libraryDependencies += "play-iso" %% "play-iso" % "1.1",
    routesImport ++= Seq(
      "playiso.macros.MappedToBase._", "playiso.bind.Route._",
      "path.to.your.custom.types._"
    ),
    resolvers += Resolver.url(
      "play-iso remote", 
      url("https://github.com/godenji/play-iso/releases/")
    )(Resolver.ivyStylePatterns)


Your custom types need to extend the play-iso `MappedTo` trait. 
See [example custom type](https://github.com/godenji/play-iso-example/blob/master/app/com/foo/model/key/FooId.scala). 
The [sample controller](https://github.com/godenji/play-iso-example/blob/master/app/controllers/Foo.scala) shows 
basic usage. Be sure to take note of the required imports in the 
[sample form](https://github.com/godenji/play-iso-example/blob/master/app/controllers/Foo.scala#L27). 

That's all folks, enjoy ;-) 
