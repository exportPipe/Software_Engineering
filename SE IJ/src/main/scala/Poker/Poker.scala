package Poker

object Poker {
  def main(args: Array[String]): Unit = {
    println("Texas Holdem Poker by Niklas and Paul")
    // String representation of a deck
    val cardDeck = new CardDeck

    for (i <- 0 to 51) println {
      cardDeck.drawCard
    }
    cardDeck.reNew()
    // TUI for early game control
    val tui = new TUI
    // Player
    val player: Array[Player] = tui.initPlayer()
    // GameTable -> controll flow
    val gameTable = new GameTable(player, cardDeck, tui)
    gameTable.startRound()
  }
}
