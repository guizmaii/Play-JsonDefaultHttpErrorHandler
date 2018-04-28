package controllers

import play.api.libs.json.Json
import play.api.mvc._

class HomeController(cc: ControllerComponents) extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(Json.obj("answer" -> "Hello World"))
  }

  def exception() = Action {
    throw new RuntimeException("This is an error message")

    Ok("will never be called")
  }

}
