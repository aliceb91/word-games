package unscramble

class MainKt {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val game = UnscrambleGame()
            game.unscramble()
        }
    }
}