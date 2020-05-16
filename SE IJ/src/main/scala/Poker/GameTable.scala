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
    while (!player(idx).active) {
      nextActive(player(idx))
    }
    player(idx)
  }

  def beforeActive(currPlayer: Player) : Player = {
    val idx = currPlayer.id - 1
    if (idx.equals(0)) {
      if (player(player.length - 1).active) return player(player.length - 1)
      else beforeActive(player(player.length - 1))
    }
    if (player(idx - 1).active) return player(idx - 1)
    beforeActive(player(idx - 1))
  }

  def startRound(): Boolean = {
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
