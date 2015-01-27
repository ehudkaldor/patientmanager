package controllers

import securesocial.controllers.BaseLoginPage
import play.api.mvc.{ RequestHeader, AnyContent, Action }
import play.api.Logger
import securesocial.core.{ RuntimeEnvironment, IdentityProvider }
import service.DemoUser
import securesocial.core.services.RoutesService

class CustomLoginController(implicit override val env: RuntimeEnvironment[DemoUser]) extends BaseLoginPage[DemoUser] {
  override def login: Action[AnyContent] = {
    Logger.debug("login using CustomLoginController")
    super.login
  }
  
  override def logout: Action[AnyContent] = {
    Logger.debug("logout using CustomLoginController")
    super.logout
  }
}

class CustomRoutesService extends RoutesService.Default {
  override def loginPageUrl(implicit req: RequestHeader): String = controllers.routes.CustomLoginController.login().absoluteURL(IdentityProvider.sslEnabled)
}