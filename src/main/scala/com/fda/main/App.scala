package com.fda.main

import com.fda.file.File.tryReadFile
import com.fda.graph.Graph

import scala.util.{Failure, Success}

object App {

  def main(argv: Array[String]): Unit = {


    val readFile = tryReadFile("/home/przemo/Projects/gitlab/ecmr-facade/tsconfig.json")
    readFile match {
      case Success(lines) => lines foreach(println)
      case Failure(s) => println(s"Filaed, message is: $s")
    }

    val graph = new Graph(3)
    graph.fillMatrix(0, 0, 999999999)
    graph.fillMatrix(0, 1, 2)
    graph.fillMatrix(0, 2, 3231)
    graph.fillMatrix(1, 0, 8)
    graph.fillMatrix(1, 1, 999999999)
    graph.fillMatrix(1, 2, 743212112)
    graph.fillMatrix(2, 0, 5443)
    graph.fillMatrix(2, 1, 32)
    graph.fillMatrix(2, 2, 999999999)
    print(graph.toString)
  }
}
