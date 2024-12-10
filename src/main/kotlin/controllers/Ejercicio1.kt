package controllers
import java.text.SimpleDateFormat
import java.util.*
/**
 * Obté la taula de l'IVA vigent a partir de l'any 1986.
 * @author Diego Morales
 * @since 10/12/2024
 * @param data La data de la compra que es vol consultar.
 * @return Retorna un mapa amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1986(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1986")) {
        mapOf(
            "General" to 12.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
    } else {
        emptyMap()
    }
}
/**
 * Obté la taula de l'IVA vigent a partir de l'any 1992.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna un mapa amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1992(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1992")) {
        mapOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
    } else {
        emptyMap()
    }
}
/**
 * Obté la taula de l'IVA vigent a partir de l'any 1993.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna un mapa amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1993(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1993")) {
        mapOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 3.0,
            "Exempt" to 0.0
        )
    } else {
        emptyMap()
    }
}
/**
 * Obté la taula de l'IVA vigent a partir de l'any 1995.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna un mapa amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA1995(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-1995")) {
        mapOf(
            "General" to 16.0,
            "Reduït" to 7.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
    } else {
        emptyMap()
    }
}
/**
 * Obté la taula de l'IVA vigent a partir de l'any 2010.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna un mapa amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA2010(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("01-01-2010")) {
        mapOf(
            "General" to 18.0,
            "Reduït" to 8.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
    } else {
        emptyMap()
    }
}
/**
 * Obté la taula de l'IVA vigent a partir de l'any 2012.
 * @param data La data de la compra que es vol consultar.
 * @return Retorna un mapa amb els tipus d'IVA disponibles en funció de la data.
 */
fun obtenirTaulaIVA2012(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")
    return if (data >= format.parse("15-07-2012")) {
        mapOf(
            "General" to 21.0,
            "Reduït" to 10.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
    } else {
        emptyMap()
    }
}
/**
 * Obté el percentatge d'IVA aplicable a una compra segons la data i el tipus d'IVA.
 * @param dataCompra La data de la compra en format "dd-MM-yyyy".
 * @param tipusIVA El tipus d'IVA a calcular ("General", "Reduït", etc.).
 * @return El percentatge d'IVA aplicat.
 */
fun obtenirPercentatgeIVA(dataCompra: String, tipusIVA: String): Double {
    val format = SimpleDateFormat("dd-MM-yyyy")
    val data = format.parse(dataCompra)
    val taulaIVA = obtenirTaulaIVA(data)
    return taulaIVA[tipusIVA] ?: 0.0
}
/**
 * Obté la taula d'IVA vigent en funció de la data de la compra, iterant sobre diversos anys.
 * @param data La data de la compra que es vol consultar.
 * @return El mapa amb els tipus d'IVA vigents en la data indicada.
 */
fun obtenirTaulaIVA(data: Date): Map<String, Double> {
    return obtenirTaulaIVA2012(data)
        .ifEmpty { obtenirTaulaIVA2010(data) }
        .ifEmpty { obtenirTaulaIVA1995(data) }
        .ifEmpty { obtenirTaulaIVA1993(data) }
        .ifEmpty { obtenirTaulaIVA1992(data) }
        .ifEmpty { obtenirTaulaIVA1986(data) }
        .ifEmpty { mapOf("General" to 0.0, "Reduït" to 0.0, "Superreduït" to 0.0, "Exempt" to 0.0) }
}
/**
 * Calcula el preu amb IVA aplicat.
 * @param preu El preu base del producte.
 * @param tipusIVA El tipus d'IVA a aplicar ("General", "Reduït", etc.).
 * @param dataCompra La data de la compra en format "dd-MM-yyyy".
 * @return El preu total amb l'IVA aplicat.
 */
fun calcularIVA(preu: Double, tipusIVA: String, dataCompra: String): Double {
    val percentatgeIVA = obtenirPercentatgeIVA(dataCompra, tipusIVA)
    return preu * (1 + percentatgeIVA / 100)
}
/**
 * us de la funció calcularIVA.
 */
fun main() {
    val format = SimpleDateFormat("dd-MM-yyyy")
    val dataCompra = format.parse("01-01-1986")
    val preu = 100.0
    val tipusIVA = "General"
    val preuAmbIVA = calcularIVA(preu, tipusIVA, format.format(dataCompra))
    println(preuAmbIVA)
}

