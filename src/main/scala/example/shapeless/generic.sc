import shapeless.{Generic, HNil, ::}

object A

A :: HNil

Generic.materialize[A.type, 1 :: HNil]
