package org.example.controllers
import java.math.*
import java.text.SimpleDateFormat
import java.util.*

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

// Aquesta funció rep la data de compra i retorna el percentatge corresponent
fun obtenirPercentatgeIVA(dataCompra: String, tipusIVA: String): Double {
    val format = SimpleDateFormat("dd-MM-yyyy")
    val data = format.parse(dataCompra)

    // Cridem la funció obtenirTaulaIVA per obtenir els percentatges d'IVA
    val taulaIVA = obtenirTaulaIVA(data)

    // Si la taula conté l'IVA per aquest tipus, retornem el percentatge
    return taulaIVA[tipusIVA] ?: 0.0
}

fun obtenirTaulaIVA(data: Date): Map<String, Double> {
    return obtenirTaulaIVA2012(data)
        .ifEmpty { obtenirTaulaIVA2010(data) }
        .ifEmpty { obtenirTaulaIVA1995(data) }
        .ifEmpty { obtenirTaulaIVA1993(data) }
        .ifEmpty { obtenirTaulaIVA1992(data) }
        .ifEmpty { obtenirTaulaIVA1986(data) }
        .ifEmpty { mapOf("General" to 0.0, "Reduït" to 0.0, "Superreduït" to 0.0, "Exempt" to 0.0) }
}

fun calcularIVA(preu: Double, tipusIVA: String, dataCompra: String): Double {
    val percentatgeIVA = obtenirPercentatgeIVA(dataCompra, tipusIVA)
    return preu * (1 + percentatgeIVA / 100)
}

fun main() {
    val format = SimpleDateFormat("dd-MM-yyyy")
    val dataCompra = format.parse("01-01-1986")
    val preu = 100.0
    val tipusIVA = "General"
    val preuAmbIVA = calcularIVA(preu, tipusIVA, format.format(dataCompra))
    println(preuAmbIVA)  // Ha de mostrar el preu amb l'IVA aplicat
}

