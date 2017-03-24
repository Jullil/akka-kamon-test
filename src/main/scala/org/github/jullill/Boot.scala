package org.github.jullill

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.routing.FromConfig
import com.typesafe.config.ConfigFactory
import kamon.Kamon

object Boot extends App {
  Kamon.start()

  implicit val config = ConfigFactory.load()
  implicit val actorSystem = ActorSystem("test-actor-system", config)

  val worker = actorSystem.actorOf(FromConfig.props(Worker.props), name = "workerRouter")

  Thread.sleep(10000)
  1 to 10 foreach { _ =>
    worker ! "Hello worker!!!"
  }
  sys.addShutdownHook(actorSystem.terminate())
//
//  implicit val executionContext: ExecutionContextExecutor = actorSystem.dispatcher
//  implicit val timeout: Timeout = Timeout(15.seconds)
//
//  val apiHost: String = config.getString("http.host")
//  val apiPort: Int = config.getInt("http.port")
//
//  private implicit val materializer = ActorMaterializer(None, None)(actorSystem)
//  private val bindingFuture = Http().bindAndHandle(route, apiHost, apiPort)
//
//  println(s"Server online at $apiHost:$apiPort. Press RETURN to stop...")
//  StdIn.readLine() // let it run until user presses return
//  bindingFuture
//    .flatMap(_.unbind()) // trigger unbinding from the port
//    .onComplete(_ => actorSystem.terminate()) // and shutdown when done
}

class Worker extends Actor with ActorLogging {
  override def receive: Receive = {
    case msg =>
      log.info("Got a message: {}", msg)
  }
}

object Worker {
  val name = "worker"

  def props: Props = Props[Worker]
}
