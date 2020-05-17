package Poker

case class TUI() {

  def initPlayer(): Array[Player] = {
    println("\nEnter number of player")
    val numberPlayer = scala.io.StdIn.readInt()
    printf(
      "Game starts with %d player", numberPlayer
    )
    val player: Array[Player] = new Array[Player](numberPlayer)
    for (i <- 0 until numberPlayer)
      player(i) = Player(holeCardsA = new Array[Card](2))
    player
  }

  def getChoice: Int = {
    val input = scala.io.StdIn.readLine().split(" ")
    input(0) match {
      case "q" => -2
      case "h" => -1
      case "call" => 1
      case "check" => 2
      case "fold" => 3
      case "raise" => input(1).toInt
      case _ =>
        println("wrong input\n")
        getChoice
    }
  }

  def printVars(gameTable: GameTable): Unit = {
    for (i <- gameTable.player.indices) {
      print(s"\n${gameTable.player(i)} (aktiv: ${gameTable.player(i).active})" +
        s"\t${gameTable.player(i).credit} credits\t(current bet: ${gameTable.player(i).currBet} credits)\t")
      print(s"${gameTable.player(i).holeCardsA(0)}, ${gameTable.player(i).holeCardsA(1)}")
      if (gameTable.player(i).id.equals(gameTable.choicePlayer.id)) print(" (*)")
    }
    println(s"\nPot: ${gameTable.pot}\tbefore active: ${gameTable.beforeActive(gameTable.choicePlayer)}" +
      s" (with ${gameTable.beforeActive(gameTable.choicePlayer).currBet})")
  }

  def printHelp(): Unit = {
    println("---\toptions:\ncall\t->\tmatch the current bet amount made by a previous player " +
      "(if equal, automatic check instead)\ncheck\t->\tpass the action to the next player " +
      "(if bet amount equal to previous)\nfold\t->\tdiscard your hand and become inactive for this round" +
      "\nraise <amount>\t->\traise to a specified integer amount\n")
  }
}
