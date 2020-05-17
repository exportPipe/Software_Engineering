package Poker

class GameTable (playerGT: Array[Player], cardsGT: CardDeck, tui: TUI) {
  def player: Array[Player] = playerGT
  def cards: CardDeck = cardsGT
  var $S = 10
  var $B = 20
  var pot = 0
  var smallBlind: Player = player(0)
  var bigBlind: Player = nextActive(smallBlind)
  var choicePlayer: Player = nextActive(bigBlind)
  val options: GameOptions = GameOptions(this)

  def nextActive(currPlayer: Player): Player = {
    val idx = currPlayer.id % player.length
    if (player(idx).active) return player(idx)
    nextActive(player(idx))
  }

  def beforeActive(currPlayer: Player) : Player = {
    val idx = currPlayer.id - 1
    if ((idx - 1) < 0) {
      if (player.last.active) {
        return player.last
      } else return beforeActive(player.last)
    }
    if (!player(idx - 1).active) return beforeActive(player(idx - 1))
    player (idx - 1)
  }

  def startRound(): Boolean = {
    for (plr <- player) {
      plr.holeCardsA(0) = cards.drawCard()
      plr.holeCardsA(1) = cards.drawCard()
    }
    checkPlayerCredits()
    if (!options.bet(smallBlind, $S) || !options.bet(bigBlind, $B)) return false
    tui.printVars(this)
    roundManager()
    true
  }

  def roundManager(): Boolean = {
    if(getPlayersInput(choicePlayer)) {
      choicePlayer = nextActive(choicePlayer)
      tui.printVars(this)
      roundManager()
    } else {
      tui.printVars(this)
      roundManager()
    }
    false
  }

  def getPlayersInput(player: Player): Boolean = {
    printf("\nEnter \"h\" for help\n")
    val pick = tui.getChoice
    pick match {
      case -2 => System.exit(0)
      case -1 => tui.printHelp()
      case 1 => return options.call(player)
      case 2 => return options.check(player)
      case 3 => return options.fold(player)
      case _ => return options.raise(player, pick)
    }
     false
  }

  def checkPlayerCredits(): Unit = {
    for (x <- player)
      if (x.credit <= 0) x.active = false
  }
}
