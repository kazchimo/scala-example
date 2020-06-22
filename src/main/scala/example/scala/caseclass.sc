// can't use lazy definition
class Person(lazy val name: String)
case class Person(lazy val name: String)

// can call-by-name
class Person(name: => String)
// can't call-by-name
case class Person(name: => String)
