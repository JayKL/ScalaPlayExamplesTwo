import javax.inject.Singleton
import play.api._
import play.api.http.HttpErrorHandler
import play.api.mvc._

import scala.concurrent.Future

@Singleton
class ErrorHandler extends Controller with HttpErrorHandler {
  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    Future.successful(
      Status(statusCode)("Client error occurred, we have informed IT, the error is: " + message)
    )
  }

  override def onServerError(request: RequestHeader, exception: Throwable): Future[Result] = {
    Future.successful(
      InternalServerError("A sever error occurred, we don't know what happened: " + exception.getMessage() )
    )
  }
}
