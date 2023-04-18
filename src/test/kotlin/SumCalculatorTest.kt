import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

/**
 * Тестовый класс для проверки метода calculateSum() класса SumCalculator
 */
class SumCalculatorTest {
    private val sumCalculator = SumCalculator()

    /**
     * Метод для проведения параметризованных тестов
     */
    @ParameterizedTest
    @DisplayName("Тестирование метода calculateSum() класса SumCalculator")
    @MethodSource("calculateSumProvider")
    fun testCalculateSum(listDouble: List<Double?>, expected: Double, message: String) {
        try {
            val actualOutput: String = sumCalculator.convertToFormattedString(sumCalculator.calculateSum(listDouble), 2)
            assertEquals(
                sumCalculator.convertToFormattedString(expected, 2),
                actualOutput, TEST_FAILED_MESSAGE.format(message, listDouble)
            )
        } catch (e: NullPointerException) {
            org.junit.jupiter.api.fail(message = "Test failed. $message. Original list: $listDouble.")
        }
    }

    companion object {
        // Сообщение о том, что тест упал
        private const val TEST_FAILED_MESSAGE = "Test failed. %s. Original list: %s"

        // Сообщение о том, что функция выдала неверную сумму элементов в исходном списке
        private const val OUTPUT_FAILED_MESSAGE = "Function produced an incorrect sum of elements in the original list"

        /**
         * Метод-провайдер данных для параметризованных тестов
         */
        @JvmStatic
        fun calculateSumProvider(): Stream<Arguments?> {
            return Stream.of(
                Arguments.of(
                    listOf(4.05, 5.00, 2.00, 4.99), 47.80,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(13.31, 3.98, 12.0, 2.99, 9.0), 22.09,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    mutableListOf(null), 0.0,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(25.01, 24.99, 25.00), 25.005,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf<Double>(), 0.0,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(24.99, 15.55, 5.01, 5.00, 4.99, 1.00, 0.0, 0.01, null), 38.18,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(25.01, 99.99, 101.00, 999.99, 1001.00, 9999.99, 10001.00, 99999.99, 1000001.01), 12.505,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(23.9, 21.2, 19.3, 17.1, null, 15.6, 13.3, 11.6, 9.9, 7.8, 5.9, 3.1), 72.8,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(
                        26.00, 100000.00, 10000.00, 10000.00, null, 1000.00,
                        1000000.01, 100.01, 1000000.00, 100.00, 1000001.01,
                    ), 0.0,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(0.00, 0.01, 1.00, null, 2.99, 9.99, 24.99, null, 25.00, 25.01), 39.4402,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(25.00, null, null, 25.00, null, 25.00, 25.00, 25.00, 25.00, 25.00), 87.5,
                    OUTPUT_FAILED_MESSAGE
                ),
                Arguments.of(
                    listOf(1000000.00, 100000.00, null, 10000.00, null, 1000.00, null, 100.00, 26.01), 0.0,
                    OUTPUT_FAILED_MESSAGE
                ),

                )
        }
    }
}
