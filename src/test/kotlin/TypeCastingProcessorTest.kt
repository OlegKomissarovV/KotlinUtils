import TestMessages.Companion.capitalizeString
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.time.LocalDate
import java.util.*
import java.util.logging.Handler
import java.util.stream.Stream


/**
 * Тестовый класс для проверки метода typeCasting()
 */
class TypeCastingProcessorTest {
    private val typeCaster = TypeCastingProcessor()

    /**
     * Метод для проведения параметризованных тестов
     */
    @ParameterizedTest
    @DisplayName("Тестирование метода typeCasting() класса TypeCastingProcessor")
    @MethodSource("typeCastingProvider")
    fun testTypeCasting(obj: Any?, expected: Any?, message: String) {
        val actualOutput = typeCaster.typeCasting(obj)
        assertEquals(
            expected, actualOutput, TEST_FAILED_MESSAGE.format(message)
        )
    }

    companion object {
        // Сообщение о том, что тест упал
        private const val TEST_FAILED_MESSAGE = "Test failed. %s"

        // Сообщение о том, что ожидаемый результат не совпадает с фактическим
        private const val OUTPUT_FAILED_MESSAGE = "Expected output %s does not match actual output"

        /*Тестовые данные*/
        // Простые имена типов данных в Java для проверки типов
        private val SIMPLE_NAME_LOCALE_DATE = LocalDate::class.java.simpleName
        private val SIMPLE_NAME_STRING = String::class.java.simpleName
        private val SIMPLE_NAME_INT = Int::class.java.simpleName.capitalizeString()
        private val SIMPLE_NAME_DOUBLE = Double::class.java.simpleName.capitalizeString()
        private val SIMPLE_NAME_HANDLER = Handler::class.simpleName

        // Тестовые данные для различных функций
        private const val INPUT_STRING_VALUE_1 = "Привет, Андрей, ну где ты был, ну обними меня скорей!"
        private const val INPUT_STRING_VALUE_2 = "Privet"
        private const val INT_VALUE_1 = 145
        private const val EXPECTED_INT_VALUE_1 = 21025
        private const val INPUT_DOUBLE_VALUE_1 = 145.0
        private const val INPUT_DOUBLE_VALUE_2 = 0.0
        private const val EXPECTED_DOUBLE_VALUE_2 = 0
        private const val INPUT_DOUBLE_VALUE_3 = 2.356
        private const val EXPECTED_DOUBLE_VALUE_3 = "2,36"
        private const val INPUT_DOUBLE_VALUE_4 = 145.2817812
        private const val EXPECTED_DOUBLE_VALUE_4 = "145,28"
        private val INPUT_LOCAL_DATE_VALUE_1 = LocalDate.of(2006, 12, 23)
        private val INPUT_LOCAL_DATE_VALUE_2 = LocalDate.of(2006, 12, 24)
        private val INPUT_LOCAL_DATE_VALUE_3 = LocalDate.of(2006, 12, 25)
        private val INPUT_LOCAL_DATE_VALUE_4 = LocalDate.of(1990, 1, 1)
        private val INPUT_HANDLER_CLASS = Handler::class

        /**
         * Метод-провайдер данных для параметризованных тестов
         */
        @JvmStatic
        fun typeCastingProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    INPUT_STRING_VALUE_1,
                    TestMessages.TYPE_CASTING_STRING_MESSAGE.format(
                        SIMPLE_NAME_STRING,
                        INPUT_STRING_VALUE_1,
                        INPUT_STRING_VALUE_1.length
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_STRING)
                ),
                Arguments.of(
                    INPUT_STRING_VALUE_2,
                    TestMessages.TYPE_CASTING_STRING_MESSAGE.format(
                        SIMPLE_NAME_STRING,
                        INPUT_STRING_VALUE_2,
                        INPUT_STRING_VALUE_2.length
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_STRING)
                ),
                Arguments.of(
                    INT_VALUE_1,
                    TestMessages.TYPE_CASTING_INT_MESSAGE.format(
                        SIMPLE_NAME_INT,
                        INT_VALUE_1,
                        EXPECTED_INT_VALUE_1,
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_INT)
                ),
                Arguments.of(
                    INPUT_DOUBLE_VALUE_1,
                    TestMessages.TYPE_CASTING_DOUBLE_MESSAGE.format(
                        SIMPLE_NAME_DOUBLE,
                        INPUT_DOUBLE_VALUE_1,
                        INT_VALUE_1
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_INT)
                ),
                Arguments.of(
                    INPUT_DOUBLE_VALUE_2,
                    TestMessages.TYPE_CASTING_DOUBLE_MESSAGE.format(
                        SIMPLE_NAME_DOUBLE,
                        INPUT_DOUBLE_VALUE_2,
                        EXPECTED_DOUBLE_VALUE_2
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_DOUBLE)
                ),
                Arguments.of(
                    INPUT_DOUBLE_VALUE_3,
                    TestMessages.TYPE_CASTING_DOUBLE_MESSAGE.format(
                        SIMPLE_NAME_DOUBLE,
                        INPUT_DOUBLE_VALUE_3,
                        EXPECTED_DOUBLE_VALUE_3
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_DOUBLE)
                ),
                Arguments.of(
                    INPUT_DOUBLE_VALUE_4,
                    TestMessages.TYPE_CASTING_DOUBLE_MESSAGE.format(
                        SIMPLE_NAME_DOUBLE,
                        INPUT_DOUBLE_VALUE_4,
                        EXPECTED_DOUBLE_VALUE_4
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_DOUBLE)
                ),
                Arguments.of(
                    INPUT_LOCAL_DATE_VALUE_1,
                    TestMessages.TYPE_CASTING_LOCAL_DATE_MESSAGE.format(
                        SIMPLE_NAME_LOCALE_DATE,
                        INPUT_LOCAL_DATE_VALUE_1,
                        TestMessages.DATE_RELATIONSHIP_LESS_THAN
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_LOCALE_DATE)
                ),
                Arguments.of(
                    INPUT_LOCAL_DATE_VALUE_2,
                    TestMessages.TYPE_CASTING_LOCAL_DATE_MESSAGE.format(
                        SIMPLE_NAME_LOCALE_DATE,
                        INPUT_LOCAL_DATE_VALUE_2,
                        TestMessages.DATE_RELATIONSHIP_EQUAL_TO
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_LOCALE_DATE)
                ),
                Arguments.of(
                    INPUT_LOCAL_DATE_VALUE_3,
                    TestMessages.TYPE_CASTING_LOCAL_DATE_MESSAGE.format(
                        SIMPLE_NAME_LOCALE_DATE,
                        INPUT_LOCAL_DATE_VALUE_3,
                        TestMessages.DATE_RELATIONSHIP_GREATER_THAN
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_LOCALE_DATE)
                ),
                Arguments.of(
                    INPUT_LOCAL_DATE_VALUE_4,
                    TestMessages.TYPE_CASTING_LOCAL_DATE_MESSAGE.format(
                        SIMPLE_NAME_LOCALE_DATE,
                        INPUT_LOCAL_DATE_VALUE_4,
                        TestMessages.DATE_RELATIONSHIP_LESS_THAN
                    ),
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_LOCALE_DATE)
                ),
                Arguments.of(
                    INPUT_HANDLER_CLASS,
                    TestMessages.TYPE_CASTING_UNKNOWN_TYPE_MESSAGE,
                    OUTPUT_FAILED_MESSAGE.format(SIMPLE_NAME_HANDLER)
                ),
                Arguments.of(
                    TestMessages.NULL_VALUE,
                    TestMessages.TYPE_CASTING_NULL_TYPE_MESSAGE,
                    OUTPUT_FAILED_MESSAGE.format("null")
                ),
            )
        }
    }
}