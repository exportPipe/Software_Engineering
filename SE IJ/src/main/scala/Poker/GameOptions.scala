package Poker

case class GameOptions(gameTable: GameTable) {

  def call(player: Player): Boolean = {
    if (gameTable.beforeActive(player).currBet.equals(player.currBet)) {
      println("check instead")
      return check(player: Player)
    } else if (bet(player, gameTable.beforeActive(player).currBet - player.currBet)) {
      return true
    }
    false
  }

  def check(player: Player): Boolean = {
    if (gameTable.beforeActive(player).currBet <= player.currBet) {
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
    if (((gameTable.beforeActive(player).currBet * 2) <= $amount) && ($amount >= gameTable.$B )) {
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
}
