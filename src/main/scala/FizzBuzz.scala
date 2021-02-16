object FizzBuzz extends App {
  //TODO print a sequence on a screen of the following type
  // 1,2,3,4,Fizz,6, Buzz, 8, 9, Fizz, 11,....34, FizzBuzz, 36, ..., 99, Fizz
  //so the rules are if number divides by 5 and 7 print FizzBuzz
  //if divides by 5 print Fizz
  //if divides by 7 print Buzz
  //otherwise we print the number itself

  //so this exercise tests your ability to write conditionals and also to write a simple loop

  //this exercise is the first screener at an interview to see if a person can program


for (i <- 1 to 100) {
  if (i % 5 == 0 && i % 7 == 0) println("FizzBuzz")
  else if (i % 5 == 0) println("Fizz")
  else if (i % 7 == 0) println("Buzz")
  else println(i)
}
}