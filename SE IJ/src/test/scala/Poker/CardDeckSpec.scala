package Poker

import model.{Card, CardDeck}
import org.scalatest._
import org.scalatest.matchers.should.Matchers

class CardDeckSpec extends WordSpec with Matchers {
    "A CardDeck" when {
        "new" should {
            val cd = new CardDeck
            "draw the top card" in {
            val top = cd.drawCard
            top.getClass isInstance Card
            }
        "renew if empty" in {
            cd.reNew()
            cd.cards.length.equals(52)
            }
        }
    }
}
