import scala.util.matching.Regex

// Question 1

def centigradeToFahrenheit(cent: Double): Double = {
  (cent * 9/5) + 32
}

centigradeToFahrenheit(-77)

// Question 2

def centigradeToFahrenheitInt(cent: Double): Int = {
  ((cent * 9/5) + 32).toInt
}

centigradeToFahrenheitInt(-77)

// Question 3

def toOwe(x: Double): String = {
  f"You owe $$${x}%.2f"
}

toOwe(2.7255)

// Question 4

val flag: Boolean = false
val result: Boolean = !flag

// Question 5

val myInt: Int = 128
val myChar: Char = myInt.toChar
val myString: String = myInt.toString
val myDouble: Double = myInt.toDouble

myChar
myChar.toInt
myString
myString.toInt
myDouble
myDouble.toInt

// Question 6

def addressParse(line: String): (Int,Int,Int) = {
  val pattern: Regex = """.*([\d\d\d]-[\d\d\d]-[\d\d\d]).*""".r
  val pattern(phone) = line
}
