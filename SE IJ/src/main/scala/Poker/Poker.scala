package Poker

object Poker {
  def main(args: Array[String]): Unit = {
    println("Texas Holdem Poker\n")

    // String representation of a deck
    val testdeck = new CardDeck
    testdeck.mixCards()
    for (i <- 0 to 51)
      println(testdeck.drawCard().toString)

    // Testing continues indexing
    val p1 = new Player()
    val p2 = new Player()
    val p3 = new Player()
    print(p2.id)
  }
}
