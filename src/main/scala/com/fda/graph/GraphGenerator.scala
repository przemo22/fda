package com.fda.graph

import com.fda.file.File.tryReadFile

import scala.util.control.Breaks.{break, breakable}
import scala.util.{Failure, Success, Try}

object GraphGenerator {
  private var graph: Graph = _;

  def getGraph(path: String): Graph = {
    readFileFromGraph(path);
  }


  private def readFileFromGraph(path: String): Graph = {
    val readFile: Try[List[String]] = tryReadFile(path);
    var matrixRecord: Int = 0;
    readFile match {
      case Success(lines) =>
        lines foreach (line => {
          breakable {
            val pch: Array[String] = line.split(":")
            if (pch(0).equals("NAME")
              || pch(0).equals("TYPE")
              || pch(0).equals("COMMENT")
              || pch(0).equals("EDGE_WEIGHT_TYPE")
              || pch(0).equals("EDGE_WEIGHT_FORMAT")
              || pch(0).equals("EDGE_WEIGHT_SECTION")
              || pch(0).equals("EOF")) {
              break
            }
            if (pch(0).equals("DIMENSION")) {
              graph = new Graph(Integer parseInt pch(1).trim())
              break
            }
            matrixRecord = processLine(line, matrixRecord)
          }
        })
        graph
      case Failure(s) => {
        println(s"Failed reading file, message is: $s")
        graph
      }
    }
  }

  def processLine(line: String, matrixRecord: Int): Int = {
    var innerCounter: Int = matrixRecord;
    val splitLine: Array[String] = line.split(" ")
    val onlyFilledNumbers: Array[String] = splitLine.filter( element => element.nonEmpty)
    for (index <- onlyFilledNumbers.indices) {
      breakable {
        graph.fillMatrix(innerCounter, index, Integer parseInt onlyFilledNumbers(index).trim)
      }
    }
    innerCounter += 1
    innerCounter
  }
}
