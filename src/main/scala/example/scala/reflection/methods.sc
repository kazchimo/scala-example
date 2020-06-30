import scala.reflect.runtime.universe._

case class Person(names: String*) {
}

def getTypeTag[T: TypeTag](a: T) = typeTag[T]

val personTpe = getTypeTag(Person("john")).tpe

val a = personTpe.decls.collect {
  case sym: TermSymbol => sym.typeSignatureIn(personTpe).finalResultType
}

val namesT = personTpe.member(newTermName("names")).typeSignatureIn(personTpe).finalResultType

def isVararg(tpe: Type): Boolean =
  tpe.typeSymbol == definitions.RepeatedParamClass

val varargTC = typeOf[scala.collection.Seq[_]].typeConstructor

namesT map {
  case b @ TypeRef(_, _, args) if isVararg(b) =>
    appliedType(varargTC, args)
  case tpe => tpe
}
