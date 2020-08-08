import eu.timepit.refined.api.{Refined, RefinedTypeOps}
import eu.timepit.refined.numeric.Positive
import io.circe.generic.auto._
import io.circe.syntax._
import io.circe.refined._

type Id = Long Refined Positive
object Id extends RefinedTypeOps[Id, Long]

sealed abstract class UserAttr

final case class UserId(value: Id) extends UserAttr

UserId(Id(3)).asJson
