package services

import scala.concurrent.Future
import scala.util.parsing.json.JSONObject


class ElasticSearchService extends SearchService {

  def save(jsonObject: JSONObject): Future[Any] = ???

  def list: Future[Any] = ???
}
