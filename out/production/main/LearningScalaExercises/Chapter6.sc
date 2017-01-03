// Question 1
for (i <- 0L to 20L if i % 2 == 1) yield i
0L to 20L filter (_ % 2 == 1)
0L to 9L map (_ * 2 + 1)
// Question 2
def factors(num: Int): List[Int] = {
  for(i <- List.range(2,num) if num % i == 0) yield i
}
def factorsList(nums: List[Int]) = {
//  nums map factors flatten
//  nums.map(factors).flatten
  nums.flatMap(factors)
}
factors(9)
factorsList(List(9,11,13,15))

// Question 3
def firstFor[A](items: List[A], count: Int): List[A] = {
  { for (i <- 0 until count) yield items(i) }.toList
}

// def firstFold[A](items: List[A], count: Int): List[A] = {
//   items.foldLeft[List[A]](Nil) {
//     (a: List[A], i: Int) => if (a.size >= count) a else i :: Nil
//   }.reverse
// }
def firstRecursive[A](items: List[A], count: Int): List[A] = {
  if (count > 0 && items.tail != Nil) {
    items.head :: firstRecursive(items.tail, count - 1)
  }
  else Nil
}
val myList: List[Char] = List('t','h','a','n','k','s')
val ints: Int = 3
firstFor(myList,ints)
// firstFold(myList,ints)
firstRecursive(myList,ints)
// Question 4
def longest(myList: List[String]): String = {
  myList.sortBy(-_.size).head
}
def longestFold(myList: List[String]): String = {
  myList.fold("")((a,i) => if (a.size < i.size) i else a)
}
def longestReduce(myList: List[String]): String = {
  myList.reduce((a,i) => if (a.size < i.size) i else a)
}
val myStrings: List[String] = List("Hello","big","expert","dude","SANTA CLAUS","racecar")
longest(myStrings)
longestFold(myStrings)
longestReduce(myStrings)
// Question 5
def reverse[T](myList: List[T], output: List[T] = Nil): List[T] = {
  if (myList == Nil) output
  else reverse[T](myList.tail, myList.head :: output)
}
reverse[String](myStrings)

// Question 6

def palindrome(words: List[String]): (List[String],List[String]) = {
  var pals: List[String] = Nil
  var nonPals: List[String] = Nil
  def isPalindrome(word: String): Boolean = word == word.reverse
  for (w <- words) {
    if (isPalindrome(w)) pals :::= List(w)
    else nonPals :::= List(w)
  }
  (pals.reverse,nonPals.reverse)
}
def palindromePartition(words: List[String]): (List[String],List[String]) = {
  words.partition(s => (s == s.reverse))
}
palindrome(myStrings)
palindromePartition(myStrings)
// Question 7
val url =
  "http://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0"
val l: List[String] = io.Source.fromURL(url).getLines.toList
println( l(0) )