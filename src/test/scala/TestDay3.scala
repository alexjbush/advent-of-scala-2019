import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TestDay3 extends AnyFunSpec with Matchers {

  describe("generatePositions") {
    it("First example") {
      Day3.generatePositions(List("R8", "U5", "L5", "D3")) should contain theSameElementsInOrderAs (
        List(
          (0, 1), (0, 2), (0, 3), (0, 4), (0, 5), (0, 6), (0, 7),
          (0, 8), (1, 8), (2, 8), (3, 8), (4, 8), (5, 8), (5, 9),
          (5, 8), (5, 7), (5, 6), (5, 5), (5, 4), (5, 3), (6, 3),
          (5, 3), (4, 3), (3, 3), (2, 3))
        )
    }
  }

  describe("findClosestCrossingPoint") {
    it("Second example") {
      val input1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51"
      val intput2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"
      Day3.findClosestCrossingPoint(input1, intput2) should be(135)
    }
  }

}
