import TestMessages.Companion.capitalizeString
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.logging.Handler


/**
 * Содержит константы сообщений для использования
 */
class TestMessages {
    companion object {
        //Сообщение о переменной типа Double
        internal const val TYPE_CASTING_DOUBLE_MESSAGE = "Я получил %s = %s, это число округляется до %s"

        //Сообщение о переменной типа String
        internal const val TYPE_CASTING_STRING_MESSAGE = "Я получил %s = %s, ее длина равна %s"

        //Сообщение о переменной типа Int
        internal const val TYPE_CASTING_INT_MESSAGE = "Я получил %s = %s, его квадрат равен %s"

        //Сообщение о переменной типа LocalDate
        internal const val TYPE_CASTING_LOCAL_DATE_MESSAGE = "Я получил %s = %s, она %s основания Tinkoff"

        //Сообщение о переменной неизвестного типа
        internal const val TYPE_CASTING_UNKNOWN_TYPE_MESSAGE = "Мне этот тип неизвестен"

        //Cообщение, которое используется для вывода информации о типе null-объекта
        internal const val TYPE_CASTING_NULL_TYPE_MESSAGE = "Объект равен null"

        //Шаблон формата даты "ММ/дд/гггг", используемый для преобразования даты в строку
        internal const val DATE_FORMAT_PATTERN = "MM/dd/yyyy"

        //Дата основания Tinkoff с которой происходит сравнение
        internal const val COMPARISON_DATE = "12/24/2006"

        //Сообщение, используемое для описания отношения дат, когда одна дата меньше другой
        internal const val DATE_RELATIONSHIP_LESS_THAN = "меньше даты"

        //Сообщение, используемое для описания отношения дат, когда одна дата больше другой
        internal const val DATE_RELATIONSHIP_GREATER_THAN = "больше даты"

        //Сообщение, используемое для описания отношения дат, когда две даты равны друг другу
        internal const val DATE_RELATIONSHIP_EQUAL_TO = "равна дате"

        // Значение null для тестирования функций
        internal val NULL_VALUE = null

        /**
         * Расширение для типа String, которое возвращает строку, первая буква переведена в верхний регистр.
         * Если первая буква уже в верхнем регистре, то строка не изменится.
         * @return Строка с первой заглавной буквой.
         */
        fun String.capitalizeString(): String {
            return this.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        }
    }

}

/**
 * Интерфейс, описывающий обработчик приведения типов.
 */
interface TypeCastingHandler {
    /**
     * Принимает объект `Any?` и выводит информацию о его типе и значении.
     *
     * @param obj объект для приведения типов.
     */
    fun typeCasting(obj: Any?): String
}

/**
 * Класс TypeCastingProcessor реализует интерфейс [TypeCastingHandler] и предоставляет функциональность для приведения
 * типов переданного объекта и вывода информации о его типе и значении.
 */
public class TypeCastingProcessor : TypeCastingHandler {
    /**
     * Принимает объект `Any?` и выводит информацию о его типе и значении.
     * @param obj объект для приведения типов.
     */
    override fun typeCasting(obj: Any?): String {
        // Проверяем, равен ли переданный объект null
        // Используем when-выражение для проверки типа переменной
        obj?.let {
            when (obj) {
                // Если тип переменной String, выводим информацию о ней
                is String -> return typeCastingString(obj)
                // Если тип переменной Int, выводим информацию о ней
                is Int -> return typeCastingInt(obj)
                // Если тип переменной Double, выводим информацию о ней
                is Double -> return typeCastingDouble(obj)
                // Если тип переменной LocalDate, выводим информацию о ней
                is LocalDate -> return typeCastingLocalDate(obj)
                // Если другой тип переменной, выводим сообщение, что поведение не определено
                else -> return typeCastingUnknownType()
            }
        } ?: return TestMessages.TYPE_CASTING_NULL_TYPE_MESSAGE
    }

    /**
     * Выводит сообщение о переменной типа String, включая ее имя, значение и длину.
     * @param stringVariable переменная типа String
     */
    private fun typeCastingString(stringVariable: String): String {
        return TestMessages.TYPE_CASTING_STRING_MESSAGE.format(
            String::class.java.simpleName.capitalizeString(),
            stringVariable,
            stringVariable.length
        )
    }

