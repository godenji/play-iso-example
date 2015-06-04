package controllers

import play.api._
import play.api.mvc._

import com.foo.model.{Foo=> Model}
import com.foo.model.key.FooId

object Foo extends Controller with FooController
/*
 * traits used to facilitate unit testing;
 * can use 2.4 DI or 2.3.x top-level static object 
 * for Controllers and Forms as you like.
 */
trait FooController {self:Controller=>
  def show(id: FooId) = Action{
    implicit request=> Ok(s"FooId has value $id")
  }
  def optional(maybeFoo: Option[FooId]) = Action{
    implicit request=> Ok(s"FooId has value $maybeFoo")
  }
}

trait FooForm{
  object FooForm{
    import play.api.data._, Forms._, format.Formats._
    import playiso.FormBindable._
    
    val mapper = mapping(
      "id"  -> of[FooId],
      "bar" -> nonEmptyText
    )(Model.apply)(Model.unapply)
    val form = Form(mapper)
  }
}