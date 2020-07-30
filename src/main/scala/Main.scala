import akka.actor.{ActorRef, ActorSystem, Props}
import akka.stream.ActorMaterializer
import com.newmotion.akka.rabbitmq.{Channel, ChannelActor, ConnectionActor, ConnectionFactory, CreateChannel}
import com.spingo.op_rabbit.{Message, RabbitControl}
import com.spingo.op_rabbit.stream.MessagePublisherSink
import com.timcharper.acked.AckedSource

object Main extends App {
  implicit val system: ActorSystem = ActorSystem("comedia-films")
  implicit val materializer: ActorMaterializer = ActorMaterializer()

  val factory = new ConnectionFactory()
  val connectionActor : ActorRef = system.actorOf(ConnectionActor.props(factory))
  def setupChannel(channel: Channel, self: ActorRef) {
    channel.queueDeclare("Comedy", false, false, false, null)
  }
  connectionActor ! CreateChannel(ChannelActor.props(setupChannel))

  val rabbitControl = system.actorOf(Props[RabbitControl])

  val comedies = Extractor.getComedies

  AckedSource(comedies).
    map(Message.queue(_,"Comedy")).
    to(MessagePublisherSink(rabbitControl)).run

  system stop connectionActor
}
