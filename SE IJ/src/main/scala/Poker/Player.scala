package scala.Poker


case class Player() {
  var num = 0
  var cred = 0
  var active = true

  def setNumber(num: Int): Unit = {
    this.num = num
  } //END OF SETNUMBER

  def setCredit(cred: Int): Unit = {
    this.cred = cred
  } //END OF SETCREDIT

  def setActive(active: Boolean){
    this.active = active
  } //END OF SETACTIVE

} //END OF PLAYER CLASS
