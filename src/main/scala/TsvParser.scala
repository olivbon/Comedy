import java.io.File
import java.nio.file.{Path, Paths}

import akka.stream.IOResult
import akka.stream.alpakka.csv.scaladsl.{CsvParsing, CsvToMap}
import akka.stream.scaladsl.{FileIO, Source}

import scala.concurrent.Future

object TsvParser {
  def processTsvFile(inputFile: File): Source[Map[String,String], Future[IOResult]] = {
    val csvFile: Path = Paths.get(inputFile.getPath)
    val source = FileIO.fromPath(csvFile)

    source
      .via(CsvParsing.lineScanner('\t'))
      .via(CsvToMap.toMapAsStrings())
  }
}
