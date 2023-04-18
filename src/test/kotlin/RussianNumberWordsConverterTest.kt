import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

/**
 * Тестовый класс для проверки метода getNumberWord класса RussianNumberWords
 */
class RussianNumberWordsConverterTest {
    private val russianNumberWordsConverter = RussianNumberWordsConverter()

    /**
     * Метод для проведения параметризованных тестов
     */
    @ParameterizedTest
    @DisplayName("Тестирование метода calculateSum() класса RussianNumberWords")
    @MethodSource("getNumberWordProvider")
    fun testGetNumberWord(number: Int, expected: String, message: String) {
        val actualOutput: String = russianNumberWordsConverter.getNumberWord(number, StringBuilder())
        assertEquals(
            expected, actualOutput, FAILED_MESSAGE.format(message, expected, actualOutput)
        )
    }

    companion object {
        // Сообщение о том, что тест упал
        private const val FAILED_MESSAGE = "Test failed. %s"

        // Cообщение о том, что функция не смогла выполнить конвертацию заданного значения в ожидаемый формат
        private const val OUTPUT_FAILED_MESSAGE = "Function failed to convert %s to '%s'"
        private val numbersMap = mapOf(
            0 to "ноль",
            1 to "один",
            9 to "девять",
            10 to "десять",
            19 to "девятнадцать",
            20 to "двадцать",
            99 to "девяносто девять",
            100 to "сто",
            999 to "девятьсот девяносто девять",
            1000 to "одна тысяча",
        )

        /**
         * Метод-провайдер данных для параметризованных тестов
         */
        @JvmStatic
        fun getNumberWordProvider(): Stream<Arguments?> {
            return Stream.of(
                Arguments.of(
                    0, numbersMap[0],
                    OUTPUT_FAILED_MESSAGE.format(0, numbersMap[0])
                ),
                Arguments.of(
                    1, numbersMap[1],
                    OUTPUT_FAILED_MESSAGE.format(1, numbersMap[1])
                ),
                Arguments.of(
                    9, numbersMap[9],
                    OUTPUT_FAILED_MESSAGE.format(9, numbersMap[9])
                ),
                Arguments.of(
                    10, numbersMap[10],
                    OUTPUT_FAILED_MESSAGE.format(10, numbersMap[10])
                ),
                Arguments.of(
                    19, numbersMap[19],
                    OUTPUT_FAILED_MESSAGE.format(19, numbersMap[19])
                ),
                Arguments.of(
                    20, numbersMap[20],
                    OUTPUT_FAILED_MESSAGE.format(20, numbersMap[20])
                ),
                Arguments.of(
                    99, numbersMap[99],
                    OUTPUT_FAILED_MESSAGE.format(99, numbersMap[99])
                ),
                Arguments.of(
                    100, numbersMap[100],
                    OUTPUT_FAILED_MESSAGE.format(100, numbersMap[100])
                ),
                Arguments.of(
                    999, numbersMap[999],
                    OUTPUT_FAILED_MESSAGE.format(999, numbersMap[999])
                ),
                Arguments.of(
                    1000, numbersMap[1000],
                    OUTPUT_FAILED_MESSAGE.format(1000, numbersMap[1000])
                ),
            )
        }
    }
}
