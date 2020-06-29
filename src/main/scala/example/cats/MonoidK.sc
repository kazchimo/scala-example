import cats.MonoidK
import cats.implicits._

MonoidK[List].algebra[Long].empty

val monoidK = MonoidK[List].compose[Option]

monoidK.combineK(List(Some(1)), List(Some(2), None))
