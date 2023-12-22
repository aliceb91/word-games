package unscramble

class MainKt {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val repository = FileUtils()
            val game = UnscrambleGame(repository)
            var words: List<String> = game.randomWords(2)
            val randomised: List<String> = game.jumbleWords(words)
            var victory: Boolean = false
            var userInput: String = ""

            println("Welcome to Unscramble!")
            println("Try and unscramble these two words, you only get one shot at each!")
            randomised.forEachIndexed {index, it ->
                println("Your jumbled word is: $it")
                print("Type out your guess here: ")
                userInput = readln()
                victory = game.parseInput(userInput, words[index])
                if (victory == true) {
                    println("Congratulations! Your guess of $userInput was correct!")
                } else {
                    println("Oh no! Your guess of $userInput was incorrect!")
                    println("The correct answer was: ${words[index]}.")
                }
            }
            println("To keep playing, please run the application again.")
        }
    }
}