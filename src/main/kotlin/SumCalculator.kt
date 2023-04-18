/**
 * Интерфейс для вычисления суммы элементов списка и других операций с числами.
 */
interface Calculator {
    /**
     * Вычисляет сумму элементов списка, удовлетворяющих некоторым условиям.
     * @param list Список элементов, которые нужно обработать. Может содержать значения null.
     * @return Сумма элементов, удовлетворяющих условиям обработки.
     */
    fun calculateSum(list: List<Double?>): Double

    /**
     * Преобразует число в строку в заданном формате.
     * @param value Число, которое нужно преобразовать в строку.
     * @param decimalPlaces Количество знаков после запятой.
     * @return Строковое представление числа в заданном формате.
     */
    fun convertToFormattedString(value: Any, decimalPlaces: Int): String

}

/**
 * Класс `SumCalculator` реализует интерфейс `Calculator` и предоставляет функции для вычисления суммы
 * элементов списка, удовлетворяющих определенным условиям, вывода объектов в консоль и форматированного
 * преобразования числовых значений в строковое представление с заданным числом знаков после запятой.
 */
class SumCalculator : Calculator {
    /**
     * Вычисляет сумму первых 10 элементов списка, удовлетворяющих некоторым условиям.
     * @param list Список элементов, которые нужно обработать. Может содержать значения null.
     * @return Сумма первых 10 элементов, удовлетворяющих условиям обработки. Если таких элементов меньше 10,
     *         то возвращается сумма всех удовлетворяющих элементов.
     */
    override fun calculateSum(list: List<Double?>): Double {
        return list.asSequence()
            // Отбрасываем null
            .filterNotNull()
            .mapNotNull {
                // Если элемент нечетный, то делим на 2
                if (it.toInt() % 2 != 0) {
                    it / 2
                    // Если элемент четный, то возведем в квадрат, если меньше 5, иначе пропускаем
                } else {
                    it.takeIf { it <= 5 }?.run { this * this }
                }
            }
            // Оставляем элементы, не превышающие 25
            .takeWhile { it <= 25 }
            // Сортируем по убыванию
            .sortedDescending()
            // Берем первые 10 элементов
            .take(10)
            // Суммируем оставшиеся элементы
            .sum()
    }

    /**
     * Функция для форматированного преобразования числовых значений в строковое представление с заданным числом знаков после запятой.
     *
     * @param value числовое значение, которое необходимо преобразовать в строку
     * @param decimalPlaces количество знаков после запятой
     * @return строковое представление числа с заданным числом знаков после запятой
     */
    override fun convertToFormattedString(value: Any, decimalPlaces: Int): String {
        return "%.${decimalPlaces}f".format(value)
    }
}

fun main() {
    val sumCalculator = SumCalculator()
    val listDouble = listOf(13.31, 3.98, 12.0, 2.99, 9.0)
    val resultCalculateSum = sumCalculator.calculateSum(listDouble)
    println(sumCalculator.convertToFormattedString(resultCalculateSum, 2))
}
