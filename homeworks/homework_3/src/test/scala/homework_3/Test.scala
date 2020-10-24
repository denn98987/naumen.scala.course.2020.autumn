package homework_3

import utest._

object Test extends TestSuite{

    val tests = Tests{
        'test_example - {
            val trueStr = "правда"
            assert(Exercises.prettyBooleanFormatter1(true) == trueStr)
        }
        'test_task1 - {
            val falseStr = "ложь"
            assert(Exercises.prettyBooleanFormatter1(12) == "12")
            assert(Exercises.prettyBooleanFormatter2(false) == "ложь")
            assert(Exercises.prettyBooleanFormatter2(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(true) == "правда")
            assert(Exercises.prettyBooleanFormatter3(false) == "ложь")
        }
        'test_task2 - {
            assert(Exercises.max1(Seq(1, 2, 3)) == 3)
            assert(Exercises.max2(Seq()) == Seq())
            assert(Exercises.max3(Seq()).isEmpty)
        }
        'test_task3 - {
            assert(Exercises.sum1(1, 2) == 3)
            assert(Exercises.sum2(1, 3) == 4)
            assert(Exercises.sum3(1, 4) == 5)
        }
    }
}
