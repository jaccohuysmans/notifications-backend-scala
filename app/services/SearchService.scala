package services

import play.api.libs.json.JsValue
import play.api.libs.ws.WSResponse

import scala.concurrent.Future

trait SearchService {

  def save(json: JsValue): Future[WSResponse]

  def list: Future[WSResponse]

}
