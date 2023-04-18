/**
 * Метод расширения, который принимает список MutableList<Int> и возводит в квадрат все его элементы.
 * @receiver список MutableList<Int>, который нужно обработать
 */
fun MutableList<Int>.squareAllElementsExtension() {
    for (i in indices) {
        this[i] *= this[i]
    }
}

fun main() {
    val mutableList = mutableListOf(1, 4, 9, 16, 25)
    println(mutableList)
    mutableList.squareAllElementsExtension()
    println(mutableList)
}