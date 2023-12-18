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
        val result: Int  = underTest.randomWord().length
        assertEquals(expected, result)
    }

    @Test
    fun `randomWord method returns a word from within the hard coded data`() {
        val data: List<String> = listOf("pound", "trice", "hired", "comma", "logic")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val expected: Boolean = true
        val result: Boolean = underTest.randomWord() in data
        assertEquals(expected, result)
    }

//    @Test
//    fun `jumbledWord method returns a jumbled version of a complex string`() {
//        val data: List<String> = listOf("hello")
//        val mockRepository = Mockito.mock(FileUtils::class.java)
//        Mockito.`when`(mockRepository.readFile("words.txt")).thenReturn(data)
//        val underTest = UnscrambleGame(mockRepository)
//        val expected: String = "ehllo"
//        val result: String = underTest.jumbleWord(underTest.word).toCharArray().sorted().joinToString("")
//        assertEquals(expected, result)
//    }

    @Test
    fun `jumbledWord method does not return the original word`() {
        val data: List<String> = listOf("where")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val unexpected: String = "where"
        val result: String = underTest.jumbleWord(underTest.word)
        assertNotEquals(unexpected, result)
    }

    @Test
    fun `parseInput method sets victory to true when the words match`() {
        val data: List<String> = listOf("hello")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        Mockito.`when`(mockRepository.readFromPath("./words.txt")).thenReturn(data)
        val underTest = UnscrambleGame(mockRepository)
        val expected: Boolean = true
        underTest.parseInput("hello")
        val result: Boolean = underTest.victory
        assertEquals(expected, result)
    }
}