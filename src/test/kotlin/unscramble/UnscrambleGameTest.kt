package unscramble

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import sun.font.TrueTypeFont

class UnscrambleGameTest {

    @Test
    fun `randomWord method returns a single 5 letter word`() {
        val underTest = UnscrambleGame()
        val expected: Int = 5
        val result: Int  = underTest.randomWord().length
        assertEquals(expected, result)
    }

    @Test
    fun `randomWord method returns a word from within the hard coded data`() {
        val underTest = UnscrambleGame()
        val data: List<String> = listOf("pound", "trice", "hired", "comma", "logic")
        val expected: Boolean = true
        val result: Boolean = underTest.randomWord() in data
        assertEquals(expected, result)
    }

    @Test
    fun `jumbledWord method returns a when given a`() {
        val underTest = UnscrambleGame()
        val expected: String = "a"
        val result: String = underTest.jumbleWord("a")
        assertEquals(expected, result)
    }

    @Test
    fun `jumbledWord method returns a jumbled version of a longer string`() {
        val underTest = UnscrambleGame()
        val expected: String = "ehllo"
        val result: String = underTest.jumbleWord("hello").toCharArray().sorted().joinToString("")
        assertEquals(expected, result)
    }

    @Test
    fun `jumbledWord method does not return the original word`() {
        val underTest = UnscrambleGame()
        val unexpected: String = "goodbye"
        val result: String = underTest.jumbleWord("goodbye")
        assertNotEquals(unexpected, result)
    }

    @Test
    fun `parseInput method sets victory to true when the words match`() {
        val underTest = UnscrambleGame()
        val expected: Boolean = true
        underTest.word = "hello"
        underTest.parseInput("hello")
        val result: Boolean = underTest.victory
        assertEquals(expected, result)
    }
//    @Test
//    fun `unscramble method flags victory as true when words match`() {
//        val underTest = UnscrambleGame()
//        underTest.word = "hello"
//        underTest.randomised = "leloh"
//        val expected: Boolean = true
//        underTest.unscramble()
//        val result: Boolean = underTest.victory
//        assertEquals(expected, result)
//    }
}