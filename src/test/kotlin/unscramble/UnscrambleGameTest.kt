package unscramble

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito
import com.github.stefanbirkner.systemlambda.SystemLambda.*

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
        val expected: String = "Congratulations! Your guess of hello was correct!"
        val result: String = tapSystemOut {
            underTest.parseInput("hello", 0)
        }.trim()
        assertEquals(expected, result)
    }

    @Test
    fun `parseInput method prints appropriately for multiple guesses`() {
        val data: List<String> = listOf("hello", "where")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        val underTest = UnscrambleGame(mockRepository)
        val expected1: String = "Congratulations! Your guess of hello was correct!"
        val expected2: String = "Oh no! Your guess of jello was incorrect!"
        underTest.words = data
        val result1: String =  tapSystemOut {
            underTest.parseInput("hello", 0)
        }.trim()
        val result2: String = tapSystemOut {
            underTest.parseInput("jello", 1)
        }.trim()
        assertEquals(expected1, result1)
        assertEquals(expected2, result2)
    }

    @Test
    fun `parseInput method parses non-alphabetic data and prints appropriately`() {
        val data: List<String> = listOf("hello", "where")
        val mockRepository = Mockito.mock(FileUtils::class.java)
        val underTest = UnscrambleGame(mockRepository)
        val expected1: String = "Oh no! Your guess of 1-2=-30;'11203- was incorrect!"
        val expected2: String = "Oh no! Your guess of   was incorrect!"
        underTest.words = data
        val result1: String = tapSystemOut {
            underTest.parseInput("1-2=-30;'11203-", 0)
        }.trim()
        val result2: String = tapSystemOut {
            underTest.parseInput(" ", 1)
        }.trim()
        assertEquals(expected1, result1)
        assertEquals(expected2, result2)
    }
}