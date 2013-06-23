
Simple distributed search engine implemented in Scala and Akka

How it works:
The search client connects to multiple search servers and sends the search request. The search servers use the "locate" program to find local files and send the search results to the client. The client displays the results from all servers. Each result shows the full file name and the hostname where the file can be found. Implemented with Akka's remote Actors.


To run:
  1) Start search servers on several machines by choosing ServerActorSystem when doing "sbt run"


  2) Edit SearchClientActor.scala  - add the hosts that are running the search servers. Start the search client with "sbt run" and choose SearchClientActorSystem.
