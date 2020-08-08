import cats._
import cats.implicits._

def pf: PartialFunction[String, String] = { case "error" => "ERROR" }

ApplicativeError[Either[String, Any], String]
