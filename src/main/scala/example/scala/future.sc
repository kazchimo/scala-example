import scala.concurrent.Future
import scala.util.Try

val success = Try(1)
val fail = Try(throw new Exception())

Future.fromTry(success)
Future.fromTry(fail)

/**
 * val success: scala.util.Try[Int] = Success(1)
 * val fail: scala.util.Try[Nothing] = Failure(java.lang.Exception)
 *
 * val res0: scala.concurrent.Future[Int] = Future(Success(1))
 * val res1: scala.concurrent.Future[Nothing] = Future(Failure(java.lang.Exception))
 * */
