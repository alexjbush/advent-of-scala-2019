import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TestDay2 extends AnyFunSpec with Matchers {

  describe("runProgram") {

    it("Part1 3rd example") {
      Day2.runProgram(Vector(2,4,4,5,99,0)) should contain theSameElementsInOrderAs(Vector(2,4,4,5,99,9801))
    }

    it("Part1 4th example") {
      Day2.runProgram(Vector(1, 1, 1, 4, 99, 5, 6, 0, 99)) should contain theSameElementsInOrderAs (Vector(30, 1, 1, 4, 2, 5, 6, 0, 99))
    }

  }

}
