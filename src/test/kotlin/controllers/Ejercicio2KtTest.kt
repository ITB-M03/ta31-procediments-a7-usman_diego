package controllers
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import org.junit.jupiter.api.Assertions.*

class Ejercicio2KtTest {

    @Test
    fun `test obtenirValorRoman 2023`() {
        val (valor, simbol) = obtenirValorRoman(2023)
        assertEquals(1000, valor)
        assertEquals("M", simbol)
    }

    @Test
    fun `test obtenirValorRoman 400`() {
        val (valor, simbol) = obtenirValorRoman(400)
        assertEquals(400, valor)
        assertEquals("CD", simbol)
    }

    @Test
    fun `test roman 2023`() {
        val result = roman(2023)
        assertEquals("MMXXIII", result)
    }
}