package me.rickychang.lpb.board

import me.rickychang.lpb.board._

class GameBoard(val tiles: List[(Char, TileState, Int)]) {
  
  val (tileChars, tileStates, tileIndices) = tiles.unzip3
  
  val playerOccupiedTiles = tiles collect { case t: PlayerOccupied => t }
  val playerDefendedTiles = tiles collect { case t: PlayerDefended => t }
  val freeTiles = tiles collect { case t: Free => t }
  val opponentOccupiedTiles = tiles collect { case t: OpponentOccupied => t }
  val opponentDefendedTiles = tiles collect { case t: OpponentDefended => t }
  
  val playerTiles = (playerOccupiedTiles ++ playerDefendedTiles).sortBy(_._3)
  val opponentTiles = (opponentOccupiedTiles ++ opponentDefendedTiles).sortBy(_._3)
  
  val playerScore = playerTiles.map(_.currrentVal).sum
  val opponentScore = -opponentTiles.map(_.currrentVal).sum
  
}