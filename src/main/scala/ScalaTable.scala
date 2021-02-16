import scala.io.StdIn.readLine

object ScalaTable extends App {
  //TODO write a program that takes user input for starting and end values
  //then saves cubes of those values in a Seq data type and then prints the cubes out
  val begVal = readLine("What is the starting value?").trim.toInt
  val endVal = readLine("What is the last value?").trim.toInt
  val mySeq = (begVal to endVal).toVector
  println(mySeq)
  println(s"Will print cubes starting with cube for $begVal")
  val cubedSeq = mySeq.map(el => el*el*el)
  println(cubedSeq)
//  mySeq.foreach(el => println(el,3))
// val cubedSeq = mySeq(scala.math.pow(el,3)).toInt
//  val cubeSeq = mySeq(i => scala.math. pow(i,3).toInt)

}
