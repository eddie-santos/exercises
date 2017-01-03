// Question 1

def max(nums: (Int,Int,Int)): Int = {
  def twoMax(a: Int, b: Int): Int = {
    if (a > b) a
    else b
  }
  twoMax(nums._1,twoMax(nums._2,nums._3))
}

max((7,5,3))

// Question 2

import util.Random.nextInt

def max(a: Int, b: Int): Int = {
  if (a > b) a else b
}

def min(a: Int, b: Int): Int = {
  if (a < b) a else b
}

def second(a: Int, b:Int): Int = b


val one: Int = nextInt()
val two: Int = nextInt()

max(one,two)
min(one,two)
second(one,two)

// Question 3

def func(x: Int): (Int => Int) = {
  a => a * x
}

func(2)(8)

// Question 4

def fzero[A](x: A)(f: A => Unit): A = { f(x); x }

fzero(3)(x => println(x*x))

// Question 5

def square(m: Double): Double = m * m
val sq = square _
val sq2: Double => Double = square

sq(4)
sq2(5)

// Question 6

def conditional[A](x: A)(p: A => Boolean, f: A => A): A = {
  if (p(x)) f(x)
  else x
}

conditional[Int](4)(_ > 3, _ * 2)
conditional[Int](2)(_ > 3, _ * 2)

// Question 7

for (i <- 1 to 100) {
  val a = conditional[Int](i)(_ % 3 == 0, x => {print("type"); 0})
  val b = conditional[Int](i)(_ % 5 == 0, x => {print("safe"); 0})
  if (a > 0 && b > 0) print(i)
  println("")
}

def newConditional[A](x: A)(p: A => Boolean, f: A => String): String = {
  if (p(x)) f(x)
  else ""
}

for (i <- 1 to 100) {
  val a = newConditional[Int](i)(_ % 3 == 0, _ => "type")
  val b = newConditional[Int](i)(_ % 5 == 0, _ => "safe")
  val c = newConditional[Int](i)(_ % 3 > 0 && i % 5 > 0, x => s"$x")
  println(a+b+c)
}