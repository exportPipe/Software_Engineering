package Poker

object Poker {
  def main(args: Array[String]): Unit = {
    println("Texas Holdem Poker\n")

    // String representation of a deck
    val testdeck = new CardDeck
    testdeck.mixCards()
    for (i <- 0 to 51)
      println(testdeck.drawCard().toString)
    val tui = new TUI
    val player: Array[Player] = tui.initPlayer()

  }
}
