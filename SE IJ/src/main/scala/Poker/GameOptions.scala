package Poker

case class GameOptions(gameTable: GameTable) {

  def call(player: Player): Boolean = {
    if (gameTable.beforeActive(player).currBet.equals(player.currBet)) {
      println("check instead")
      check(player: Player)
    } else bet(player, gameTable.beforeActive(player).currBet - player.currBet)
  }

  def check(player: Player): Boolean = {
    gameTable.beforeActive(player).currBet <= player.currBet
  }

  def fold(player: Player): Boolean = {
    player.active = false
    true
  }

  def raise(player: Player, $amount: Int): Boolean = {
    if ((((gameTable beforeActive player).currBet * 2) <= $amount) && ($amount >= gameTable.$B )) {
      return(bet(player, $amount - player.currBet))
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
