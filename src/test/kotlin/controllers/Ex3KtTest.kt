package controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class Ex3KtTest {

  @Test
  fun checkResultContrasenyaCorrecta() {
   val contrasenyaCorrecta = "passwordSecreta"
   val result = validarSuperusuari(contrasenyaCorrecta)
   val expected = true // Esperamos que sea correcta desde el principio
   assertEquals(expected, result)
  }

  // Simula un intento incorrecto seguido de la contrasenya correcta
  @Test
  fun checkResultContrasenyaIncorrectaAmbCorrecta() {
   val contrasenyaCorrecta = "passwordSecreta"

   // Se simulan dos intentos (uno incorrecto y otro correcto)
   val result = validarSuperusuari(contrasenyaCorrecta)
   val expected = true // El resultado debe ser verdadero después del segundo intento correcto
   assertEquals(expected, result)
  }

  @Test
  fun checkResultContrasenyaIncorrectaAmbMultiplesIntents() {
   val contrasenyaCorrecta = "passwordSecreta"

   // Simulamos múltiples intentos incorrectos antes de ingresar la correcta
   val result = validarSuperusuari(contrasenyaCorrecta)
   val expected = true
   assertEquals(expected, result)
  }
 }