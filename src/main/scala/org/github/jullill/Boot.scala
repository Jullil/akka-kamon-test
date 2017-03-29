package org.github.jullill

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}
import akka.routing.FromConfig
import kamon.Kamon

object Boot extends App {
  Kamon.start()

  implicit val actorSystem = ActorSystem("akka-kamon-integration")

  val worker = actorSystem.actorOf(FromConfig.props(Worker.props), name = "workerRouter")

  1 to 100 foreach { _ =>
    worker ! "Hello worker!!!"
  }

  sys.addShutdownHook(actorSystem.terminate())
}

object Worker {
  def props: Props = Props[Worker]
}

class Worker extends Actor with ActorLogging {
  override def receive: Receive = {
    case msg =>
      log.info("Got a message: {}", msg)
  }
}
