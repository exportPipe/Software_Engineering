package Poker

case class CardDeck() {

  val deck: IndexedSeq[Card] = for {
    rank <- 1.to(13)
    suit <- 1.to(4)
  } yield Card(rank, suit)

  def restDeck = 0

}

