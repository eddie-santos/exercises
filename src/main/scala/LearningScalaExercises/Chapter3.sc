

// Question 1

val name: String = ""
name match {
  case "" => "n/a"
  case _ => name
}

// Question 2

val amount: Double = 0

if (amount > 0) "greater"
else if (amount == 0) "zero"
else if (amount < 0) " less"
else "error"

amount match {
  case s if (s > 0) => "greater"
  case s if (s < 0) => "less"
  case s if (s == 0) => "zero"
}

// Question 3

val color = "magenta"

color match {
  case "cyan" => "00ffff"
  case "magenta" => "00ff00"
  case "yellow" => "ffff00"
  case x => {
    println(s"Didn't expect $x !")
    "333333"
  }
}

// Question 4

for (i <- 1 to 100 by 5) {
  for (j <- i to (i+4)) {
    print(s"$j, ")
  }
  println("")
}

// Question 5

for (i <- 1 to 100) {
  val num: String = i match {
    case x if (x % 3 == 0 && x % 5 == 0) => "typesafe"
    case x if (x % 3 == 0) => "type"
    case x if (x % 5 == 0) => "safe"
    case _ => i.toString
  }
  print(s"$num, ")
}