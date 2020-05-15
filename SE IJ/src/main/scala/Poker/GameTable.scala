package Poker

class GameTable (playerGT: Array[Player], cardsGT: CardDeck, tui: TUI) {
  def player: Array[Player] = playerGT
  def cards: CardDeck = cardsGT


  var smallBlind: Player = player(0)
  var bigBlind: Player = Player(1 % playerGT.length)

  def startRound(): Boolean = {
    tui.printVars(this)
    true
  }


}
