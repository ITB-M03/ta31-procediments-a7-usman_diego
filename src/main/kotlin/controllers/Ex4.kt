package controllers

import java.util.*

/**
 * Programa principal que permet centrar un text en una línia de consola amb una amplada fixa.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 */
fun main() {
    // Iniciem el scanner per llegir dades de l'usuari
    val scan = Scanner(System.`in`)

    print("Escriu un text: ")
    val text = scan.nextLine()

    titol(text) // Mostra el text centrat
}

/**
 * Mostra un text centrat a la consola basant-se en una amplada de pantalla fixa.
 *
 * Aquesta funció calcula el nombre d'espais necessaris per centrar el text
 * i el mostra alineat al centre de la pantalla.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 *
 * @param text Text que es mostrarà centrat.
 */
fun titol(text: String) {
    val ampladaPantalla = 80 // Amplada fixa de la línia de consola

    // Calcula els espais necessaris per centrar el text
    val espaisCentrals = (ampladaPantalla - text.length) / 2
    val centrarText = " ".repeat(espaisCentrals) + text

    println(centrarText)
}
