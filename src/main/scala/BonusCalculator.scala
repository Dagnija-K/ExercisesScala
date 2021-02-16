import scala.io.StdIn.readLine

object BonusCalculator extends App {
  //TODO Calculate yearly Xmas Bonus
  //Ask for Employee Name
  val employee = readLine("What is your name?")
  println(s"Nice to talk to you $employee!")

  val workYears = readLine(s"$employee, how many years have you worked here?").trim.toFloat
  val wageAmount = readLine(s"$employee, how much is your monthly wage?").trim.toFloat

  val minTenure = 2
  val maxTenure = 10
  if (workYears <= minTenure) {
    println(s"Thank you $employee for all your hard work! Happy holidays!")
  }
  else if (workYears > minTenure && workYears < maxTenure) {
    val bonusYears = workYears - minTenure
    val bonusAmount = bonusYears * 0.15 * wageAmount
    println(s"Thank you $employee for all your hard work! Happy holidays! You will receive a holiday bonus of ${bonusAmount.toFloat} euros.")
  }
  else if (workYears >= maxTenure) {
    val bonusAmount = maxTenure * 0.15 * wageAmount
    println(s"Thank you $employee for all your hard work! Happy holidays! You will receive a holiday bonus of ${bonusAmount.toFloat} euros.")
  }

}
