import scala.io.StdIn.readLine

object BonusCalculator extends App {
  //TODO Calculate yearly Xmas Bonus
  //Ask for Employee Name
  val employee = readLine("What is your name?")
  println(s"Nice to talk to you $employee!")

  val workYears = readLine(s"$employee, how many years have you worked here?").trim.toInt
  val wageAmount = readLine(s"$employee, how much is your monthly wage?").trim.toInt

  if (workYears <= 2) {
    println(s"Thank you $employee for all your hard work! Happy holidays!")}
  else if (workYears > 2) {
    val bonusYears = workYears - 2
    val bonusAmount = bonusYears * 0.15 * wageAmount
    println(s"Thank you $employee for all your hard work! Happy holidays! You will receive a holiday bonus of ${bonusAmount.toInt} euros.")}

}
