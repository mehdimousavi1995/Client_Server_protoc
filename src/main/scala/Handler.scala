import akka.actor.Actor
import akka.io.Tcp
import akka.io.Tcp.{PeerClosed, Received}
import akka.util.ByteString

//import com.elenoon.nasim.request.requestEcho
//import com.elenoon.nasim.request.RPcError
//import com.elenoon.nasim.request.RPcOk



class Handler extends Actor {

  import Tcp._
  def receive = {
    case Received(data)  =>println("f")

//      case data:requestEcho =>
//        println(data.asInstanceOf[requestEcho].getEchoMsg)
//        Write("salam".asInstanceOf[ByteString])
//
//      case data:RPcError =>
//        println(data.asInstanceOf[RPcError].getErrorMsg)
//        Write("salam".asInstanceOf[ByteString])
//
//      case data:RPcOk =>
//        println(data.asInstanceOf[RPcOk].getRPcMsg)
//        Write("salam".asInstanceOf[ByteString])

    case PeerClosed => context stop self
  }
}