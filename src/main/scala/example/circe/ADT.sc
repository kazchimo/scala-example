import io.circe.{Decoder, Encoder}
import shapeless.{Coproduct, Generic}
import io.circe.syntax._
import io.circe.generic.auto._

implicit def encodeAdtNoDiscr[A, Repr <: Coproduct](
    implicit
    gen: Generic.Aux[A, Repr],
    encodeRepr: Encoder[Repr]
  ): Encoder[A] = encodeRepr.contramap(gen.to)

implicit def decodeAdtNoDiscr[A, Repr <: Coproduct](
    implicit
    gen: Generic.Aux[A, Repr],
    decodeRepr: Decoder[Repr]
  ): Decoder[A] = decodeRepr.map(gen.from)

sealed trait Animal

case class Dog(color: String) extends Animal

case class Cat(kind: String) extends Animal

Dog("color").asJson

