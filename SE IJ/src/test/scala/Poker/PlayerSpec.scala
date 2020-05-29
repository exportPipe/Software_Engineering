package Poker

import org.scalatest._
import org.scalatest.matchers.should.Matchers

class PlayerSpec extends WordSpec with Matchers {
    "A Player" when {
      "new" should {
        val plr1 = new Player
        val plr2 = new Player
        "Player has a unique id" in {
          plr1.id.shouldNot(equal(0))
          plr1.id.shouldNot(equal(plr2.id))
        }
        "Player has vars" in {
          plr1.getActive should be (true)
          plr2.getCredit should be (500)
          plr1.getCurrBet should be (0)
        }
        "Player can have hole cards" in {
          val cd = new CardDeck
          val hc: List[Card] = List(cd.drawCard, cd.drawCard)
          plr1.setHoleCards(hc)
          plr1.getHoleCards shouldNot equal(Nil)
        }
      }
    }
}
