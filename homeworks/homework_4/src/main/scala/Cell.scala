sealed trait Cell

class EmptyCell extends Cell{
  override def toString: String = "empty"
}
class NumberCell(number: Int) extends Cell{
  override def toString: String = number.toString
}
class StringCell(string: String) extends Cell{
  override def toString: String = string
}
class ReferenceCell(ix: Int, iy: Int, table: Table) extends Cell{
  override def toString: String = {
    if (table.isOutOfRange(ix, iy))
      "outOfRange"
    else {
        val value = getInnerCell
        value match {
          case cell: ReferenceCell => if ( cell.getInnerCell == this) "cyclic" else cell.toString
          case _ => value.toString
        }
    }
  }
  def getInnerCell: Cell = table.getCell(ix, iy).get
}

