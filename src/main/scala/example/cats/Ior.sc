import cats.data.Ior
import cats.implicits._

"abc".leftIor[Int].foreach(println)

123.rightIor[String].foreach(println)

Ior.both("abc", 123).foreach(println)
