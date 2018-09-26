package com.guizmaii

import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play._
import play.api._
import play.api.libs.json.Json
import play.api.test.Helpers._
import play.api.test._

/**
  * Add your spec here.
  * You can mock out a whole application including requests, plugins etc.
  *
  * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
  */
final class HomeControllerSpec extends PlaySpec with ScalaFutures {

  val context: ApplicationLoader.Context = ApplicationLoader.createContext(Environment.simple())

  /**
    * Inspired by https://github.com/Colisweb/routing_ant/blob/develop/test/helpers/GuiceHelpers.scala
    */
  def withApp[T](components: BuiltInComponents = new App(context))(test: Application => T): T = {
    val app = components.application
    Play.start(app)
    try {
      test(app)
    } finally Play.stop(app)
  }

  "Routes" should {
    "send 404 on a bad request" in withApp() { app =>
      route(app, FakeRequest(GET, "/boum")).map(status) mustBe Some(NOT_FOUND)
    }
  }

  "/" should {
    """returns "Hello World"""" in withApp() { app =>
      val answer = route(app, FakeRequest(GET, "/")).get

      status(answer) mustBe OK
      contentType(answer) mustBe Some("application/json")
      Json.parse(contentAsString(answer)) mustBe Json.obj("answer" -> "Hello World")
    }
  }

  "/exception" should {
    def request = FakeRequest(GET, "/expcetion").withHeaders("Content-Type" -> "application/json")

    "returns a formatted exception" in withApp() { app =>
      val answer = route(app, request).get

      status(answer) mustBe NOT_FOUND
      contentType(answer) mustBe Some("application/json")
      contentAsString(answer) must include("error")
    }
  }

}
