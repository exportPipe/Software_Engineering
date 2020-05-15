package Poker

case class Player(credit: Int = 500, isActive: Boolean = true) {
  val id: Int = Player.newID
}
object Player {
  private var idNum = 0
  private def newID: Int = {idNum += 1
    idNum}
}