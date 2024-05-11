## METODO GAUSS JACOBI

Este proyecto implementa el método iterativo de Gauss-Jacobi para resolver sistemas de
ecuaciones lineales. El método se aplica dentro de una clase método y se ejecuta desde un
método main que presenta un menú para que el usuario ingrese los valores necesarios.

### Fórmula y explicación
Antes de empezar a explicar el código debemos aclarar que el desarrollo del método de
Jacobi en lenguaje java fue basada bajo la siguiente fórmula Jacobiana:

     - x^k+1 = (D^-1 * b ) - { [ D^-1 * (L+U) ] * x^k

Donde:

-  `( x^k+1 )`: Esta es la aproximación de la solución del sistema de ecuaciones en la
   iteración `( k+1 )`.
- `( D^-1)`: Es la inversa de la matriz diagonal `( D )` de la matriz de coeficientes `( A )`. En
  el método de Jacobi, `( A )` se divide en tres matrices: la diagonal `( D )`, la triangular
  inferior `( L )` y el triangular superior `( U )`. La matriz `( D )` contiene solo los elementos
  de la diagonal principal de `( A )`, y su inversa `( D^-1 )` es fácil de calcular, ya que
  solo implica tomar el recíproco de los elementos de la diagonal.
- `( b )`: Es el vector de términos independientes del sistema de ecuaciones lineales.
- `( L+U )`: Es la suma de las matrices triangular inferior `( L )` y triangular superior `( U
  )` de la matriz de coeficientes `( A )`. Estas matrices contienen los elementos fuera de la
  diagonal principal de `( A )`.
- `( x^k )`: Es la aproximación actual o previa de la solución del sistema de ecuaciones
  en la iteración `( k )`.


## Código Gauss-Jacobi

El código java Gauss-Jacobi se encuentra en la carpeta `Gauss_Jacobi` y se divide en:
- [metodo.java](menuGJS.java): Clase que contiene el método de Jacobi.
- [menuGJS.java](menuGJS.java): Clase que presenta un menú para que el usuario ingrese los valores

### Condiciones de inicio
Para que el método de Jacobi funcione correctamente, se deben cumplir las siguientes condiciones para las matrices:
- Ser diagonalmente dominante.
- Ser simétrica.

### Detalles del procedimiento
Se pide al usuario que ingrese:
- El número de ecuaciones del sistema de ecuaciones
- Los valores de la matriz de coeficientes `( A )` y el vector de términos independientes `( b )`
- El número máximo de iteraciones
- El margen de error

Se ejecuta el método de Jacobi y se muestra la solución del sistema de ecuaciones

### Condiciones para cada iteración en el método:
- Si el error es menor que el margen de error, se termina el ciclo.
- Si el número de iteraciones es igual al número máximo de iteraciones, se termina el ciclo.
- En cualquier otro caso, se continúa con la siguiente iteración.

### Ejemplo de uso
Se tiene el siguiente sistema de ecuaciones lineales:
```     
       2x - 6y - z = - 38
     - 3x - 1y + 7z = - 34
     - 8x + 1y - 2z = - 20
```
Primero se organiza la matriz de coeficientes `( A )` y el vector de términos independientes `( b )`
de modo que se tenga en la matriz la diagonal dominante:
```     
     - 8x + 1y - 2z = - 20
       2x - 6y - z = - 38
     - 3x - 1y + 7z = - 34
```
Para este sistema de ecuaciones, la matriz de coeficientes `( A )` es:
```     
     -8 1 -2
     2 -6 -1
     -3 -1 7
```
El vector de términos independientes `( b )` es:
```     
     -20
     -38
     -34
```

### Durante la ejecución del programa:
- Se ingresa el tamaño de la matriz: 3 (3 ecuaciones)
- Se ingresan los valores de la matriz de coeficientes `( A )` y el vector de términos independientes `( b )`, por filas y de manera separada:
```     
     Fila 1: -8 1 -2
     Fila 2: 2 -6 -1
     Fila 3: -3 -1 7
```     
```     
     vector de soluciones: -20 -38 -34
```
- El vector de aproximación inicial `( x^0 )` siempre será un vector de ceros
- Se ingresa el número máximo de iteraciones: ejemplo `10`
- Se ingresa el margen de error: ejemplo _margen de %1_ = `0.001`
- Calculamos y obtenemos las soluciónes del sistema de ecuaciones para cada iteración
  hasta llegar a la solución final:
```     
Resultados 
 Iteración |  x_   |  resultado
    1         x_0     2.5000     
    1         x_1     6.3333     
    1         x_2     -4.8571
     
     ...
```  

```
 Resultados finales:
   * 3.9999
   * 7.9998
   * -2.0001
```## METODO GAUSS JACOBI

Este proyecto implementa el método iterativo de Gauss-Jacobi para resolver sistemas de
ecuaciones lineales. El método se aplica dentro de una clase método y se ejecuta desde un
método main que presenta un menú para que el usuario ingrese los valores necesarios.

### Fórmula y explicación 
Antes de empezar a explicar el código debemos aclarar que el desarrollo del método de
Jacobi en lenguaje java fue basada bajo la siguiente fórmula Jacobiana:

     - x^k+1 = (D^-1 * b ) - { [ D^-1 * (L+U) ] * x^k

Donde:

-  `( x^k+1 )`: Esta es la aproximación de la solución del sistema de ecuaciones en la
iteración `( k+1 )`.
- `( D^-1)`: Es la inversa de la matriz diagonal `( D )` de la matriz de coeficientes `( A )`. En
el método de Jacobi, `( A )` se divide en tres matrices: la diagonal `( D )`, la triangular
inferior `( L )` y el triangular superior `( U )`. La matriz `( D )` contiene solo los elementos
de la diagonal principal de `( A )`, y su inversa `( D^-1 )` es fácil de calcular, ya que
solo implica tomar el recíproco de los elementos de la diagonal.
- `( b )`: Es el vector de términos independientes del sistema de ecuaciones lineales.
- `( L+U )`: Es la suma de las matrices triangular inferior `( L )` y triangular superior `( U
)` de la matriz de coeficientes `( A )`. Estas matrices contienen los elementos fuera de la
diagonal principal de `( A )`.
- `( x^k )`: Es la aproximación actual o previa de la solución del sistema de ecuaciones
en la iteración `( k )`.


## Código Gauss-Jacobi

  El código java Gauss-Jacobi se encuentra en la carpeta `Gauss_Jacobi` y se divide en:
- [metodo.java](menuGJS.java): Clase que contiene el método de Jacobi.
- [menuGJS.java](menuGJS.java): Clase que presenta un menú para que el usuario ingrese los valores

### Condiciones de inicio
Para que el método de Jacobi funcione correctamente, se deben cumplir las siguientes condiciones para las matrices:
- Ser diagonalmente dominante.
- Ser simétrica.

### Detalles del procedimiento
Se pide al usuario que ingrese:
- El número de ecuaciones del sistema de ecuaciones
- Los valores de la matriz de coeficientes `( A )` y el vector de términos independientes `( b )`
- El número máximo de iteraciones
- El margen de error 

Se ejecuta el método de Jacobi y se muestra la solución del sistema de ecuaciones

### Condiciones para cada iteración en el método:
- Si el error es menor que el margen de error, se termina el ciclo.
- Si el número de iteraciones es igual al número máximo de iteraciones, se termina el ciclo.
- En cualquier otro caso, se continúa con la siguiente iteración.

### Ejemplo de uso
Se tiene el siguiente sistema de ecuaciones lineales:
```     
       2x - 6y - z = - 38
     - 3x - 1y + 7z = - 34
     - 8x + 1y - 2z = - 20
```
Primero se organiza la matriz de coeficientes `( A )` y el vector de términos independientes `( b )`
  de modo que se tenga en la matriz la diagonal dominante:
```     
     - 8x + 1y - 2z = - 20
       2x - 6y - z = - 38
     - 3x - 1y + 7z = - 34
```
Para este sistema de ecuaciones, la matriz de coeficientes `( A )` es:
```     
     -8 1 -2
     2 -6 -1
     -3 -1 7
```
El vector de términos independientes `( b )` es:
```     
     -20
     -38
     -34
```

### Durante la ejecución del programa:
- Se ingresa el tamaño de la matriz: 3 (3 ecuaciones)
- Se ingresan los valores de la matriz de coeficientes `( A )` y el vector de términos independientes `( b )`, por filas y de manera separada:
```     
     Fila 1: -8 1 -2
     Fila 2: 2 -6 -1
     Fila 3: -3 -1 7
```     
```     
     vector de soluciones: -20 -38 -34
```
- El vector de aproximación inicial `( x^0 )` siempre será un vector de ceros
- Se ingresa el número máximo de iteraciones: ejemplo `10`
- Se ingresa el margen de error: ejemplo _margen de %1_ = `0.001`
- Calculamos y obtenemos las soluciónes del sistema de ecuaciones para cada iteración
hasta llegar a la solución final:
```     
Resultados
Iteración |  x_   |  resultado
1         x_0     2.5000     
1         x_1     6.3333     
1         x_2     -4.8571

     ...
```  

```
Resultados finales:
* 3.9999
* 7.9998
* -2.0001
```