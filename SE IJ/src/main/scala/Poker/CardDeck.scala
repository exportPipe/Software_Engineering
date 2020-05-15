package Poker

case class CardDeck() {

  val deck: IndexedSeq[Card] = for {
    suit <- 1.to(4)
    rank <- 1.to(13)
  } yield Card(rank, suit)

  def restDeck = 0

}

