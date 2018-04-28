import _root_.controllers.{AssetsComponents, HomeController}
import com.softwaremill.macwire._
import play.api.ApplicationLoader.Context
import play.api._
import play.api.http.{HttpErrorHandler, JsonDefaultHttpErrorHandler}
import play.api.i18n._
import play.api.routing.Router
import router.Routes

/**
  * Application loader that wires up the application dependencies using Macwire
  */
class AppApplicationLoader extends ApplicationLoader {
  def load(context: Context): Application = new AppComponents(context).application
}

class AppComponents(context: Context)
    extends BuiltInComponentsFromContext(context)
    with AssetsComponents
    with I18nComponents
    with play.filters.HttpFiltersComponents {

  // set up logger
  LoggerConfigurator(context.environment.classLoader).foreach {
    _.configure(context.environment, context.initialConfiguration, Map.empty)
  }

  override lazy val httpErrorHandler: HttpErrorHandler =
    new JsonDefaultHttpErrorHandler(environment, configuration, devContext.map(_.sourceMapper))

  lazy val homeController: HomeController = wire[HomeController]
  // add the prefix string in local scope for the Routes constructor
  lazy val prefix: String = "/"
  lazy val router: Router = wire[Routes]

}
