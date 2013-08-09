package search.clientserver

import akka.actor.Actor
import scala.sys.process._
import akka.actor.ActorLogging

class SearchServerActor extends Actor  with ActorLogging {

  def findFile(pattern: String): String = {
     val host = Process("hostname").lines.mkString("\n")

     Seq("sh", "-c", "locate -b " + pattern + " | sed  's/$/    @" + host + "/'") . !!  
  }

  def receive: Receive = {
    case searchPattern: String =>

      var searchResult = "Not found."
      try {
        searchResult = findFile(searchPattern)
      } catch {
        case e: Exception => log.error("ex: {}", e.toString() )
      }
      sender.tell(searchResult)
  }
}