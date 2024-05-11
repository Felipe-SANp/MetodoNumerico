## METODO DE INTEGRACION NUMÉRICA DE LA REGLA DEL TRAPECIO
El método de Trapecio es un método numérico para la aproximación de una integral definida.
La idea es aproximar el área bajo la curva de una función f(x) dividiendo el intervalo de integración
en segmentos más pequeños, y aproximando el área de cada segmento con el área de un trapecio.

En la clase `metodoTrapecio.java`, el método `trapecio()` implementa este algoritmo.

## Fórmula
La fórmula para el método del trapecio es:
Para un número de intervalos `n` > 0, la fórmula es:

    - Aproximación de la integral = h/2 * (f(a) + 2 * f(x_1) + 2 * f(x_2) + ... + 2 * f(x_n) + f(b))
Para `n` = 0, la fórmula es:

    - Aproximación de la integral = h * (f(a) + f(b))/2

## Funcionamiento del método:

Recibe cuatro parámetros:
- Dos cadenas `A` y `B` que representan los límites de integración
- Un entero `n` que representa el número de segmentos en los que se dividirá el intervalo de integración
- Una cadena `fx` que representa la función a integrar.

Convierte las cadenas `A` y `B` a números decimales utilizando el método `evaluar()` de la clase `Evaluar.java`
- Este método evalúa una expresión matemática representada como una cadena.

Si `n` es mayor que cero, divide el intervalo de integración en `n` segmentos.
- Calcula el valor de la función en cada punto del segmento y almacena estos valores en el array `x_i`
- Luego, calcula la suma de estos valores, multiplica por `h/2` (donde `h` es el ancho de cada segmento)
- Suma los valores de la función en los puntos inicial y final. Este es el valor aproximado de la integral.


Si `n` es cero, simplemente
- Calcula el valor de la función en los puntos inicial y final
- Toma el promedio de estos dos valores
- Multiplica por `h` (que en este caso es simplemente `b - a`). Este es el valor aproximado de la integral.

Finalmente, el método
- Devuelve el valor aproximado de la integral
- Redondeado a cuatro decimales.

## OTROS PUNTOS ADICIONALES DEL CÓDIGO
La clase `metodoTrapecio.java` contiene los métodos `trapecio()`, `f()`, `round()` y `main()`.

- El método `f()` simplemente evalúa la función en un punto dado, utilizando el método `evaluar()` de la clase `Evaluar.java`.
- El método `round()` se utiliza para redondear un número decimal a un número específico de decimales.
- El método `main()` proporciona una interfaz de línea de comandos para el método `trapecio()`:
-
  * Imprime una descripción del método del trapecio
  * Solicita al usuario que ingrese los límites de integración
  * El número de segmentos y la función a integrar
  * Termina imprimiendo el valor aproximado de la integral.

