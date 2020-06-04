package Poker.control

import Poker.model.{CardDeck, Player}
import Poker.view.TUI
import Poker.utils.Observable


class GameTable (player: Array[Player], cards: CardDeck, tui: TUI) extends Observable {
  var $S: Int = 10
  var $B: Int = 20
  var pot = 0
  def getPlayer: Array[Player] = player
  var smallBlind: Player = getPlayer(0)
  var bigBlind: Player = nextActive(smallBlind)
  var choicePlayer: Player = nextActive(bigBlind)
  def options: GameOptions = GameOptions(this)
  val numberRounds: Int = tui.nrRounds
  var count = 0

  def nextActive(currPlayer: Player): Player = {
    val idx = currPlayer.id % player.length
    if (player(idx).getActive) return player(idx)
    nextActive(player(idx))
  }

  def beforeActive(currPlayer: Player) : Player = {
    val idx = currPlayer.id - 1
    if ((idx - 1) < 0) {
      if (player.last.getActive) {
        return player.last
      } else return beforeActive(player.last)
    }
    if (!player(idx - 1).getActive) return beforeActive(player(idx - 1))
    player (idx - 1)
  }

  def startRound(): Boolean = {
    for (plr <- player) plr.setHoleCards(List(cards.drawCard, cards.drawCard))
    checkPlayerCredits()
    if (!options.bet(smallBlind, $S) || !options.bet(bigBlind, $B)) return false
    tui.printVars(this)
    notifyObserver()
    roundManager()
    true
  }

  def roundManager(): Boolean = {
    while (count < numberRounds) {
      if(getPlayersInput(choicePlayer)) {
        choicePlayer = nextActive(choicePlayer)
        count += 1
        tui.printVars(this)
        notifyObserver()
        roundManager()
      } else {
        tui.printVars(this)
        roundManager()
      }
    }
    true
  }

  def getPlayersInput(player: Player): Boolean = {
    printf("\nEnter \"h\" for help\n")
    val pick = tui.getChoice
    pick match {
      case -1 => tui.printHelp()
      case 1 => options.call(player)
      case 2 => options.check(player)
      case 3 => options.fold(player)
      case _ => options.raise(player, pick)
    }
  }

  def checkPlayerCredits(): Unit = {
    for (x <- player)
      if (x.getCredit <= 0) x.setActive(false)
  }
  notifyObserver()
}
