package MineSweeper
/**
  * Created by Eddie on 12/31/16.
  */
class Board (val dimensions: (Int, Int), val mines: Int) {
  val (width,height): (Int, Int) = dimensions
  val start: Int = 1 // Since first step is always safe
  val end: Int = tilesRemaining(mines)

  def tiles: Int = width * height

  def tilesRemaining(step: Int): Int = {
    tiles - step + 1
  }

  def loss(step: Int): Double = {
    if (step == 1) 0
    else mines.toDouble / tilesRemaining(step)
  }

  def survival(step: Int): Double = {
    1 - loss(step)
  }

  def total(f: Int => Double, step: Int): Double = {
    if (step == 0) 1
    else f(step) * total(f,step-1)
  }

  def prob(step: Int): Double = {
    loss(step) * total(survival,step-1)
  }

  def expectedSteps: Double = {
    var sum: Double = 0
    for (i <- start to end) {
      sum += i * prob(i)
    }
    sum
  }

  override def toString: String = {
    f"dimensions: $dimensions, mines: $mines, expected steps: $expectedSteps%2.2f"
  }

}

