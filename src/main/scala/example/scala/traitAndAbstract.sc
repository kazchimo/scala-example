trait A[B]

abstract class C[D]

object FromTrait extends A[Int]
object FromAbstract extends C[Int]

def traitP[V, T[V] <: A[V]](t: T[V]) = println(t)
def abstractP[V, T[V] <: C[V]](t: T[V]) = println(t)

traitP(FromTrait)
abstractP(FromAbstract)

