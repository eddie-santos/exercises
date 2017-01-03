// Question 1

def areaOfCircle(radius: Double): Double = {
  Math.PI * Math.pow(radius,2)
}

areaOfCircle(1)

// Question 2

def areaOfCircleString(radius: String): Double = {
  if (radius.isEmpty) areaOfCircle(0)
  else areaOfCircle(radius.toDouble)
}

areaOfCircleString("1")

// Question 3

def fives(start: Int, end: Int, step: Int): Unit = {
  if (start <= end) {
    println(start)
    fives(start+step,end,step)
  }
}

fives(5,50,5)

// Question 6

def timeConversion(time: Int): String = {
  val timeSecs: Int = time / 1000
  val days: Int = timeSecs/24/60/60
  val hours: Int = (timeSecs-days*24*60*60)/60/60
  val minutes: Int = (timeSecs-days*24*60*60-hours*60*60)/60
  val seconds: Int = timeSecs % 60
  s"days: $days, hours: $hours, minutes: $minutes, seconds: $seconds"
}

timeConversion(106270000)

// Question 7

def tupleFold[T](tup: (T,T)): T = tup._1

tupleFold[Int]((7,2))

// Question 8

def tupleExpand[A,B,C](tup: (A,B,C)): (A,String,B,String,C,String) = {
  (tup._1,tup._1.toString,tup._2,tup._2.toString,tup._3,tup._3.toString)
}

tupleExpand[Boolean,Double,String](true,22.25,"yes")
