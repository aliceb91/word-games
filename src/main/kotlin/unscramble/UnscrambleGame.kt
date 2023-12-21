package unscramble

class UnscrambleGame(fileUtils: FileUtils) {

    val repository = fileUtils
    private val wordList: List<String> = generateWords()

    fun generateWords(): List<String> {
        return repository.readFromPath("./words.txt")
            .filter {
                it.length == 5
            }
    }

    fun randomWords(wordCount: Int): List<String> {
        return wordList.shuffled().take(wordCount)
    }

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