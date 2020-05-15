package Poker

case class CardDeck() {

  val deckSeq: IndexedSeq[Card] = for {
    suit <- 1 to 4
    rank <- 1 to 13
  } yield Card(rank, suit)

  var deck: Array[Card] = Array.from(deckSeq)
  var restDeck = 0

  def mixCards(): Unit = {
    val random = scala.util.Random
    for(i <- 0 to 100) {
      val r1 = random.nextInt(52)
      val r2 = random.nextInt(52)
      val tmp = deck(r1)
      deck(r1) = deck(r2)
      deck(r2) = tmp
    }
  }

  def drawCard(): Card = {
    restDeck += 1
    deck(restDeck - 1)
  }
}

