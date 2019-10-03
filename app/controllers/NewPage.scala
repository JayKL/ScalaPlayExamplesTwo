package controllers
import play.api._
import play.api.mvc._
class NewPage extends Controller {

  def newPage=Action  {
    Ok(views.html.newPage(List(1,2)))
  }

}
