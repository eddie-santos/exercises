package MineSweeper
/**
  * Created by Eddie on 12/31/16.
  */


object MineSweeper {

  def main(args: Array[String]) = {
    val params: List[((Int, Int), Int)] = List(((2,2),2),
                                               ((9, 9), 10),
                                               ((16, 16), 40),
                                               ((16, 30), 99),
                                               ((24,30),667))
    for (p <- params) {
      val board: Board = new Board(p._1, p._2)
      println(board)
    }
  }

}

