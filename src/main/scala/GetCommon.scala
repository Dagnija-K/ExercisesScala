

object GetCommon extends App {
  def getCommonElements(s1: Seq[Int], s2: Seq[Int], s3: Seq[Int]): Seq[Int] = {
    s1.toSet.intersect(s2.toSet).intersect(s3.toSet).toSeq.sorted
  }
    val s1 = Seq(1,2,3,4,5,6,7,8,9,10)
    val s2 = Seq(4,5,6,7,8,9,10,11,12,13)
    val s3 = Seq(7,8,9,10,11,12,13,15,16)
    println(getCommonElements (s1,s2,s3))

//  val s1 = (1 to 10).toVector
//  val s2: Int = s1.foreach(el => el +2)
//    println(s2)

//    val s1 = (1 to 10).toVector
//    val s2 = (3 to 13).toVector
//    val s3 = (5 to 15).toVector
//    println(getCommonElements)



  def isPangram(text: String, alphabet : String = "abcdefghijklmnopqrstuvwxyz"): Boolean= {
    //TODO determine if the sentence contains all English letters
    //https://en.wikipedia.org/wiki/Pangram
    // (case is not important here)
    //this function should work on other languages too, if we pass it different alphabet
    //alphabet.toSet.subsetOf(text.toLowerCase().toSet)
    text.replace(" ", "").toLowerCase.toSet == alphabet.toSet
  }

  println(isPangram("The five boxing wizards jump quickly")) //should be true
}
