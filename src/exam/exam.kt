package exam

import java.io.File

fun example(inputName: String): Int {
    if ("ultimate question" in File(inputName).readText().toLowerCase()) {
        return 42
    }
    throw IllegalStateException()
}

// В файле с именем, заданном параметром inputName, содержится прямоугольная матрица из вещественных чисел:
//6.3 4.2 8.5 0.6 8.8 7.1
//2.9 4.1 0.4 9.2 0.9 8.8
//5.7 6.2 5.4 3.2 9.5 3.0
//9.2 3.1 3.9 3.5 7.1 2.5
//3.7 5.4 7.0 9.0 1.6 6.1
//Во всех строках матрицы содержится одно и то же количество чисел.
// Будем называть седловым элементом матрицы такой, значение которого строго больше соседних элементов слева и справа от него,
// но строго меньше соседних элементов снизу и сверху от него. Элементы на краю матрицы не могут быть седловыми.
// В примере седловые элементы выделены жирным шрифтом.
//
//
//Найти в матрице хотя бы один седловой элемент, вернуть его значение, номер строки и столбца (номера считать с нуля),
// например: (4.1, строка 1, столбец 1)
fun myExamTask(inputName: String) : String {
    val lines = File(inputName).readLines()
    val maybe : MutableMap<Int, Double> = mutableMapOf()
    for (i in 0 until lines.size - 2 ) {
        val str1 = lines[i].split(" ")
        val str2 = lines[i+1].split(" ")
        val str3 = lines[i+2].split(" ")
        for (j in 0 until str2.size - 2 ) {
            if ((str2[j].toDouble() < str2[j+1].toDouble()) && (str2[j+2].toDouble() < str2[j+1].toDouble()))
                maybe[j+1] = str2[j+1].toDouble()
        }
        for (pair in maybe) {
            if ((pair.value < str1[pair.key].toDouble() && (pair.value < str3[pair.key].toDouble())))
                return "${pair.value}, строка ${i+1}, столбец ${pair.key}"
        }
    }
    return ""
}