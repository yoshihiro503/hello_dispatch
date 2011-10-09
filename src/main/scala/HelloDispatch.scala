package org.proofcafe

import dispatch.Http
import dispatch.Request

import scala.io.Source

object HelloDispatch {
  def main(args: Array[String]) : Unit = {
    wget("http://proofcafe.org/index.html") {
      source =>
        val lines = source.getLines()
        lines.foreach(println)
    }
  }

  def wget[T](uri : String)(callback : Source => T) : T = {
    val http = new Http()
    val req = new Request(uri)
    http(req >~ callback)
  }

}
