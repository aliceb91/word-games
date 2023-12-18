package unscramble

class MainKt {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val repository = FileUtils()
            val game = UnscrambleGame(repository)
            game.unscramble()
        }
    }
}