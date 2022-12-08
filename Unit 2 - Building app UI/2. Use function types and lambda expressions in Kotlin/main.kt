// fun main() {
//     val trickFunction = ::trick
// }

// fun trick() {
//     println("No treats!")
// }


// fun main() {
//     val trickFunction = trick
//     trick()
//     trickFunction()
//     treat()
// }

// val trick = {
//     println("No treats!")
// }

// val treat: () -> Unit = {
//     println("Have a treat!")
// }

fun main() {

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    val treatFunction = trickOrTreat(false, coins)
    val trickFunction = trickOrTreat(true, cupcake)
    val trickFunction_null = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
    trickFunction_null()
}

fun trickOrTreat(isTrick: Boolean, extraTreat:  ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        if (extraTreat != null)
            println(extraTreat(5))
        return treat
    }
}

val trick = {
    println("No treats!")
}

val treat = {
    println("Have a treat!")
}