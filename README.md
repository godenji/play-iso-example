play-iso-example
===================

Description
-----------

This is the companion project to [play-iso](https://github.com/godenji/play-iso); here you will find
setup instructions as well as play-iso sample tests.


Setup
-----------

Included [`Build.scala`](https://github.com/godenji/play-iso-example/blob/master/project/Build.scala) 
illustrates setup for a *non-Slick* Play 2.4 project. 
~~Slick users please switch to the [play-iso-example-slick branch]().~~ Hold tight, coming soon.

Required bits in your `build.scala(.sbt)`:

    import play.sbt.routes.RoutesKeys.routesImport
    ...

    libraryDependencies += "play-iso" %% "play-iso" % "1.0",
    routesImport ++= Seq(
      "playiso.RouteBindable._",
      "path.to.your.custom.types._"
    ),
    resolvers += Resolver.url(
      "play-iso remote", 
      url("https://github.com/godenji/play-iso/releases/")
    )(Resolver.ivyStylePatterns)


Your custom type needs to extend the play-iso `MappedTo` trait. 
See [example custom type](https://github.com/godenji/play-iso-example/blob/master/app/com/foo/model/key/FooId.scala). 
The [sample controller](https://github.com/godenji/play-iso-example/blob/master/app/controllers/Foo.scala) shows 
basic usage. Be sure to take note of the required imports in the 
[sample form](https://github.com/godenji/play-iso-example/blob/master/app/controllers/Foo.scala#L27). 

That's all folks, enjoy ;-) 


License
----------

As this project is a derivative work (uses a modified version of the Slick 
[isomorphism macro](https://github.com/slick/slick/blob/648184c7cb710563d07b859891ed7fe46d06849d/slick/src/main/scala/slick/lifted/MappedTo.scala)
) it carries Slick's Typesafe license (BSD 2-clause).

