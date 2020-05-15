package Poker

case class Player(credit: Int = 500, currBet: Int = 0, isActive: Boolean = true) {
  val id: Int = Player.newID

  override def toString: String = s"Player $id"
}
object Player {
  private var idNum = 0
  private def newID: Int = {idNum += 1
    idNum}
}