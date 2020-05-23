package Poker

case class GameOptions(gameTable: GameTable) {

  def call(player: Player): Boolean = {
    if (gameTable.beforeActive(player).getCurrBet.equals(player.getCurrBet)) {
      println("check instead")
      check(player: Player)
    } else bet(player, gameTable.beforeActive(player).getCurrBet - player.getCurrBet)
  }

  def check(player: Player): Boolean = {
    gameTable.beforeActive(player).getCurrBet <= player.getCurrBet
  }

  def fold(player: Player): Boolean = {
    player.setActive(false)
    true
  }

  def raise(player: Player, $amount: Int): Boolean = {
    if ((((gameTable beforeActive player).getCurrBet * 2) <= $amount) && ($amount >= gameTable.$B )) {
      return bet(player, $amount - player.getCurrBet)
    }
    println("! You cannot bet this amount")
    false
  }

  def bet(player: Player, amount: Int): Boolean = {
    if (amount >= player.getCredit) return false
    player.setCredit(player.getCredit - amount)
    player.setCurrBet(player.getCurrBet + amount)
    true
  }
}
