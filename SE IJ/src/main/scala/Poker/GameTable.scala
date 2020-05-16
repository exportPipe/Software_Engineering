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
    if (!bet(smallBlind, $S) || !bet(bigBlind, $B)) return false
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
      case 1 => return call(player)
      case 2 => return check(player)
      case 3 => return fold(player)
      case _ => return raise(player, pick)
    }
     false
  }
  // ---------------------------------------------------------------------- CALL / CHECK / FOLD / RAISE / BET
  def call(player: Player): Boolean = {
    if (beforeActive(player).currBet.equals(player.currBet)) {
      println("check instead")
      check(player: Player)
    } else if (bet(player, beforeActive(player).currBet - player.currBet)) {
      return true
    }
    false
  }

  def check(player: Player): Boolean = {
    if (beforeActive(player).currBet <= player.currBet) {
      return true
    }
    println("! You got the option call, fold or raise")
    false
  }

  def fold(player: Player): Boolean = {
    player.active = false
    true
  }

  def raise(player: Player, $amount: Int): Boolean = {
    if (((beforeActive(player).currBet * 2) <= $amount) && ($amount >= $B )) {
      if (bet(player, $amount - player.currBet)) return true
    }
    println("! You cannot bet this amount")
    false

  }

  def bet(player: Player, amount: Int): Boolean = {
    if (amount >= player.credit) return false
    player.credit -= amount
    player.currBet += amount
    true
  }
// -----------------------------------------------------------------------------------
  def checkPlayerCredits(): Unit = {
    for (x <- player)
      if (x.credit <= 0) x.active = false
  }


}
