import scala.reflect.runtime.universe._

def lowerKind(tpe: Type): Type =
  if(tpe.takesTypeArgs)
    appliedType(tpe, List(typeOf[Any])).dealias
  else tpe

lowerKind(typeOf[List[_]].typeConstructor)
lowerKind(typeOf[Map[_, _]].typeConstructor)
