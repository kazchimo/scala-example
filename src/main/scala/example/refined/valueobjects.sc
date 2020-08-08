import eu.timepit.refined.api.Refined
import eu.timepit.refined.numeric.Positive

type Pos[T] = T Refined Positive

type Ali = Int
