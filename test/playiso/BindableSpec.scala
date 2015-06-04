package playiso

import org.scalatest._
import org.scalatestplus.play._
import play.api.mvc._
import play.api.test._, Helpers._

import com.foo.model.key.FooId
import controllers.{FooController, FooForm}

class RouteBindableSpec extends PlaySpec with Results {
  class Subject() extends Controller with FooController

  "Foo > show" should {
    "route a path bindable value class" in {
      val controller = new Subject()
      val res = controller.show(FooId(3)).apply(FakeRequest())
      val text: String = contentAsString(res)
      text mustBe "FooId has value 3"
    }
  }
  "Foo > optional" should {
    "route a querystring bindable value class" in {
      val controller = new Subject()
      val res =
        controller.optional( Some(FooId(3)) ).
        apply(FakeRequest())
        
      val text: String = contentAsString(res)
      text mustBe "FooId has value Some(3)"
    }
  }
}

class FormBindableSpec extends PlaySpec {
  class Subject() extends FooForm
  
  "Form > valid" should {
    "bind value class when id is target primitive type" in {
      val form = new Subject().FooForm.form
      val res = form.bind(Map("id" -> "3", "bar" -> "baz"))
      res.hasErrors mustBe false 
    }
  }
  "Form > invalid > wrong type" should {
    "fail to bind value class when id is wrong primitive type" in {
      val form = new Subject().FooForm.form
      val res = form.bind(Map("id" -> "3.0", "bar" -> "baz"))
      res.hasErrors mustBe true
    }
  }
  "Form > invalid > empty" should {
    "fail to bind value class when id is empty" in {
      val form = new Subject().FooForm.form
      val res = form.bind(Map("id" -> "", "bar" -> "baz"))
      res.hasErrors mustBe true 
    }
  }
}
