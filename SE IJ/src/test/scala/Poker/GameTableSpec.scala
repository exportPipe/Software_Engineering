package Poker

import org.scalatest._
import org.scalatest.matchers.should.Matchers

class GameTableSpec extends WordSpec with Matchers {
  "Some GameOptions" when {
    "new" should {
      val cd = new CardDeck
      val tui = new TUI
      val plr: Array[Player] = Array(new Player, new Player, new Player)
      val gameTable = new GameTable(plr, cd, tui)
      val options = GameOptions(gameTable)

      "should have the right vars" in {
        gameTable.smallBlind should be (plr(0))
        gameTable.choicePlayer should be (plr(2))
        gameTable.nextActive(plr(0)) should be (plr(1))
        gameTable.beforeActive(plr(2)) should be (plr(0))
      }

      "should have player options" in {
        gameTable.options.bet(plr(2), 40) should be (true)
        gameTable.getPlayer(2).getCurrBet should be (40)
        gameTable.getPlayer(2).getCredit should be (460)

        gameTable.options.fold(gameTable.getPlayer(0))
        gameTable.getPlayer(0).getActive should be (false)

        //Skipping the fold player
        gameTable.nextActive(plr(2)) should be (plr(1))
      }
    }
  }
}
