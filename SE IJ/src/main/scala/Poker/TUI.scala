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
      player(i) = Player()
    player
  }

  def printVars(gameTable: GameTable): Unit = {
    for (i <- gameTable.player.indices)
      print(s"\n${gameTable.player(i)} (aktiv: ${gameTable.player(i).isActive}):" +
        s"\t${gameTable.player(i).credit} credits\tcurrent bet: ${gameTable.player(i).currBet} credits")
  }
}
