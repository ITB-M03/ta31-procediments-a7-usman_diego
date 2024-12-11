package controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class Ex4KtTest {

 @Test
 fun testTitolTextCurt() {
  val outputStream = ByteArrayOutputStream()
  System.setOut(PrintStream(outputStream))

  // Texto de prueba
  titol("Hola")

  // Capturamos la salida y eliminamos espacios adicionales
  val result = outputStream.toString().trim()

  // Salida esperada, ignoramos espacios alrededor
  val expected = "                                        Hola"
  assertEquals(expected.trim(), result)
 }

 @Test
 fun testTitolTextLlarg() {
  val outputStream = ByteArrayOutputStream()
  System.setOut(PrintStream(outputStream))

  // Texto de prueba
  titol("Aquest és un text llarg")

  // Capturamos la salida y eliminamos espacios adicionales
  val result = outputStream.toString().trim()

  // Salida esperada
  val expected = "                       Aquest és un text llarg"
  assertEquals(expected.trim(), result)
 }

 @Test
 fun testTitolTextBuit() {
  val outputStream = ByteArrayOutputStream()
  System.setOut(PrintStream(outputStream))

  // Texto vacío
  titol("")

  // Capturamos la salida y eliminamos espacios adicionales
  val result = outputStream.toString().trim()

  // Salida esperada
  val expected = ""
  assertEquals(expected.trim(), result)
 }
 }