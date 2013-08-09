package search.clientserver

import akka.actor.Actor
import akka.actor.ActorLogging

import akka.dispatch.Await
import akka.pattern.ask

import akka.util.duration.intToDurationInt
import akka.util.Timeout

class SearchClientActor extends Actor with ActorLogging {

  var searchServerActorAtHost1 = context.actorFor("akka://ServerSys@127.0.0.1:2552/user/searchServerActor")

  var searchServerActorAtHost2 = context.actorFor("akka://ServerSys@127.0.0.1:2552/user/searchServerActor")

  implicit val timeout = Timeout(5 seconds)

  def receive: Receive = {
    case message: String =>
    
      val future1 = (searchServerActorAtHost1 ? message).mapTo[String]
      val future2 = (searchServerActorAtHost2 ? message).mapTo[String]

      val result = Await.result(future1, timeout.duration)
      log.info("\n results from Host1: {}", result)

      val result2 = Await.result(future2, timeout.duration)
      log.info("\n results from Host2: {}", result2)

  }
}