package com.fda.file

import Control._
import scala.util.{Try, Success, Failure}

object File {
  def tryReadFile(path: String): Try[List[String]] = {
    Try {
      val lines = using(io.Source.fromFile(path)) { source =>
        (for (line <- source.getLines) yield line).toList
      }
      lines
    }
  }
}
