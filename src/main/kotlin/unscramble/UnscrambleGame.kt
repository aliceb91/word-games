package unscramble

class UnscrambleGame(fileUtils: FileUtils) {

    val repository = fileUtils
    private val wordList: List<String> = generateWords()
    var words: List<String> = randomWords(2)
    var victory: Boolean = false

    fun unscramble() {
        // val word = randomWord()
        // val randomised = jumbleWord(word)
        // val input = readLine()
        // if input == word, Congratulations! you win, exitProcess()
        // else Oh no! That's not the correct word, exitProcess()
        println("Welcome to Unscramble!")
        println("Try and unscramble these two words, you only get one shot at each!")
        runGame()
        println("Exiting program now...")
        kotlin.system.exitProcess(0)
    }

    fun randomWords(wordCount: Int): List<String> {
        return wordList.shuffled().take(wordCount)
    }

    fun jumbleWord(word: String): String {
        var shuffledWord: String = word
        while (shuffledWord == word) {
            shuffledWord =
                word
                .toCharArray()
                .toList()
                .shuffled()
                .joinToString("")
        }
        return shuffledWord
    }

    fun parseInput(input: String, index: Int): Unit {
        if (input == words[index]) {
            println("Congratulation! Your guess of $input was correct!")
            victory = true
        } else {
            println("Oh no! Your guess of $input was incorrect!")
            victory = false
        }
    }

    fun generateWords(): List<String> {
        return repository.readFromPath("./words.txt")
            .filter {
                it.length == 5
            }
    }

    fun runGame(): Unit {
        words.forEachIndexed {index, it ->
            val randomised = jumbleWord(it)
            println("Your jumbled word is: $randomised")
            print("Take a guess: ")
            val userInput: String = readln()
            parseInput(userInput, index)
        }
    }
}