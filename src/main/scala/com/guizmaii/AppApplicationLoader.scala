package com.guizmaii

import com.guizmaii.controllers.HomeController
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.http.{HttpErrorHandler, JsonHttpErrorHandler}
import play.api.routing.Router
import play.filters.HttpFiltersComponents

/**
  * Application loader that wires up the application dependencies using Macwire
  */
final class AppApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = new App(context).application
}

final class App(context: Context) extends BuiltInComponentsFromContext(context) with HttpFiltersComponents {

  // set up logger
  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }

  override lazy val httpErrorHandler: HttpErrorHandler = wire[JsonHttpErrorHandler]
  lazy val router: Router                              = wire[HomeController]

}
