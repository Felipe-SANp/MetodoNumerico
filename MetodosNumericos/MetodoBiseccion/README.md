## Métodos Numéricos: Metodo de Biseccion 

Este proyecto se basa en el metodo de biseccion para resolver ecuaciones no lineales. 
El metodo consiste en dividir un intervalo de búsqueda `[a,b]` en dos sub intervalos y elegir la raíz entre ellos y terminar según un rango de margen de error. 

## Formulas usadas:

    - m = a+b/2 -----> salida: valor medio 
    - e = (b-a/2)*100 → salida: porcentaje de error

## Detalles del procedimiento

* Retornamos iteraciones cuando: se llegue a cierto porcentaje de error, o no se cumpla condiciones requeridas. 
* Pedimos valores como: Ecuación, rango y margen de error


### Checamos signos de a y b después de evaluarlas con la fórmula:

    - Tenemos valores de F(a), F(b) y F(m).
    - Sacamos comparaciones con el signo del F(m) con respecto a F(a) o F(b). 
    - Siempre existirá o debería existir al menos 2 elementos con signos diferentes. 
    - Aquellos serán nuestro nuevo rango en caso de que el error no sea un porcentaje de aproximación esperado 

## Condiciones para cada iteración en el metodo:

* Si media=0 -> Se termina el ciclo.
* Si |error| < margen tolerado → Se termina el ciclo.
* Si F(a)*F(b) > 0 → Se termina el ciclo (ya que significaría signos iguales entre las variables). 
* En cualquier otro caso, se debería poner un límite de iteraciones 