    /**
     * Выводит информацию о целочисленной переменной и ее квадрате.
     * @param intVariable значение типа Int, которое будет выведено в сообщении.
     */
    private fun typeCastingInt(intVariable: Int): String {
        return TestMessages.TYPE_CASTING_INT_MESSAGE.format(
            intVariable.javaClass.simpleName.capitalizeString(),
            intVariable,
            intVariable.calculateSquareIntNew()
        )
    }

    /**
     * Функция принимает переменную типа Double и выводит ее значение,
     * а также округляет до двух знаков после запятой (по умолчанию).
     * @param doubleVariable переменная типа Double, значение которой нужно вывести и округлить
     */
    private fun typeCastingDouble(doubleVariable: Double): String {
        return TestMessages.TYPE_CASTING_DOUBLE_MESSAGE.format(
            doubleVariable.javaClass.simpleName.capitalizeString(),
            doubleVariable,
            doubleVariable.getMathRoundDouble()
        )
    }

    /**
     * Функция для приведения типа LocalDate к строковому типу
     * @param dateVariable переменная типа LocalDate
     * @return строковое представление переменной dateVariable с указанием типа данных и проверкой на соответствие дате
     */
    private fun typeCastingLocalDate(dateVariable: LocalDate): String {
        return TestMessages.TYPE_CASTING_LOCAL_DATE_MESSAGE.format(
            dateVariable.javaClass.simpleName.capitalizeString(),
            dateVariable,
            checkDataRelationshipToDate(dateVariable)
        )
    }

    /**
    Производит приведение типа переменной неизвестного типа.
    Если тип переменной неизвестен, выводит сообщение об этом.
     */
    private fun typeCastingUnknownType(): String {
        return TestMessages.TYPE_CASTING_UNKNOWN_TYPE_MESSAGE
    }

    /**
     * Расширение для типа Int, которое вычисляет квадрат целочисленного значения.
     * @return результат вычисления квадрата значения типа Int.
     */
    private fun Int.calculateSquareIntNew(): Int {
        return this * this
    }

    /**
     * Расширение для типа Double, которое округляет Double до указанного количества десятичных знаков.
     * Если дробная часть равна нулю, возвращает целое число без десятичных знаков.
     * @param decimalPlaces Количество десятичных знаков после запятой (по умолчанию 2).
     * @return Отформатированная строка с округленным числом.
     */
    private fun Double.getMathRoundDouble(decimalPlaces: Int = 2): String {
        return if (this % 1 == 0.0) {
            String.format("%.0f", this)
        } else {
            String.format("%.${decimalPlaces}f", this)
        }
    }

    /**
     * Сравнивает переданную дату с основной датой и возвращает строку с результатом сравнения.
     * @param date дата, которую нужно сравнить с основной датой
     * @return строка с результатом сравнения переданной даты с основной датой
     */
    private fun checkDataRelationshipToDate(date: LocalDate): String {
        val formatter = DateTimeFormatter.ofPattern(TestMessages.DATE_FORMAT_PATTERN)
        return when {
            date.isBefore(
                LocalDate.parse(
                    TestMessages.COMPARISON_DATE,
                    formatter
                )
            ) -> TestMessages.DATE_RELATIONSHIP_LESS_THAN

            date.isAfter(
                LocalDate.parse(
                    TestMessages.COMPARISON_DATE,
                    formatter
                )
            ) -> TestMessages.DATE_RELATIONSHIP_GREATER_THAN

            else -> TestMessages.DATE_RELATIONSHIP_EQUAL_TO
        }
    }
}

fun main() {
    val typeCaster = TypeCastingProcessor()
    println(typeCaster.typeCasting("Privet"))
    println(typeCaster.typeCasting(145))
    println(typeCaster.typeCasting(145.0))
    println(typeCaster.typeCasting(145.2817812))
    println(typeCaster.typeCasting(LocalDate.of(1990, 1, 1)))
    println(typeCaster.typeCasting(Handler::class))
}

