package controllers

import java.util.*

/**
 * Programa principal per validar l'accés d'un superusuari mitjançant una contrasenya.
 * Permet fins a tres intents per introduir la contrasenya correcta.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 */
fun main() {
    // Iniciem el scanner per llegir dades de l'usuari.
    val scan = Scanner(System.`in`)

    print("Introdueix la contrasenya: ")
    val password = scan.next()

    if (validarSuperusuari(password)) {
        println("Contrasenya correcta, pots accedir.")
    } else {
        println("Ho sentim, no tens més intents, no hi pots accedir.")
    }
}

/**
 * Valida l'accés d'un superusuari comprovant si la contrasenya introduïda és correcta.
 * L'usuari té un màxim de tres intents per introduir la contrasenya correcta.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 *
 * @param contrasenyaInicial La contrasenya introduïda inicialment per l'usuari.
 * @return Retorna `true` si la contrasenya és correcta, i `false` si l'usuari es queda sense intents.
 */
fun validarSuperusuari(contrasenyaInicial: String): Boolean {
    val passwordCorrecta = "passwordSecreta"
    val intentsMaxims = 3
    var intents = 0
    var contrasenya = contrasenyaInicial
    var contrasenyaCorrecta = false

    // Bucle que permet fins a tres intents
    while (intents < intentsMaxims && contrasenya != passwordCorrecta) {
        println("Incorrecte, prova de nou.")
        print("Introdueix la contrasenya: ")

        val novaContrasenya = Scanner(System.`in`).next()
        contrasenya = novaContrasenya
        intents++
    }

    // Verifica si la contrasenya final és correcta
    contrasenyaCorrecta = (contrasenya == passwordCorrecta)
    return contrasenyaCorrecta
}
