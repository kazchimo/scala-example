trait Animal
case class Dog(color: String)
case class Cat(age: Long)

object Animal {
  def unapply(arg: Animal): Option[Animal] = arg match {
    case Dog
  }
}
