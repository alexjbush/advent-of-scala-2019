object Day3 {

  def generatePositions(input: List[String]): List[(Int, Int)] = {
    input
      .map(v => (v.head, v.tail.toInt))
      .scanLeft((0, 0)){
        case ((i, j), ('U', c)) => (i + c, j)
        case ((i, j), ('D', c)) => (i - c, j)
        case ((i, j), ('R', c)) => (i, j + c)
        case ((i, j), ('L', c)) => (i, j - c)
      }
  }

  def findClosestCrossingPoint(input1: List[String], input2: List[String]): Int = {
    generatePositions(input1)
      .toSet
      .intersect(generatePositions(input2).toSet)
      .filter(_ != (0,0))
      .map{ case (i, j) => i + j}
      .min
  }

}
