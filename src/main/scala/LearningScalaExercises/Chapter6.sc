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
