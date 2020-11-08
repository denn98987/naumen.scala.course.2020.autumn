object Exercises {
  trait Animal {
    def name: String
  }

  case class Cat(override val name: String) extends Animal

  case class Dog(override val name: String) extends Animal



  case class Shelter[+A <: Animal](animals:List[A]){
    def +[C >: A <:Animal](newAnimal: C) = Shelter(animals :+ newAnimal)
    def ++[C <: Animal](otherAnimals: Shelter[C]) = Shelter(animals ++ otherAnimals.animals)
    def getNames = animals.map(_.name)
    def feed(food: Food[A]) = animals.map(food.feed)
  }



  trait Food[-A<:Animal]{
    val name = "meat"
    def feed(animal: A) = s"${animal.name} eats ${this.name}"
  }

  case object Meat extends Food[Animal]

  case object Milk extends Food[Cat] {
    override val name: String = "milk"
  }

  case object Bread extends Food[Dog]{
    override val name: String = "bread"
  }
}
