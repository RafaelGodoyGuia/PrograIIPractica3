package src.principal;

import src.dominio.Matematicas;

/**
 * Clase principal que contiene el método main para ejecutar la aplicación.
 * <p>
 * Esta clase sirve como punto de entrada del programa y demuestra el uso de la clase {@link Matematicas}
 * para calcular y mostrar una aproximación del número Pi.
 * </p>
 */
public class Main {

    /**
     * Método principal que inicia la ejecución del programa.
     * <p>
     * En este método, se invoca el método {@link Matematicas#generarNumeroPiFuncional(long)} para calcular
     * una aproximación de Pi utilizando 1,000,000 pasos y se imprime el resultado en la consola.
     * </p>
     *
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args){
        System.out.println(Matematicas.generarNumeroPiFuncional(1000000));
    }
}
