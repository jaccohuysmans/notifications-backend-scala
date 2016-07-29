package services

import scala.concurrent.Future
import scala.util.parsing.json.JSONObject

trait SearchService {

  def save(jsonObject: JSONObject): Future[Result]

  def list: Future[Result]

}
