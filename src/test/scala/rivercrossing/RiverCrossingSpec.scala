package rivercrossing

import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.TableDrivenPropertyChecks
import rivercrossing.RiverCrossing.crossRiver

class RiverCrossingSpec extends PropSpec with TableDrivenPropertyChecks with Matchers {

  val testCases =
    Table(
      ("width", "stones", "velocity", "path"),
      //
      (0, Nil, 0, Some(Nil)),
      (0, Nil, 1, Some(Nil)),
      (0, Nil, 2, Some(Nil)),
      (0, Nil, 3, None),
      //-
      (1, Nil, 0, None),
      (1, Nil, 1, Some(Nil)),
      (1, Nil, 2, Some(Nil)),
      (1, Nil, 3, Some(Nil)),
      (1, Nil, 4, None),
      //#
      (1, List(0), 0, Some(List(0))),
      (1, List(0), 1, Some(Nil)),
      (1, List(0), 2, Some(Nil)),
      (1, List(0), 3, Some(Nil)),
      (1, List(0), 4, None),
      //--
      (2, Nil, 1, None),
      (2, Nil, 2, Some(Nil)),
      (2, Nil, 3, Some(Nil)),
      (2, Nil, 4, Some(Nil)),
      (2, Nil, 5, None),
      //#-
      (2, List(0), 0, Some(List(0))),
      (2, List(0), 1, Some(List(0))),
      (2, List(0), 2, Some(Nil)),
      (2, List(0), 3, Some(Nil)),
      (2, List(0), 4, Some(Nil)),
      (2, List(0), 5, None),
      //-#
      (2, List(1), 0, None),
      (2, List(1), 1, Some(List(1))),
      (2, List(1), 2, Some(Nil)),
      (2, List(1), 3, Some(Nil)),
      (2, List(1), 4, Some(Nil)),
      (2, List(1), 5, None),
      //##
      (2, List(0, 1), 0, Some(List(0))),
      (2, List(0, 1), 1, Some(List(0))),
      (2, List(0, 1), 2, Some(Nil)),
      (2, List(0, 1), 3, Some(Nil)),
      (2, List(0, 1), 4, Some(Nil)),
      (2, List(0, 1), 5, None),
      //###
      (3, List(0, 1, 2), 0, Some(List(0, 1))),
      (3, List(0, 1, 2), 1, Some(List(1))),
      (3, List(0, 1, 2), 2, Some(List(1))),
      (3, List(0, 1, 2), 3, Some(Nil)),
      (3, List(0, 1, 2), 4, Some(Nil)),
      (3, List(0, 1, 2), 5, Some(Nil)),
      (3, List(0, 1, 2), 6, None),
      //###--
      (5, List(0, 1, 2), 1, Some(List(0, 2))),
      //#-#--
      (5, List(0, 2), 0, Some(List(0, 2))),
      //-##-#---
      (8, List(1, 2, 4), 3, Some(List(1, 4))),
      //----#---#--#-
      (13, List(4, 8, 11), 5, Some(List(4, 8))),
      //5050*#
      (5050, (0 to 99).toList, 0, Some((0 to 99).toList))
    )

  property("crossRiver should return correct value") {
    forAll(testCases) { (width: Int, stones: List[Int], velocity: Int, path: Option[List[Int]]) =>
      crossRiver(width, stones, velocity) should be (path)
    }
  }

}
