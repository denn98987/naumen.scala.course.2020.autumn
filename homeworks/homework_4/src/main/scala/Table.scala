import scala.collection.mutable.ArrayBuffer

class Table(val width: Int, val height: Int) {
  private val tableCells = ArrayBuffer.fill[Cell](width*height)(new EmptyCell)

  def getCell(ix: Int, iy: Int): Option[Cell] = {
    if(this.isOutOfRange(ix, iy))
      None
    else
      Some(tableCells(ix + iy*width))
  }
  def setCell(ix: Int, iy: Int, cell: Cell): Unit = {
    val index = ix + iy*width
    if(this.isOutOfRange(ix, iy))
      throw new IndexOutOfBoundsException
    tableCells(index) = cell
  }
  def isOutOfRange(ix: Int, iy: Int): Boolean = ix + iy*width >= width*height || ix < 0 || iy < 0
}