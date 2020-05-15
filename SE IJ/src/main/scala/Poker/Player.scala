package Poker

case class Player(cred: Int, active: Boolean) {
  val num = Player.newNum
} //END OF PLAYER CLASS
object Player {
  private var idNum = 0
  private def newNum = { idNum += 1 }
} //END OF COMPANION OBJECT PLAYER