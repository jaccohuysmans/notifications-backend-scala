package controllers

import javax.inject._
import play.api._
import play.api.libs.json.JsValue
import play.api.libs.ws.WSResponse
import play.api.mvc._
import services.ElasticSearchService

import scala.concurrent.{Future, ExecutionContext}


@Singleton
class Application @Inject() (elasticSearchService: ElasticSearchService)(implicit context: ExecutionContext) extends Controller {

  def index = Action {
    Ok("No service here.")
  }

  def addNotification() = Action.async(BodyParsers.parse.json) { request =>
    val json: JsValue = request.body
    elasticSearchService.save(json) map { response =>
      Ok(response.body)
    }
  }

  def  getNotifications() = Action.async {
    elasticSearchService.list map { response =>
      Ok(response.body)
    }
  }

}
