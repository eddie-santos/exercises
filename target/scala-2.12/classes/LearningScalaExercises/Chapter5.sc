// Question 1

def max[Int](nums: (Int,Int,Int)): Int = {
  def twoMax(a: Int, b: Int): Int = {
    if (a >= b) a
    else b
  }
  twoMax(nums._1,twoMax(nums._2,nums._3))
}

max((1,2,3))