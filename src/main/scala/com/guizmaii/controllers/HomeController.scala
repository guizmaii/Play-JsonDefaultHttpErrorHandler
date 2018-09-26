package com.guizmaii.controllers

import play.api.libs.json.Json
import play.api.mvc.Results._
import play.api.mvc._
import play.api.routing.{Router, SimpleRouter}

final class HomeController(
    Action: DefaultActionBuilder,
    controllerComponents: ControllerComponents
) extends SimpleRouter {

  import play.api.routing.sird._

  override val routes: Router.Routes = {
    case GET(p"/exception") =>
      Action(controllerComponents.parsers.json) {
        throw new RuntimeException("This is an error message")

        Ok("will never be called")
      }
    case GET(p"/") =>
      Action(controllerComponents.parsers.json) {
        Ok(Json.obj("answer" -> "Hello World"))
      }
  }

}
