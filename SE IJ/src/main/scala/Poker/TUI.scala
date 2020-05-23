package Poker

case class TUI() {

  def initPlayer(): Array[Player] = {
    println("\nEnter number of player")
    val numberPlayer = scala.io.StdIn.readInt()
    printf(
      "Game starts with %d player", numberPlayer
    )
    var plr = new Array[Player](numberPlayer)
    for (i <- 0.until(numberPlayer)) plr(i) = new Player()
    plr
  }

  def nrRounds: Int = {
    println("\nEnter number of rounds")
    scala.io.StdIn.readInt()
  }

  def getChoice: Int = {
    val input = scala.io.StdIn.readLine().split(" ")
    input(0) match {
      case "q" => -2
      case "h" => -1
      case "call" => 1
      case "check" => 2
      case "fold" => 3
      case "raise" =>
        if (input(1).toInt > 3) return input(1).toInt
        getChoice
      case _ =>
        println("wrong input\n")
        getChoice
    }
  }

  def printVars(gameTable: GameTable): Unit = {
    for (plr <- gameTable.getPlayer) {
      print(s"\n$plr (aktiv: ${plr.getActive})" +
        s"\t${plr.getCredit} credits\t(current bet: ${plr.getCurrBet} credits)\t")
      print(s"${plr.getHoleCards}")
      if (plr.id.equals(gameTable.choicePlayer.id)) print("\t(*)")
    }
    println(s"\nPot: ${gameTable.pot}\tbefore active: ${gameTable.beforeActive(gameTable.choicePlayer)}" +
      s" (with ${gameTable.beforeActive(gameTable.choicePlayer).getCurrBet})")
  }

  def printHelp(): Unit = {
    println("---\toptions:\ncall\t->\tmatch the current bet amount made by a previous player " +
      "(if equal, automatic check instead)\ncheck\t->\tpass the action to the next player " +
      "(if bet amount equal to previous)\nfold\t->\tdiscard your hand and become inactive for this round" +
      "\nraise <amount>\t->\traise to a specified integer amount\n")
  }
}
