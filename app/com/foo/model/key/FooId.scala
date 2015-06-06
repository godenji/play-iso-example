package com.foo.model
package key

case class FooId(value: Int) 
  extends AnyVal with slick.lifted.MappedTo[Int]