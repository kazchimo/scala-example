import shapeless.Generic
//https://github.com/milessabin/shapeless/issues/766

//sealed trait EnumVal
//val BarA = new EnumVal { val name = "A" }
//val BarB = new EnumVal { val name = "B" }
//val BarC = new EnumVal { val name = "C" }
//Generic[EnumVal]

sealed trait T
case class C(i: Int) extends T
val t: T = {
    new T {}
    C(42)
  }

val gen = Generic[T]
println(gen.to(t)) // Inl(C(42))
println(gen.to(C(42))) // Inr(Inl(C(42)))
