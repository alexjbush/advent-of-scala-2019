import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

class TestDay3 extends AnyFunSpec with Matchers {

  describe("generatePositions"){
    it("First example"){
      Day3.generatePositions(List("R8","U5","L5","D3")) should contain theSameElementsInOrderAs(List((0,0), (0,8), (5,8), (5,3), (2,3)))
    }
  }

  describe("findClosestCrossingPoint"){
    it("Second example"){
      val input1 = "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51".split(',').toList
      val intput2 = "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7".split(',').toList
      Day3.findClosestCrossingPoint(input1, intput2) should be (135)
    }
  }

}
