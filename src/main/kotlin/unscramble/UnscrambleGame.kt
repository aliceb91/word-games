package unscramble

class UnscrambleGame {

    private val wordList: List<String> = listOf(
        "pound",
        "trice",
        "hired",
        "comma",
        "logic"
    )
    var word: String = randomWord()
    var randomised: String = jumbleWord(word)
    var victory: Boolean = false

    fun unscramble() {
        // val word = randomWord()
        // val randomised = jumbleWord(word)
        // val input = readLine()
        // if input == word, Congratulations! you win, exitProcess()
        // else Oh no! That's not the correct word, exitProcess()
        println("Your jumbled word is: $randomised")
        print("Take a guess: ")
        val userInput: String = readln()
        parseInput(userInput)
        println("Exiting program now...")
        kotlin.system.exitProcess(0)
    }

    fun randomWord(): String {
        return wordList.shuffled()[0]
    }

    fun jumbleWord(word: String): String {
        var shuffledWord: String = word
        while (shuffledWord == word && word.length != 1) {
            shuffledWord =
                word
                .toCharArray()
                .toList()
                .shuffled()
                .joinToString("")
        }
        return shuffledWord
    }

    fun parseInput(input: String): Unit {
        if (input == word) {
            println("Congratulation! Your guess of $input was correct!")
            victory = true
        } else {
            println("Oh no! Your guess of $input was incorrect!")
            victory = false
        }
    }
}