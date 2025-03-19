package src.dominio;

import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Clase que proporciona utilidades matemáticas.
 * Actualmente, incluye métodos para calcular aproximaciones de constantes matemáticas como Pi.
 */
public class Matematicas{

    /**
     * Genera una aproximación del número Pi utilizando el método de Montecarlo de forma funcional.
     *
     * <p>
     * El método simula lanzar puntos aleatorios dentro de un cuadrado unitario y cuenta cuántos de estos puntos caen dentro de un círculo inscrito en ese cuadrado.
     * La proporción de puntos dentro del círculo con respecto al total de puntos lanzados se utiliza para aproximar el valor de Pi.
     * </p>
     *
     * <p>
     * El cálculo se realiza utilizando programación funcional y streams paralelos para mejorar el rendimiento,
     * especialmente para un gran número de pasos.
     * </p>
     *
     * @param pasos La cantidad de puntos aleatorios que se generarán para la simulación. Un mayor número de pasos generalmente resulta en una aproximación más precisa de Pi,
     *              pero también requiere más tiempo de cómputo.
     * @return Un valor de tipo double que representa la aproximación calculada del número Pi.
     *         Esta aproximación se basa en la simulación de Montecarlo y puede variar ligeramente en cada ejecución debido a la naturaleza aleatoria del proceso.
     *
     * @see Random
     * @see Supplier
     * @see BiPredicate
     * @see IntStream
     */
    public static double generarNumeroPiFuncional(long pasos){
        Random random = new Random();

        Supplier<Double> coordenada = random::nextDouble;
        BiPredicate<Double, Double> dentroCirculo = (x, y) -> Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) <= 1;
        long puntosDentroCirculo = LongStream.
                range(0, (int)pasos).
                filter(i -> {
                    double x = coordenada.get();
                    double y = coordenada.get();
                    return (dentroCirculo.test(x, y));
                }).
                count();
        return 4 * ((double)puntosDentroCirculo / pasos);
    }
}