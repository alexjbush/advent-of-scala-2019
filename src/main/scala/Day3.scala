object Day3 {

  def main(args: Array[String]): Unit = {

    val input = io.Source.fromResource("day3.txt").getLines().toList

    println(s"Part1: ${findClosestCrossingPoint(input.head, input.tail.head)}")

  }

  def generatePositions(input: List[String]): List[(Int, Int)] = {
    input
      .map(v => (v.head, v.tail.toInt))
      .scanLeft(((0, 0), (0, 0))) {
        case ((_, (i, j)), ('U', c)) => ((i, j), (i + c, j))
        case ((_, (i, j)), ('D', c)) => ((i, j), (i - c, j))
        case ((_, (i, j)), ('R', c)) => ((i, j), (i, j + c))
        case ((_, (i, j)), ('L', c)) => ((i, j), (i, j - c))
      }
      .flatMap {
        case ((i1, j1), (i2, _)) if i1 != i2 => (i1 to i2 by (math.signum(i2 - i1))).map((_, j1))
        case ((i1, j1), (_, j2)) if j1 != j2 => (j1 to j2 by (math.signum(j2 - j1))).map((i1, _))
        case (v, _) => List(v)
      }

  }

  def findClosestCrossingPoint(input1: String, input2: String): Int = {
    generatePositions(input1.split(',').toList)
      .toSet
      .intersect(generatePositions(input2.split(',').toList).toSet)
      .filter(_ != (0, 0))
      .map { case (i, j) => i.abs + j.abs }
      .min
  }

}
