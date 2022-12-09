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

    // val coins: (Int) -> String = { quantity ->
    //     "$quantity quarters"
    // }

    // val coins: (Int) -> String = {
    //     "$it quarters" //變更 "$quantity quarters" 字串範本，以使用 $it 參照單一參數
    // }

    val cupcake: (Int) -> String = {
        "Have a cupcake!"
    }

    // val treatFunction = trickOrTreat(false, coins)
    // val treatFunction = trickOrTreat(false, { "$it quarters" })
    val treatFunction = trickOrTreat(false){ "$it quarters" }
    val trickFunction = trickOrTreat(true, cupcake)
    val trickFunction_null = trickOrTreat(true, null)
    treatFunction()
    trickFunction()
    trickFunction_null()

    repeat(5) {
        treatFunction()
    }
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