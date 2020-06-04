package Poker.model

case class CardDeck() {

  def cardSeq: Seq[Card] = for {
    suit <- 1 to 4
    rank <- 1 to 13
  } yield Card(rank, suit)

  var cards: List[Card] = List.from(util.Random.shuffle(cardSeq))

  def drawCard: Card = {
    val ret = cards.head
    cards = cards.tail
    ret
  }

  def reNew(): Boolean = {
    cards = List.from(util.Random.shuffle(cardSeq))
    if (cards != Nil) return true
    false
  }
}

