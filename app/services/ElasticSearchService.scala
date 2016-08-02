package services

import com.google.inject.{Inject, Singleton}
import play.api.Configuration
import play.api.libs.json.JsValue
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.Future


@Singleton
class ElasticSearchService @Inject() (ws: WSClient, configuration: Configuration)  extends SearchService {

  val esUrl = configuration.getString("elasticSearch.url").getOrElse("")
  val esIndex = configuration.getString("elasticSearch.index").getOrElse(Configuration.empty)
  val esType = configuration.getString("elasticSearch.type").getOrElse(Configuration.empty)

  def save(json: JsValue): Future[WSResponse] = getWsRequest("").post(json)

  def list: Future[WSResponse] = getWsRequest("_search").get()

  private def getWsRequest(command: String) = {
    ws.url(esUrl+ "/" + esIndex +"/" + esType +"/" + command).withHeaders(("Content-Type", "application/json"))
  }

}
