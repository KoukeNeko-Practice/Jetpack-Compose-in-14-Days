class FillInTheBlankQuestion( // 填充題的類別
val questionText: String, val answer: String, val difficulty: String)

class TrueOrFalseQuestion( // 是非題的類別
val questionText: String, val answer: Boolean, val difficulty: String)

class NumericQuestion( //
val questionText: String, val answer: Int, val difficulty: String)

data class Question<T>(
    val questionText: String, 
    val answer: T, 
    val difficulty: Difficulty
    )

enum class Difficulty {
    EASY,
    MEDIUM,
    HARD
}

object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

class Quiz {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }

}

val Quiz.StudentProgress.progressText: String
        get() = "${answered} of ${total} answered."
        //注意：擴充功能屬性無法儲存資料，因此只能使用 get。

fun Quiz.StudentProgress.printProgressBar() {
    repeat(Quiz.answered) { print("▓") }
    repeat(Quiz.total - Quiz.answered) { print("▒") }
    println()
    println(Quiz.progressText)
}        

fun main() {
    // val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
    // val question2 = Question<Boolean>("The sky is green. True or false", false, "easy")
    // val question3 = Question<Int>("How many days are there between full moons?", 28, "hard")
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moons?", 28, Difficulty.HARD)
    println(question1.toString())
    println(question2.toString())
    println(question3.toString())
    println("${StudentProgress.answered} of ${StudentProgress.total} answered.")
    println("${Quiz.answered} of ${Quiz.total} answered.")
    println(Quiz.progressText)
    Quiz.printProgressBar()
    // val quiz = Quiz()
    // quiz.printQuiz()

    // val quiz = Quiz().apply { 
    //     printQuiz()
    //  }

    Quiz().apply { 
        printQuiz()
    }
}
