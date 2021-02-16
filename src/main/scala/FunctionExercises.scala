import scala.io.StdIn.readLine

object FunctionExercises extends App {

  def isPalindrome(text: String): Boolean = {
    text == text.reverse }
  println(isPalindrome("abba"))


  //  def getCityYear
  //Write a function which takes 4 parameters p0, perc, delta, p
  //return integer of years when the population reaches p
  //yearly formula is previous year * percentage increas + delta
  //percentage is in percent so you will need to convert
  //delta is how many people leave or join the city every year
  //probably while loop will work best here
  //also consider that it is possible that city never reaches p, then you should return -1
  //hint: if population does not increase after first year it will never reach p

  //  println(getCityYear(1000,2,50,1200)) should print 3
  //  println(getCityYear(1000,2,-50,1200)) should print -1
  //  println(getCityYear(1500000,2.5,10000,2000000)) should print 10

//    val increase: Int = (perc / 100) * p0)
//    val yearsPopulation: Int = (p0 + increase + delta)
//    var year: Int = 0
//        while (yearsPopulation < p && year > 0) {
//          year = year + 1
//          if (yearsPopulation < p0) year = -1
//        }
//    year

//  one of the successful solutions:
//  def getCityYear(p0:Double, perc:Double, delta:Double, p:Int) = {
//  var nextPop:Double = p0
//  var year:Int = 0
//  while (nextPop < p && year>=0) {
//    nextPop = nextPop*(1+perc/100)+delta
//    year = year + 1
//    if(nextPop < p0) year = -1
//  }
//  year
//}

  // another successful solution
//  def getCityYear(p0: Double, perc:Double, delta:Int, p:Int) = {
//
//    def getIncrease(start:Double) =  (start * perc / 100) + delta
//
//    if (getIncrease(p0) > 0) {
//      var currentPop = p0
//      var i = 0
//      do {
//        currentPop += getIncrease(currentPop)
//        i += 1
//      } while (currentPop < p)
//      i
//    }
//    else -1
//  }


  def getCityYear(p0:Int, perc:Double, delta:Int, p:Int): Int = {

    var yearlyResult = p0 + (p0 * perc/100) + delta
    var years = 1
    if(yearlyResult <= p0) years = -1
    while(yearlyResult<=p && years>0) {
      var newYearlyResult = yearlyResult + (yearlyResult * perc/100) + delta
      yearlyResult = newYearlyResult
      years += 1
    }
    years
  }

println(getCityYear(1000,2,50,1200))  // should print 3
println(getCityYear(1000,2,-50,1200)) // should print -1
println(getCityYear(1500000,2.5,10000,2000000)) // should print 10
}
//Finding methods that are available for each data type