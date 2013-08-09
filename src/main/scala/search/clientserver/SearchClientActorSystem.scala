package search.clientserver

import com.typesafe.config.ConfigFactory

import akka.actor.ActorSystem
import akka.actor.Props

object SearchClientActorSystem {
  def main(args: Array[String]): Unit = {

    val config = ConfigFactory.load().getConfig("LocalSys")
    val system = ActorSystem("SearchClientApp", config)
    val clientActor = system.actorOf(Props[SearchClientActor])

    do {
        val searchPattern = readLine("search for: ")

        if ( ! searchPattern.trim.isEmpty ){
           clientActor ! searchPattern
        }
    }while( true )
  }
}