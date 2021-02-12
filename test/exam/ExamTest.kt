package exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExamTest {

    @Test
    fun testExample() {
        assertEquals(42, example("input/example.txt"))
    }

    @Test
    fun testMyExamTask() {
        assertEquals(listOf("(4.1, строка 1, столбец 1)", "(3.9, строка 3, столбец 2)"),
                myExamTask("input/examtest1.txt"))
        assertEquals("(3.9, строка 3, столбец 2)", myExamTask("input/examtest2.txt"))
    }
}