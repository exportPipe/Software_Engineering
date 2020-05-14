package Poker

object Poker {
  def main(args: Array[String]): Unit = {
    println("Texas Holdem Poker")

    val testdeck = new CardDeck
    testdeck.fillDeck
    print(testdeck.deck(5).toString)


  }
}
