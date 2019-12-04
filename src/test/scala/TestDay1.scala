import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TestDay1 extends AnyFunSpec with Matchers {

  describe("fuelRequiredForMass") {

    it("Part1 last test") {
      Day1.fuelRequiredForMass(100756) should be(33583)
    }

    it("Part2 last test") {
      Day1.fuelRequiredForMass(100756, true) should be(50346)
    }

  }

}
