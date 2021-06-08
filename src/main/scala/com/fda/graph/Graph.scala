package com.fda.graph

class Graph {

  private var matrix: Array[Array[Int]] = _;
  private var size: Int = 0;

  def this(size: Int) = {
    this()
    this.size = size
    this.matrix = Array.ofDim[Int](size, size)
  }

  def fillMatrix(from: Int, to: Int, value:Int) : Unit = {
    matrix(from)(to) = value
  }

  def getPath(from: Int, to: Int): Int = {
    matrix(from)(to)
  }

  override def toString: String = {
    var tempString: String = ""
    for( i<-0 until size; j<-0 until size)
    {
      if(j % size == 0){
        tempString += "\n";
      }
      tempString += s"${matrix(i)(j)} "
    }
    tempString
  }
}
