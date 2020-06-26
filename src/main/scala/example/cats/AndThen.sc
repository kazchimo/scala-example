import cats.data.AndThen

val seed = AndThen((x: Int) => x + 1)
val f = (0 until 10000).foldLeft(seed)((acc, _) => acc.andThen(_ + 1))

// This should not trigger stack overflow ;-)
f.apply(89)
