package rivercrossing

import scala.collection.Searching._
import scala.math.Ordering.by

object RiverCrossing {
  def crossRiver(width: Int, stones: List[Int], velocity: Int): Option[List[Int]] = {
    def crossRiver(position: Int, stones: List[Int], velocity: Int): Option[List[Int]] = position match {
      case p if p > width => None
      case `width` => Some(Nil)
      case _ => stones.search(position) match {
        case Found(stoneIndex) =>
          val newStones = stones.drop(stoneIndex + 1)
          (-1 to 1)
            .map(velocity + _)
            .filter(_ > 0)
            .flatMap(v => crossRiver(position + v, newStones, v))
            .reduceOption(by((_: List[Int]).length).min)
            .map(position :: _)
        case _ => None
      }
    }
    crossRiver(-1, -1 :: stones, velocity).map(_.tail)
  }
}
