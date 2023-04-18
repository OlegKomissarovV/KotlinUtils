//Сообщение, которое попросит пользователя ввести число
private const val ENTER_COUNT_MSG = "Введите число от 0 до 1000: "

//Минимальное число, которое может быть сгенерировано
private const val NUMBER_MIN = 0

//Максимальное число, которое может быть сгенерировано
private const val NUMBER_MAX = 1000

//Сообщение об ошибке, которое будет выведено, если пользователь ввел неверный ввод
private const val INVALID_INPUT_MSG = "Неверный ввод"

//Сообщение об ошибке, которое будет выведено, если пользователь ввел число, выходящее за диапазон от NUMBER_MIN до NUMBER_MAX
private const val COUNT_RANGE_MSG = "Число человек должно быть в промежутке между $NUMBER_MIN и $NUMBER_MAX"

class RussianNumberWordsConverter {
    // Словарь для единиц (0-9), чисел от 10 до 19 и числа 1000
    private val numberWordsMap = mapOf(
        0 to "ноль",
        1 to "один",
        2 to "два",
        3 to "три",
        4 to "четыре",
        5 to "пять",
        6 to "шесть",
        7 to "семь",
        8 to "восемь",
        9 to "девять",
        10 to "десять",
        11 to "одиннадцать",
        12 to "двенадцать",
        13 to "тринадцать",
        14 to "четырнадцать",
        15 to "пятнадцать",
        16 to "шестнадцать",
        17 to "семнадцать",
        18 to "восемнадцать",
        19 to "девятнадцать",
        1000 to "одна тысяча",
    )
    // Словарь для десятков (20-90)
    private val tensWordsMap = mapOf(
        2 to "двадцать",
        3 to "тридцать",
        4 to "сорок",
        5 to "пятьдесят",
        6 to "шестьдесят",
        7 to "семьдесят",
        8 to "восемьдесят",
        9 to "девяносто"
    )
    // Словарь для сотен (100-900)
    private val hundredsWordsMap = mapOf(
        1 to "сто",
        2 to "двести",
        3 to "триста",
        4 to "четыреста",
        5 to "пятьсот",
        6 to "шестьсот",
        7 to "семьсот",
        8 to "восемьсот",
        9 to "девятьсот"
    )

    /**
     * Преобразует переданное натуральное число в строку с русским словом, которое описывает это число.
     * Если передано число 0, возвращает строку "ноль". Если передано число 1000, возвращает строку "одна тысяча".
     * @param number натуральное число, которое требуется преобразовать в строку с русским словом
     * @return строку с русским словом, которое описывает переданное число
     */
    fun getNumberWord(number: Int, stringBuilder: StringBuilder): String {
        // Проверяем, является ли число нулем или тысячей
        if ((number == 0) || (number == 1000))
            return stringBuilder.append(numberWordsMap[number]).append(" ").toString().trim()
        // Вычисляем количество сотен в числе и если в числе есть сотни, добавляем название сотен
        stringBuilder.append(hundredsWordsMap[(number % 1000) / 100]?.let { "$it " } ?: "")
        // Если десятки равны 1, добавляем название числа от 10 до 19.
        appendTensOrTeens(stringBuilder, (number % 100) / 10, number % 10)
        // Возвращаем строку с названием числа, обрезаем пробелы по краям.
        return stringBuilder.toString().trim()
    }
    /**
     * Метод для добавления названия десятков или чисел от 10 до 19 в StringBuilder.
     * @param stringBuilder Ссылка на объект StringBuilder, в который добавляются названия.
     * @param tensDigit Число десятков
     * @param onesDigit Число единиц
     */
    private fun appendTensOrTeens(
        stringBuilder: StringBuilder,
        tensDigit: Int,
        onesDigit: Int,
    ) {
        if (tensDigit == 1)
            stringBuilder.append(numberWordsMap[tensDigit * 10 + onesDigit]).append(" ")
        else {
            // Иначе, если десятки больше 1, добавляем название десятков.
            if (tensDigit > 1)
                stringBuilder.append(tensWordsMap[tensDigit]).append(" ")
            // Добавляем название единиц, если они есть.
            if (onesDigit > 0)
                stringBuilder.append(numberWordsMap[onesDigit]).append(" ")
        }
    }
}

fun main() {
    try {
        println(ENTER_COUNT_MSG)
        // Чтение строки с вводом числа, преобразование в Int,
        // выполнение кода в блоке let, где числовое значение доступно в качестве inputNumber
        // возвращение null, если ввод не удался
        readlnOrNull()?.toIntOrNull()?.let { inputNumber ->
            // Проверка, что введенное число находится в диапазоне NUMBER_MIN и NUMBER_MAX
            if (inputNumber in NUMBER_MIN..NUMBER_MAX)
                // Вывод преобразованного числа в слова
                println(RussianNumberWordsConverter().getNumberWord(inputNumber, java.lang.StringBuilder()))
            else
                println(COUNT_RANGE_MSG)
        } ?: println(INVALID_INPUT_MSG)
    // Вывод сообщения об ошибке с описанием ошибки
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}
