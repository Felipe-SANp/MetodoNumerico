# Métodos Numéricos: Metodo de Regresión Lineal Simple
### Descripción
El método de regresión lineal simple es un método que se utiliza para encontrar la relación entre dos variables, una variable dependiente y una variable independiente. 
- La variable independiente se representa por X
- la variable dependiente se representa por Y. 

La relación entre estas dos variables se puede representar mediante una ecuación lineal de la forma `Y = aX + b`, donde:

    `a` y `b` son los coeficientes de la ecuación. 

El objetivo del método de regresión lineal simple es encontrar los valores de a y b que minimizan la suma de los errores cuadrados entre los valores reales de Y y los valores predichos de Y. 
Para encontrar estos valores, se utiliza el método de mínimos cuadrados, que consiste en minimizar la suma de los cuadrados de las diferencias entre los valores reales de Y y los valores predichos de Y. 
Una vez que se han encontrado los valores de a y b, se puede utilizar la ecuación lineal para predecir los valores de Y para cualquier valor de X.

# Clase `regresionSimple`

La clase `regresionSimple` implementa el método de Regresión Lineal Simple en Java utilizando la biblioteca Apache Commons Math.

## Métodos

### `regresionLineal(ArrayList<Double> x, ArrayList<Double> y)`

- Recibe dos listas de números reales, `x` y `y`, que representan los valores de las variables independiente y dependiente respectivamente. 
- Utiliza la clase `SimpleRegression` de Apache Commons Math para calcular los coeficientes de la ecuación de regresión lineal. 
- Retorna un arreglo de dos elementos, donde el primer elemento es la pendiente (`a`) y el segundo elemento es la intersección con el eje y (`b`).

### `llenarArreglo(ArrayList<Double> x, ArrayList<Double> y, int n)`

- Recibe dos listas de números reales, `x` y `y`, y un entero `n` que representa el número de elementos a ingresar en cada lista. 
- Solicita al usuario que ingrese los valores de `x` y `y` desde la consola.

### `imprimirArreglo(ArrayList<Double> x, ArrayList<Double> y)`

- Recibe dos listas de números reales, `x` y `y`, e imprime sus valores en la consola.

### `calcularPrediccion(double[] coeficientes, double x)`

- Recibe un arreglo de dos elementos que representan los coeficientes de la ecuación de regresión lineal y un número real `x`. 
- Calcula el valor de `y` utilizando la ecuación de regresión lineal y lo imprime en la consola.

### `menu()`

- Muestra un menú interactivo al usuario para ingresar los valores de `x` y `y`, calcular los coeficientes de la ecuación de regresión lineal, imprimir la ecuación y predecir valores de `y` para un valor de `x` dado.

## Uso

Para utilizar esta clase, primero se debe instanciar un objeto de la clase `regresionSimple` y luego llamar al método `menu()`. 
El usuario puede interactuar con el programa a través de la consola para ingresar los valores de `x` y `y`, calcular la ecuación de regresión lineal y predecir valores de `y`.