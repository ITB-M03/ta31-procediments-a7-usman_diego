package controllers

fun obtenirValorRoman(num: Int): Pair<Int, String> {
    val valorsRomans = arrayOf(
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    )
    val simbolsRomans = arrayOf(
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    )
    for (i in valorsRomans.indices) {
        if (num >= valorsRomans[i]) {
            return Pair(valorsRomans[i], simbolsRomans[i])
        }
    }
    return Pair(0, "")
}
fun roman(num: Int): String {
    var numero = num
    var resultat = StringBuilder()
    while (numero > 0) {
        val (valor, simbol) = obtenirValorRoman(numero)
        resultat.append(simbol)
        numero -= valor
    }
    return resultat.toString()
}
fun main() {
    val num = 2023
    println(roman(num))
}
