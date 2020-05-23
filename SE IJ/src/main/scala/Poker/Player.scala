package Poker

case class Player(var $credit: Int = 500, var $currBet: Int = 0, var isActive: Boolean = true, holeCardsA: Array[Card]) {

  val id: Int = Player.newID
  def setCredit(credit: Int): Unit = $credit = credit
  def setCurrBet(currBet: Int): Unit = $currBet = currBet
  def setActive(active: Boolean): Unit = isActive = active

  def getCredit: Int = $credit
  def getCurrBet: Int = $currBet
  def getActive: Boolean = isActive
  override def toString: String = s"Player $id"
}
object Player {
  private var idNum = 0
  private def newID: Int = {idNum += 1
    idNum}
}