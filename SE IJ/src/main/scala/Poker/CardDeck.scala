package Poker

case class CardDeck() {

  def deck: Array[Card] = new Array[Card](52)
  def restDeck = 0;

  def fillDeck: Unit = {
    var count = 0
    for (x <- 1.to(13)) {
      for (y <- 1.to(4)) {
        deck(count) = Card(x, y)
      }
    }
  }
}

