import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

/**
 * Тестовый класс для проверки метода squareAllElementsExtension()
 */
class MutableListIntExtensionsTest {
    /**
     * Метод для проведения параметризованных тестов
     */
    @ParameterizedTest
    @DisplayName("Тестирование метода squareAllElementsExtension")
    @MethodSource("squareProvider")
    fun testSquareAllElementsExtension(mutableList: MutableList<Int>, expected: ArrayList<Int>, message: String) {
        val mutableCopyList = mutableList.toList()
        mutableList.squareAllElementsExtension()
        assertEquals(expected, mutableList, TEST_FAILED_MESSAGE.format(
            message,
            mutableCopyList.toString(),
            expected.zip(mutableList).filter { it.first != it.second }
        ))
    }

    companion object {
        // Сообщение о том, что тест упал
        private const val TEST_FAILED_MESSAGE = "Test failed. %s. Original list: %s, Mismatched elements: %s"

        // Сообщение о том, что функция неправильно обработала единственный элемент
        private const val POSITIVE_NUMBERS_FAILED_MESSAGE = "Function did not correctly square single element"

        // Сообщение о том, что максимально допустимое значение превышено
        private const val MAX_VALUE_ELEMENT_FAILED_MESSAGE = "The maximum allowable value has been exceeded %d"

        // Сообщение о том, что функция неправильно обработала единственный нулевой элемент
        private const val SINGLE_ZERO_ELEMENT_FAILED_MESSAGE = "Function did not correctly square single zero element"

        // Сообщение о том, что функция неправильно обработала четные числа
        private const val EVEN_NUMBERS_FAILED_MESSAGE = "Function did not correctly square even numbers"

        // Сообщение о том, что функция неправильно обработала отрицательные числа
        private const val NEGATIVE_NUMBERS_FAILED_MESSAGE = "Function did not correctly square negative numbers"

        // Сообщение о том, что функция неправильно обработала все нулевые элементы
        private const val ALL_ZERO_ELEMENTS_FAILED_MESSAGE = "Function did not correctly square all zero elements"

        // Сообщение о том, что функция неправильно обработала отрицательные и положительные элементы
        private const val NEGATIVE_AND_POSITIVE_ELEMENTS_FAILED_MESSAGE =
            "Function did not correctly square negative and positive elements"

        // Сообщение о том, что функция неправильно обработала единственный элемент
        private const val SINGLE_ELEMENT_FAILED_MESSAGE = "Function did not correctly square single element"

        // Сообщение о том, что функция неправильно обработала пустой список
        private const val EMPTY_LIST_FAILED_MESSAGE = "Function did not correctly handle empty list"

        // Сообщение о том, что функция неправильно обработала повторяющиеся элементы
        private const val REPEATED_ELEMENTS_FAILED_MESSAGE = "Function did not correctly square repeated elements"

        // Сообщение о том, что функция неправильно обработала все нулевые элементы
        private const val ZERO_ELEMENTS_FAILED_MESSAGE = "Function did not correctly square zero elements"


        /**
         * Метод-провайдер данных для параметризованных тестов
         */
        @JvmStatic
        fun squareProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    arrayListOf(1, 4, 9, 16, 25),
                    arrayListOf(1, 16, 81, 256, 625),
                    POSITIVE_NUMBERS_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(0, 5, Int.MAX_VALUE),
                    arrayListOf(0, 25, 1),
                    MAX_VALUE_ELEMENT_FAILED_MESSAGE.format(Int.MAX_VALUE),
                ),
                Arguments.of(
                    arrayListOf(0),
                    arrayListOf(0),
                    SINGLE_ZERO_ELEMENT_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(2, 4, 6, 8, 10),
                    arrayListOf(4, 16, 36, 64, 100),
                    EVEN_NUMBERS_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(-3, -2, -1, 0, 1, 2, 3),
                    arrayListOf(9, 4, 1, 0, 1, 4, 9),
                    NEGATIVE_NUMBERS_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(0, 0, 0, 0),
                    arrayListOf(0, 0, 0, 0),
                    ALL_ZERO_ELEMENTS_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(-1, 0, 1),
                    arrayListOf(1, 0, 1),
                    NEGATIVE_AND_POSITIVE_ELEMENTS_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(2),
                    arrayListOf(4),
                    SINGLE_ELEMENT_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf<Int>(),
                    arrayListOf<Int>(),
                    EMPTY_LIST_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(2, 3, 2, 3),
                    arrayListOf(4, 9, 4, 9),
                    REPEATED_ELEMENTS_FAILED_MESSAGE,
                ),
                Arguments.of(
                    arrayListOf(0, 2, 0, 4, 0),
                    arrayListOf(0, 4, 0, 16, 0),
                    ZERO_ELEMENTS_FAILED_MESSAGE,
                ),
            )
        }
    }
}
