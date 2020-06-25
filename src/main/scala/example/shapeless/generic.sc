import shapeless.{DefaultCaseClassDefns, Generic, nonGeneric}

object ALaCarte {
  object PersonDefns extends DefaultCaseClassDefns {
    type C = Person
    val ops = Ops
  }

  object Person extends PersonDefns.CaseClassCompanion

  class Person(val name: String) extends PersonDefns.CaseClass {
    @nonGeneric val upperName = name.toUpperCase
    def age(): Long = 20
  }
}

import ALaCarte._

Generic[Person]

