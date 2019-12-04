object Day2 {

  def main(args: Array[String]): Unit = {

    val source = io
      .Source
      .fromResource("day2.txt")
      .getLines()
      .mkString
      .split(',')
      .map(_.toInt)
      .toVector

    def getModifiedSource(a: Int, b: Int) = source
      .updated(1, a)
      .updated(2, b)

    println(s"Part1: ${runProgram(getModifiedSource(12, 2)).head}")

    (0 to 99)
      .flatMap(a =>
        (0 to 99).map((a, _))
      )
      .map { case (a, b) =>
        (a, b, runProgram(getModifiedSource(a, b)))
      }
      .find { case (_, _, r) => r(0) == 19690720 }
      .map { case (a, b, _) => 100 * a + b }
      .foreach(r => println(s"Part2: ${r}"))


  }

  def runProgram(input: Vector[Int]): Vector[Int] = {

    def loop(curr: Vector[Int], position: Int): Vector[Int] = curr(position) match {
      case 99 => curr
      case 1 => loop(performCalculation(curr, position, (a, b) => a + b), position + 4)
      case 2 => loop(performCalculation(curr, position, (a, b) => a * b), position + 4)
      case i => throw new RuntimeException(s"Unknown opt code $i")
    }

    loop(input, 0)

  }

  def performCalculation(curr: Vector[Int], position: Int, f: (Int, Int) => Int): Vector[Int] = {
    curr.updated(curr(position + 3), f(curr(curr(position + 1)), curr(curr(position + 2))))
  }

}
