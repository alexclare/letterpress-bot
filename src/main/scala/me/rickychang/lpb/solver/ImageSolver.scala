package me.rickychang.lpb.solver

import javax.imageio.ImageIO
import java.io.File
import me.rickychang.lpb.imageparser.IPhone5BoardParser
import me.rickychang.lpb.imageparser.JavaOCRCharParser
import me.rickychang.lpb.imageparser.TileStateParser
import scala.collection.mutable.MutableList
import me.rickychang.lpb.imageparser.IPhone5Parser

/**
 * Utility object for testing solver against local images
 */
object ImageSolver {
  
  private val boardSolver = new BoardSolver(new WordDictionary)
  private val tileParser = new JavaOCRCharParser
  
  def findWords(imageFilePath: String, maxWords: Int): List[String] = {
    val boardImage = ImageIO.read(new File(imageFilePath))
    val imageParser = new IPhone5Parser(tileParser)
    val wordsToPlay = boardSolver.findWords(imageParser.getGameBoard(boardImage), maxWords).map { 
      case (w, t) => val (p, o) = boardSolver.scoreDeltas(t); "%s : +%d,%d".format(w, p, o) }
    wordsToPlay
  }

}