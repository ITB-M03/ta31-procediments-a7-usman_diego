package controllers

import java.util.*

/**
 * Funció principal que executa el programa de la pila.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 */
fun main() {
    val pila = Pila()
    val scanner = Scanner(System.`in`)

    var opcio: Int
    do {
        mostrarMenu()
        print("Seleccioneu una opció: ")
        opcio = scanner.nextInt()

        when (opcio) {
            1 -> {
                print("Introduïu el número a afegir: ")
                val numero = scanner.nextInt()
                pila.push(numero)
            }
            2 -> pila.pop()
            3 -> pila.mostrarContingut()
            4 -> pila.top()
            5 -> println("Adéu!")
            else -> println("Opció no vàlida. Torneu-ho a intentar.")
        }

    } while (opcio != 5)
}

/**
 * Mostra el menú d'opcions per a la gestió de la pila.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 */
fun mostrarMenu() {
    println("\nMenú d'opcions:")
    println("1.- Afegir número (push)")
    println("2.- Treure número (pop)")
    println("3.- Mostrar contingut de la pila")
    println("4.- Consultar el top de la pila")
    println("5.- Sortir")
}

/**
 * Classe que representa una pila implementada amb un array.
 *
 * @author Usman Rashid Parveen
 * @since 10/12/2024
 */
class Pila {
    private val MAX_SIZE = 10
    private val elements = IntArray(MAX_SIZE)
    private var topIndex = -1

    /**
     * Afegeix un element a la pila (*push*).
     *
     * @author Usman Rashid Parveen
     * @since 10/12/2024
     *
     * @param element Element que s'afegirà a la pila.
     */
    fun push(element: Int) {
        if (topIndex < MAX_SIZE - 1) {
            topIndex++
            elements[topIndex] = element
            println("$element afegit a la pila.")
        } else {
            println("La pila està plena. No es poden afegir més elements.")
        }
    }

    /**
     * Treu un element de la pila (*pop*).
     *
     * @author Usman Rashid Parveen
     * @since 10/12/2024
     */
    fun pop() {
        if (topIndex >= 0) {
            val element = elements[topIndex]
            topIndex--
            println("Element tret de la pila: $element")
        } else {
            println("La pila està buida. No es pot treure cap element.")
        }
    }

    /**
     * Mostra l'element al *top* de la pila sense eliminar-lo.
     *
     * @author Usman Rashid Parveen
     * @since 10/12/2024
     */
    fun top() {
        if (topIndex >= 0) {
            val element = elements[topIndex]
            println("Element al top de la pila: $element")
        } else {
            println("La pila està buida.")
        }
    }

    /**
     * Mostra el contingut de la pila.
     *
     * @author Usman Rashid Parveen
     * @since 10/12/2024
     */
    fun mostrarContingut() {
        if (topIndex >= 0) {
            print("Contingut de la pila: ")
            for (i in 0..topIndex) {
                print("${elements[i]} ")
            }
            println()
        } else {
            println("La pila està buida.")
        }
    }
}
