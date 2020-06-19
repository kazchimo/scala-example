import cats.data.Ior
import cats.implicits._

// foreach
"abc".leftIor[Int].foreach(println)

123.rightIor[String].foreach(println)

Ior.both("abc", 123).foreach(println)

/**
 * 123
 *
 * 123
 * */

// traverse
"abc".leftIor[Int].traverse(i => List(i, i * 2))

123.rightIor[String].traverse(i => List(i, i * 2))

Ior.both("abc", 123).traverse(i => List(i, i * 2))

/**
 * val res3: List[cats.data.Ior[String,Int]] = List(Left(abc))
 *
 * val res4: List[cats.data.Ior[String,Int]] = List(Right(123), Right(246))
 *
 * val res5: List[cats.data.Ior[String,Int]] = List(Both(abc,123), Both(abc,246))
 * */
