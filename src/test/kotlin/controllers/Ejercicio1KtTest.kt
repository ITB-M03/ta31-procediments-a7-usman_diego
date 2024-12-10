package controllers
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.*

class Ejercicio1KtTest {

    private val format = SimpleDateFormat("dd-MM-yyyy")

    @Test
    fun `test obtenirTaulaIVA 1986`() {
        val data = format.parse("01-01-1986")
        val result = obtenirTaulaIVA(data)

        val expected = mapOf(
            "General" to 12.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )

        assertEquals(expected, result)
    }

    @Test
    fun `test obtenirTaulaIVA 1992`() {
        val data = format.parse("01-01-1992")
        val result = obtenirTaulaIVA(data)

        val expected = mapOf(
            "General" to 15.0,
            "Reduït" to 6.0,
            "Superreduït" to 0.0,
            "Exempt" to 0.0
        )

        assertEquals(expected, result)
    }

    @Test
    fun IVAFunctionsTest() {
        fun `test obtenirPercentatgeIVA 1986 General`() {
            val result = obtenirPercentatgeIVA("01-01-1986", "General")
            assertEquals(12.0, result)
        }
    }
}


