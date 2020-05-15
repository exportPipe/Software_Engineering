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

}
