import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object Exercises {


  def reverse[T](seq: Seq[T]): Seq[T] = seq.reverse

  /**
   * https://ru.wikipedia.org/wiki/Числа_Фибоначчи
   *
   * @param idx
   * @return
   */
  def fibonacci4Index(idx: Int): Int = {
    fibonacci(idx).last
  }

  def fibonacci(idx: Int): Seq[Int] = {
    val nums = ArrayBuffer(0, 1, 1)
    for (i <- 3 to idx) nums += (nums(i-1) + nums(i-2))
    nums
  }

  lazy val MORSE = Map("A" -> ".-", "B" -> "-...", "C" -> "-.-.", "D" -> "-..", "E" -> ".", "F" -> "..-.",
                       "G" -> "--.", "H" -> "....", "I" -> "..", "J" -> ".---", "K" -> "-.-", "L" -> ".-..",
                       "M" -> "--", "N" -> "-.", "O" -> "---", "P" -> ".--.", "Q" -> "--.-", "R" -> ".-.",
                       "S" -> "...", "T" -> "-", "U" -> "..-", "V" -> "...-", "W" -> ".--", "X" -> "-..-",
                       "Y" -> "-.--", "Z" -> "--..")

  def morse(text: String): String = text.split("").map(l => MORSE.getOrElse(l.toUpperCase, l)).mkString(" ")


  def wordReverse(text: String): String = text.split(" ").map {
    case word if word.filter(_.isLetter).head.isUpper =>
      word(word.lastIndexWhere(_.isLetter)).toUpper +
      word
        .dropRight(getNonLetterInd(word))
        .toLowerCase
        .reverse +
        word.takeRight( getNonLetterInd(word)-1)
    case word => word
      .dropRight(getNonLetterInd(word)-1)
      .toLowerCase
      .reverse +
      word.takeRight(getNonLetterInd(word)-1)
  }.mkString(" ")

  def getNonLetterInd(word: String) =  {
    word.length - word.lastIndexWhere(_.isLetter)
  }
}
