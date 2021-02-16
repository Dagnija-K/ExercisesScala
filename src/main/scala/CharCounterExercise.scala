import scala.io.StdIn.readLine

object CharCounterExercise extends App {
val name = readLine("Hello! What is your name?")
  val example = readLine(s"$name, please write a sentence!")
//  solution Aliaxander from https://stackoverflow.com/questions/37105995/count-char-frequency-in-string-with-scala
  val map = scala.collection.mutable.HashMap.empty[Char, Int]
  for (symbol <- example.toLowerCase.replace(" ", "")) {
    if (map.contains(symbol))
      map(symbol) = map(symbol) + 1
    else
      map.+=((symbol, 1))
  }
  println(map)

}
