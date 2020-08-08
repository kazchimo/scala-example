import eu.timepit.refined.api.{Refined, RefinedTypeOps}
import eu.timepit.refined.numeric._
import eu.timepit.refined.auto._
import eu.timepit.refined._


type Age = Int Refined Positive
object Pos extends RefinedTypeOps[Age, Int] {
  def double(a: Age) = a * 2
}

val a: Age = 3
val b = 4

refineV[Positive](b)

Pos.double(a)

val c: Age = 4

a.<(c)

locally()

Predef
