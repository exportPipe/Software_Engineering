case class Card(rank: Int, suit: Int) {

  override def toString: String = {
    var s = ""
    rank match {
      case 1 => s = "Two"
      case 2 => s = "Three"
      case 3 => s = "Four"
      case 4 => s = "Five"
      case 5 => s = "Six"
      case 6 => s = "Seven"
      case 7 => s = "Eight"
      case 8 => s = "Nine"
      case 9 => s = "Ten"
      case 10 => s = "Jack"
      case 11 => s = "Queen"
      case 12 => s = "King"
      case 13 => s = "Ace"
      case _ =>
        println("INVALID CARD RANK")
        return s
    }
    suit match {
      case 1 => s + " of Clubs"      // Kreuz
      case 2 => s + " of Spades"     // Pik
      case 3 => s + " of Hearts"     // Herz
      case 4 => s + " of Diamonds"   // Karo
      case _ =>
        println("INVALID CARD SUIT")
        s
    }
  }
}


case class CardDeck() {


  def deck: Array[Card] = new Array[Card](52)
  def restDeck = 0;

  def fillDeck = {
    var count = 0
    for (x <- 1.until(13)) {
      for (y <- 1.until(4)) {
        print(x, y)
        deck(count) = Card(x, y)
        count += 1
      }
    }
  }


}

var cd = new CardDeck
cd.fillDeck
cd.deck(1)