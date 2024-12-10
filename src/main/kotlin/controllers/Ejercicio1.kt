package org.example.controllers
import java.text.SimpleDateFormat
import java.util.*

fun obtenirPercentatgeIVA(dataCompra: String, tipusIVA: String): Double {
    val format = SimpleDateFormat("dd-MM-yyyy")
    val data = format.parse(dataCompra)

    val tipusIVAPercentatge = obtenirTaulaIVA(data)

    return tipusIVAPercentatge[tipusIVA] ?: 0.0
}

fun obtenirTaulaIVA(data: Date): Map<String, Double> {
    val format = SimpleDateFormat("dd-MM-yyyy")

    return when {
        data >= format.parse("15-07-2012") -> mapOf(
            "General" to 21.0,
            "Reduït" to 10.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
        data >= format.parse("01-01-2010") -> mapOf(
            "General" to 18.0,
            "Reduït" to 8.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
        data >= format.parse("01-01-1995") -> mapOf(
            "General" to 16.0,
            "Reduït" to 7.0,
            "Superreduït" to 4.0,
            "Exempt" to 0.0
        )
        data >= format.parse("01-01-1993") -> mapOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 3.0,
            "Exempt" to 0.0
        )
        data >= format.parse("01-01-1992") -> mapOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
        data >= format.parse("01-01-1986") -> mapOf(
            "General" to 12.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
        else -> mapOf(
            "General" to 0.0,
            "Reduït" to 0.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
    }
}

fun calcularIVA(preu: Double, tipusIVA: String, dataCompra: String): Double {
    val percentatgeIVA = obtenirPercentatgeIVA(dataCompra, tipusIVA)
    return preu * (1 + percentatgeIVA / 100)
}

fun main() {
    val preuAmbIVA = calcularIVA(100.0, "General", "01-01-2010")
    println(preuAmbIVA)  // Ha de mostrar el preu amb l'IVA aplicat
}
