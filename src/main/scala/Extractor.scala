import java.io.File
import akka.stream.IOResult
import akka.stream.scaladsl.Source

import scala.concurrent.Future

object Extractor {

  def getComedies: Source[String, Future[IOResult]] = {

    val file = new File("resource/title.basics.tsv")
    val films = TsvParser.processTsvFile(file)
    films
      .filter(row => row.getOrElse("titleType", "") == "movie" && row.getOrElse("genres", "").contains("Comedy"))
      .map(_.getOrElse("originalType", ""))
  }
}
