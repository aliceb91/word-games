package unscramble

class UnscrambleGame(fileUtils: FileUtils) {

    val repository = fileUtils
    private val wordList: List<String> = generateWords()

    fun unscramble() {
        // val word = randomWord()
        // val randomised = jumbleWord(word)
        // val input = readLine()
        // if input == word, Congratulations! you win, exitProcess()
        // else Oh no! That's not the correct word, exitProcess()
//        println("Welcome to Unscramble!")
//        println("Try and unscramble these two words, you only get one shot at each!")
//        runGame()
//        println("Exiting program now...")
//        kotlin.system.exitProcess(0)
    }

    fun generateWords(): List<String> {
        return repository.readFromPath("./words.txt")
            .filter {
                it.length == 5
            }
    }

    fun randomWords(wordCount: Int): List<String> {
        return wordList.shuffled().take(wordCount)
    }

//    fun runGame(words: List<String>): Unit {
//        words.forEachIndexed {index, it ->
//            val randomised = jumbleWord(it)
//            println("Your jumbled word is: $randomised")
//            print("Take a guess: ")
//            val userInput: String = readln()
//            parseInput(userInput, index)
//        }
//    }

    fun jumbleWords(words: List<String>): List<String> {
        return words.map {
            var shuffledWord: String = it
            while (shuffledWord == it) {
                shuffledWord =
                    it
                        .toCharArray()
                        .toList()
                        .shuffled()
                        .joinToString("")
            }
            shuffledWord
        }
    }

    fun parseInput(input: String, original: String): Boolean {
        if (input == original) {
            return true
        } else {
            return false
        }
    }
}