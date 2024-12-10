package controllers
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.*

class Ejercicio1KtTest {
    @Test
    fun `test obtenirTaulaIVA para fecha 1986`() {
        val format = SimpleDateFormat("dd-MM-yyyy")
        val dataCompra = format.parse("01-01-1986")

        val taulaIVA = obtenirTaulaIVA(dataCompra)

        // Esperamos que la tabla de IVA tenga los valores para 1986
        val expectedTaula = listOf(
            "General" to 12.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )
        assertEquals(expectedTaula, taulaIVA)
    }

    @Test
    fun `test calcularIVA con tipo general para fecha 1986`() {
        val format = SimpleDateFormat("dd-MM-yyyy")
        val dataCompra = format.parse("01-01-1986")

        val preu = 100.0
        val tipusIVA = "General"

        val preuAmbIVA = calcularIVA(preu, tipusIVA, format.format(dataCompra))

        // El tipo de IVA general en 1986 es 12%, así que el cálculo sería:
        val expectedPreuAmbIVA = 100.0 * (1 + 12.0 / 100)

        assertEquals(expectedPreuAmbIVA, preuAmbIVA, 0.01) // Usamos una tolerancia de 0.01
    }

    @Test
    fun `test obtenirTaulaIVA per any 1993`() {
        val format = SimpleDateFormat("dd-MM-yyyy")
        val dataCompra = format.parse("01-01-1993")

        val taulaIVA = obtenirTaulaIVA(dataCompra)

        // Esperamos que la tabla de IVA tenga los valores para 1993
        val expectedTaula = listOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 3.0,
            "Exempt" to 0.0
        )
        assertEquals(expectedTaula, taulaIVA)
    }

}




