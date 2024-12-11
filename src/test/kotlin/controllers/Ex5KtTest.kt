package controllers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.ByteArrayOutputStream
import java.io.PrintStream

 class Ex5KtTest {
  @Test
  fun checkPushAfegirElement() {
   val pila = Pila()
   pila.push(5)
   val expectedOutput = "Contingut de la pila: 5"
   assertEquals(expectedOutput, capturarOutput { pila.mostrarContingut() })
  }

  @Test
  fun checkPushPilaPlena() {
   val pila = Pila()
   repeat(10) { pila.push(it) } // Omplim la pila
   val expectedOutput = "La pila està plena. No es poden afegir més elements."
   assertEquals(expectedOutput, capturarOutput { pila.push(11) })
  }

  @Test
  fun checkPopElement() {
   val pila = Pila()
   pila.push(10)
   pila.pop() // Eliminar l'únic element
   val expectedOutput = "La pila està buida."
   assertEquals(expectedOutput, capturarOutput { pila.mostrarContingut() })
  }

  @Test
  fun checkPopEnPilaBuida() {
   val pila = Pila()
   val expectedOutput = "La pila està buida. No es pot treure cap element."
   assertEquals(expectedOutput, capturarOutput { pila.pop() })
  }

  @Test
  fun checkMostrarContingutBuida() {
   val pila = Pila()
   val expectedOutput = "La pila està buida."
   assertEquals(expectedOutput, capturarOutput { pila.mostrarContingut() })
  }

  private fun capturarOutput(bloc: () -> Unit): String {
   val originalOut = System.out
   val outputStreamCaptor = ByteArrayOutputStream()
   System.setOut(PrintStream(outputStreamCaptor))
   try {
    bloc.invoke()
   } finally {
    System.setOut(originalOut)
   }
   return outputStreamCaptor.toString().trim()
  }
}