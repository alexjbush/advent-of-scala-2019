object Day1 {

  def main(args: Array[String]): Unit = {

    def getInput = io
      .Source
      .fromResource("day1.txt")
      .getLines()
      .map(_.toInt)

    println(s"part1: ${getInput.map(fuelRequiredForMass(_)).sum}")
    println(s"part2: ${getInput.map(fuelRequiredForMass(_, true)).sum}")

  }

  def fuelRequiredForMass(mass: Int, includeMassOfFuel: Boolean = false): Int = {
    val fuel = math.floor(mass / 3.0).toInt - 2
    if (includeMassOfFuel && fuel > 0) fuel + fuelRequiredForMass(fuel, includeMassOfFuel)
    else fuel max 0
  }

}
