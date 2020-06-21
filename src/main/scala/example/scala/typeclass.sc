import cats.implicits._
import cats.Semigroup

trait A

trait B extends A

// defined for only A, not B
implicit def semia: Semigroup[A] = new Semigroup[A] {
  override def combine(x: A, y: A) = new A {}
}

val a = new A {}
val aa = new A {}
val b = new B {}
val bb = new B {}

a.combine(aa)
//    b.combine(bb) // compile error

