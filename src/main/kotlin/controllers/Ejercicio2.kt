package controllers
/**
 * @author Diego Morales
 *
 * @since 10/12/2024.
 *
 * Obté el valor romà més alt possible per a un nombre donat.
 * Aquesta funció compara el número passat amb els valors romans disponibles
 * i retorna el valor corresponent i el símbol romà associat.
 * @param num El número sencer que es vol convertir a romà.
 * @return Una parella que conté el valor numèric i el símbol romà corresponent.
 */
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

/**
 * Converteix un número sencer a la seva representació en nombres romans.
 * Aquesta funció utilitza la funció [obtenirValorRoman] per obtenir el valor
 * i el símbol romà més alt possible per cada part del número, fins que el número
 * és completament convertit.
 * @param num El número sencer que es vol convertir a romà.
 * @return La representació en números romans del número donat com una cadena de text.
 */
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

/**
 * Funció principal que mostra la conversió d'un número a romà.
 * Aquesta funció és la que s'executa quan el programa comença. En aquest cas,
 * converteix el número 2023 a números romans i el imprimeix.
 * @param args Els arguments de la línia de comandes (si escau).
 */
fun main() {
    val num = 2023
    println(roman(num))
}

