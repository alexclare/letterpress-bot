package me.rickychang.lpb.imageparser

import java.awt.image.BufferedImage
import scala.collection.immutable.List
import me.rickychang.lpb.board.GameBoard
import ParserUtil.getResizedDimension
import ParserUtil.getTileWidthHeight
import ParserUtil.resizeImage
import me.rickychang.lpb.board.TileState

class IPhone4Parser(cParser: TileCharParser) extends ScreenshotParser {
  
  val ScreenshotAspectRatio = 0.66666666666667f
 
  val charParser = cParser  

  val boardXOffsetRatio = 0.0f  
  
  val boardYStartOffsetRatio = 0.33333333333333f
  
  val boardYEndOffsetRatio = 1.0f

}
