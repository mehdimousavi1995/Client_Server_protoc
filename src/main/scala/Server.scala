import akka.actor.{Actor, ActorSystem}
import akka.actor.{Actor, ActorRef, Props}
import akka.io.{IO, Tcp}
import java.net.InetSocketAddress

class Server extends Actor {

  import Tcp._
  import context.system

  IO(Tcp) ! Bind(self, new InetSocketAddress("127.0.0.1", 9090))
  def receive = {
    case b@Bound(localAddress) =>
    case CommandFailed(_: Bind) => context stop self
    case c@Connected(remote, local) =>
      sender() ! Register(context.actorOf(Props[Handler]))
  }
}


object server extends App {
  val system = ActorSystem("server_system")
  val ser = system.actorOf(Props[Server], "server")
}