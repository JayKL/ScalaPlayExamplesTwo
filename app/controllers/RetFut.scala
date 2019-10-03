package controllers
import play.api._
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class RetFut extends Controller {

  def retFut=Action.async  {
    val futureInt=Future {
      intensiveComputation()
    }
    futureInt.map(i => Ok(views.html.newPage(  i)))
  }

  def intensiveComputation() = {
    Thread.sleep(10000)
    List(5,4,3)
  }

}
