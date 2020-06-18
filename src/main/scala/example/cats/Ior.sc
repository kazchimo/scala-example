import cats.data.Ior
import cats.implicits._

// foreach
"abc".leftIor[Int].foreach(println)

123.rightIor[String].foreach(println)

Ior.both("abc", 123).foreach(println)

// traverse
"abc".leftIor[Int].traverse(i => List(i, i * 2))

123.rightIor[String].traverse(i => List(i, i * 2))

Ior.both("abc", 123).traverse(i => List(i, i * 2))
