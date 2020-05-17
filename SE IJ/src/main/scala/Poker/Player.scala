package Poker

case class Player($credit: Int = 500, $currBet: Int = 0, isActive: Boolean = true, holeCardsA: Array[Card]) {
  val id: Int = Player.newID
  var credit: Int = $credit
  var currBet: Int = $currBet
  var active: Boolean = isActive

  override def toString: String = s"Player $id"
}
object Player {
  private var idNum = 0
  private def newID: Int = {idNum += 1
    idNum}
}