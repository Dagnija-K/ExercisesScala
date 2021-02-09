import scala.io.StdIn.readLine

object TemperatureCalculator extends App
{
  val usersTemperature = readLine("How high is your temperature?").trim.toFloat
  if (usersTemperature > 37) {
    println("Oh no! You have high temperature!")}
  else if (usersTemperature < 35) {
    println("Oh no! You have low temperature!")}
  else if (usersTemperature <= 37 && usersTemperature >= 35) {
    println("Congratulations! You are fine")}
}
