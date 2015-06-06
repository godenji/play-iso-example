play-iso-example-slick
===================

Description
-----------

This is the companion project to [play-iso-slick](https://github.com/godenji/play-iso/tree/slick-3.0); here you will find
setup instructions as well as play-iso-slick sample tests. 
*Non-Slick* users please switch to the [play-iso-example](https://github.com/godenji/play-iso-example) branch.


Setup
-----------

Included [`Build.scala`](https://github.com/godenji/play-iso-example/blob/slick-3.0/project/Build.scala) 
illustrates setup for a Slick 3.0/Play 2.4 project.

Required bits in your `build.scala(.sbt)`:

    import play.sbt.routes.RoutesKeys.routesImport
    ...

    libraryDependencies += "play-iso-slick" %% "play-iso-slick" % "1.1",
    routesImport ++= Seq(
      "playiso.macros.MappedToBase._", "playiso.bind.Route._",
      "path.to.your.custom.types._"
    ),
    resolvers += Resolver.url(
      "play-iso remote", 
      url("https://github.com/godenji/play-iso/tree/slick-3.0/releases/")
    )(Resolver.ivyStylePatterns)


Your custom type needs to extend the Slick [MappedTo](https://github.com/slick/slick/blob/master/slick/src/main/scala/slick/lifted/MappedTo.scala#L51) trait. 
See [example custom type](https://github.com/godenji/play-iso-example/blob/slick-3.0/app/com/foo/model/key/FooId.scala). 
The [sample controller](https://github.com/godenji/play-iso-example/blob/slick-3.0/app/controllers/Foo.scala) shows 
basic usage. Be sure to take note of the required imports in the 
[sample form](https://github.com/godenji/play-iso-example/blob/slick-3.0/app/controllers/Foo.scala#L27). 

That's all folks, enjoy ;-)
