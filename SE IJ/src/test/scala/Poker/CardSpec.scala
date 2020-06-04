package Poker

import model.Card
import org.scalatest._
import org.scalatest.matchers.should.Matchers

class CardSpec extends WordSpec with Matchers {

  "A Card" when { "new" should {
    val card = Card(7, 3)
    "have a rank" in {
      card.rank should be(7)
    }
    "have a suit" in {
      card.suit should be(3)
    }
    "have a string representation" in {
      card.toString should be ("Eight of Hearts")
    }
    "compares to another card" in {
      card.compareTo(Card(6, 3)) should be (1)
      card.compareTo(Card(8, 1)) should be (-1)
      card.compareTo(Card(13, 4)) should be (-6)
    }
  }
  }
}