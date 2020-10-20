package example

object Main extends App {
  val myName = "Dennis"
  val hellos = Map("eng" -> "Hello", "esp" -> "Hola", "ger" -> "Guten Tag")
  def sayHello(lang:String, name:String) = println(s"${hellos(lang)} Scala! This is ${name}")
  sayHello("esp", myName)
  sayHello("esp", myName.reverse)
}
