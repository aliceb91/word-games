package unscramble

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito

class UnscrambleGameTest {

    @Test
    fun `randomWord method returns a single 5 letter word`() {
        val data: List<String> = listOf("hello", "cat", "goodbye")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val expected: Int = 5
        val result: Int  = underTest.randomWords(1)[0].length
        assertEquals(expected, result)
    }

    @Test
    fun `randomWord method returns a word from within the hard coded data`() {
        val data: List<String> = listOf("pound", "trice", "hired", "comma", "logic")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val expected: Boolean = true
        val result: Boolean = underTest.randomWords(1)[0] in data
        assertEquals(expected, result)
    }

    @Test
    fun `jumbledWord method does not return the original word`() {
        val data: List<String> = listOf("where")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val unexpected: String = "where"
        val result: String = underTest.jumbleWord(underTest.words[0])
        assertNotEquals(unexpected, result)
    }

    @Test
    fun `parseInput method sets victory to true when the words match`() {
        val data: List<String> = listOf("hello")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val expected: Boolean = true
        underTest.parseInput("hello", 0)
        val result: Boolean = underTest.victory
        assertEquals(expected, result)
    }

//    @Test
//    fun `parseInput method sets victory to false between guesses`() {
//        val data: List<String> = listOf("hello", "where")
//        val mockRepository = Mockito.mock(FileUtils::class.java)
//        val underTest = UnscrambleGame(mockRepository)
//        val expected1: Boolean = true
//        val expected2: Boolean = false
//        underTest.words = data
//
//    }
}