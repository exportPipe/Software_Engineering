package Poker

object Poker {
  def main(args: Array[String]): Unit = {
    println("Texas Holdem Poker")

    // String representation of a card
    val testcard = Card(2, 4)
    println(testcard.toString)
    // String representation of a deck
    val testdeck = new CardDeck
    println(
      testdeck.deck(1).toString
    )



  }
}
