import cats.implicits._
import cats.{Contravariant, Invariant, Semigroup}

import scala.concurrent.duration._

val semi = Semigroup[Long]

val dur =
  Invariant[Semigroup].imap(Semigroup[Long])(Duration.fromNanos)(_.toNanos)
dur.combine(2.seconds, 3.seconds)

val durr = Invariant[Semigroup]
  .compose[List]
  .imap(Semigroup[List[Long]])(Duration.fromNanos)(_.toNanos)
durr.combine(List(2.seconds, 3.seconds), List(4.seconds))

val durrr = Invariant[Semigroup]
  .composeFunctor[List]
  .imap(Semigroup[List[Long]])(Duration.fromNanos)(_.toNanos)
durrr.combine(List(2.seconds), List(4.seconds, 3.seconds))

type ToInt[T] = T => Int
val durContra = Invariant[Semigroup]
  .composeContravariant[ToInt]
  .imap(Semigroup[ToInt[Long]])(Duration.fromNanos)(_.toNanos)
durContra.combine(_.toSeconds.toInt + 1, _.toSeconds.toInt * 2)(2.seconds)
