import scala.reflect.runtime.universe._

case class Person(name: String) {
  def n = name
  private def na = name

  val nn = name
  private val nna = name

  val nnn = name + name
  private val nnna = name + name
}

def getTypeTag[T: TypeTag](a: T) = typeTag[T]

val personTpe = getTypeTag(Person("john")).tpe

val decls = personTpe.decls

val nameTpe = personTpe.member(newTermName("name"))

nameTpe.isPublic
nameTpe.isMethod
nameTpe.asMethod.isGetter
nameTpe.asMethod.isParamAccessor

personTpe.member(newTermName("n")).isPublic
personTpe.member(newTermName("n")).isMethod
personTpe.member(newTermName("n")).asMethod.isGetter
personTpe.member(newTermName("n")).asMethod.isParamAccessor

personTpe.member(newTermName("na")).isPublic
personTpe.member(newTermName("na")).isMethod
personTpe.member(newTermName("na")).asMethod.isGetter
personTpe.member(newTermName("na")).asMethod.isParamAccessor

personTpe.member(newTermName("nn")).isPublic
personTpe.member(newTermName("nn")).isMethod
personTpe.member(newTermName("nn")).asMethod.isGetter
personTpe.member(newTermName("nn")).asMethod.isParamAccessor

personTpe.member(newTermName("nna")).isPublic
personTpe.member(newTermName("nna")).isMethod
personTpe.member(newTermName("nna")).asMethod.isGetter
personTpe.member(newTermName("nna")).asMethod.isParamAccessor

personTpe.member(newTermName("nnn")).isPublic
personTpe.member(newTermName("nnn")).isMethod
personTpe.member(newTermName("nnn")).asMethod.isGetter
personTpe.member(newTermName("nnn")).asMethod.isParamAccessor

personTpe.member(newTermName("nnna")).isPublic
personTpe.member(newTermName("nnna")).isMethod
personTpe.member(newTermName("nnna")).asMethod.isGetter
personTpe.member(newTermName("nnna")).asMethod.isParamAccessor

