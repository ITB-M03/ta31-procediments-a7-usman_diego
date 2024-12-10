package controllers
import java.text.SimpleDateFormat
import java.util.*
/**
 * Obté la taula de l'IVA vigent a partir de l'any 1986.
 * @author Diego Morales
 * @since 10/12/2024.
 *
 * Obté la taula de l'IVA vigent a partir de l'any 1986.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna una llista amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1986(data: Date): List<Pair<String, Double>> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1986")) {
        listOf(
            "General" to 12.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
    } else {
        emptyList()
    }
}

/**
 * Obté la taula de l'IVA vigent a partir de l'any 1992.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna una llista amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1992(data: Date): List<Pair<String, Double>> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1992")) {
        listOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
    } else {
        emptyList()
    }
}

/**
 * Obté la taula de l'IVA vigent a partir de l'any 1993.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna una llista amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1993(data: Date): List<Pair<String, Double>> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1993")) {
        listOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 3.0,
            "Exempt" to 0.0
        )
    } else {
        emptyList()
    }
}

/**
 * Obté la taula de l'IVA vigent a partir de l'any 1995.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna una llista amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1995(data: Date): List<Pair<String, Double>> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1995")) {
        listOf(
            "General" to 16.0,
            "Reduït" to 7.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
    } else {
        emptyList()
    }
}

/**
 * Obté la taula de l'IVA vigent a partir de l'any 2010.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna una llista amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA2010(data: Date): List<Pair<String, Double>> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-2010")) {
        listOf(
            "General" to 18.0,
            "Reduït" to 8.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
    } else {
        emptyList()
    }
}

/**
 * Obté la taula de l'IVA vigent a partir de l'any 2012.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna una llista amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA2012(data: Date): List<Pair<String, Double>> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("15-07-2012")) {
        listOf(
            "General" to 21.0,
            "Reduït" to 10.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
    } else {
        emptyList()
    }
}

/**
 * Obté la taula d'IVA vigent en funció de la data de la compra, iterant sobre diversos anys.
 * @param data La data de la compra que es vol consultar.
 * @return La llista amb els tipus d'IVA vigents en la data indicada.
 */
fun obtenirTaulaIVA(data: Date): List<Pair<String, Double>> {
    return obtenirTaulaIVA2012(data)
        .ifEmpty { obtenirTaulaIVA2010(data) }
        .ifEmpty { obtenirTaulaIVA1995(data) }
        .ifEmpty { obtenirTaulaIVA1993(data) }
        .ifEmpty { obtenirTaulaIVA1992(data) }
        .ifEmpty { obtenirTaulaIVA1986(data) }
        .ifEmpty { listOf("General" to 0.0, "Reduït" to 0.0, "Superreduït" to 0.0, "Exempt" to 0.0) }
}

/**
 * Calcula el preu amb IVA aplicat.
 * @param preu El preu base del producte.
 * @param tipusIVA El tipus d'IVA a aplicar ("General", "Reduït", etc.).
 * @param dataCompra La data de la compra en format "dd-MM-yyyy".
 * @return El preu total amb l'IVA aplicat.
 */
fun calcularIVA(preu: Double, tipusIVA: String, dataCompra: String): Double {
    val taulaIVA = obtenirTaulaIVA(SimpleDateFormat("dd-MM-yyyy").parse(dataCompra))
    val percentatgeIVA = taulaIVA.find { it.first == tipusIVA }?.second ?: 0.0
    return preu * (1 + percentatgeIVA / 100)
}

/**
 * Exemple d'ús de la funció calcularIVA.
 */
fun main() {
    val format = SimpleDateFormat("dd-MM-yyyy")
    val dataCompra = format.parse("01-01-1986")
    val preu = 100.0
    val tipusIVA = "General"
    val preuAmbIVA = calcularIVA(preu, tipusIVA, format.format(dataCompra))
    println(preuAmbIVA)  // Mostra el preu amb IVA aplicat
}

