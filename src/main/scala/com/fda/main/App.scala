package com.fda.main

import com.fda.graph.{Graph, GraphGenerator}

object App {

  def main(argv: Array[String]): Unit = {
    val path: String = "C:\\Users\\przem\\Desktop\\Algorytmy input dane\\br17.atsp"
    val graph: Graph = GraphGenerator.getGraph(path)

    graph.toString
  }
}
