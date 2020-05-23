package Poker

case class Player(var $credit: Int = 500, var $currBet: Int = 0, var isActive: Boolean = true,
                  var holeCards: List[Card] = Nil) {

  val id: Int = Player.newID
  def setCredit(credit: Int): Unit = $credit = credit
  def setCurrBet(currBet: Int): Unit = $currBet = currBet
  def setActive(active: Boolean): Unit = isActive = active
  def setHoleCards(hcs: List[Card]): Unit = holeCards = hcs

  def getCredit: Int = $credit
  def getCurrBet: Int = $currBet
  def getActive: Boolean = isActive
  def getHoleCards: List[Card] = holeCards
  override def toString: String = s"Player $id"
}
object Player {
  private var idNum = 0
  private def newID: Int = {idNum += 1
    idNum}
}