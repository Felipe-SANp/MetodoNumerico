package Gauss_Jacobi_Seidel;

public class metodo {
    /*Clase para crear la función del método Gauss Seidel*/
    public static double[] gaussSeidel(double[][] matriz, double[] vector, double tolerancia, int iteraciones) {
        /*Función para resolver un sistema de ecuaciones lineales mediante el método de Gauss Seidel*/
        int n = vector.length;
        double[] x = new double[n];
        double[] xAnterior = new double[n];
        double error = tolerancia + 1;
        int contador = 0;

        System.out.println("\nResultados \n Iteración |  x_   |  resultado \n");

        while (error > tolerancia && contador < iteraciones) {
            System.arraycopy(x, 0, xAnterior, 0, n); // Copiar el contenido de x en xAnterior
            contador++;
            error = 0;

            for (int i = 0; i < n; i++) {
                double suma = 0;
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        suma += matriz[i][j] * x[j]; // Sumatoria de los elementos de la matriz
                    }
                }
                x[i] = (vector[i] - suma) / matriz[i][i]; // Fórmula de Gauss Seidel
                System.out.printf("    %d         x_%d     %.4f     \n", contador, i, x[i]);
            }
            System.out.println();

            for (int i = 0; i < n; i++) {
                error += Math.abs(x[i] - xAnterior[i]);
            }
        }
        return x;
    }

    // formula jacobiana: x^k+1 = (D^-1 * b ) - { [ D^-1 * (L+U) ] * x^k }
    public static double[] jacobi(double[][] matriz, double[] b, double tolerancia, int iteraciones){
        int n = b.length;
        double[] x_k = new double[n];
        double[] x_k2 = new double[n];
        double error = tolerancia + 1;
        int contador = 0;

        System.out.println("\nResultados \n Iteración |  x_   |  resultado \n");

        while (error > tolerancia && contador < iteraciones ) {
            System.arraycopy(x_k2, 0, x_k, 0, n); // Copia el contenido de x_k2 en x_k
            contador++;
            error = 0;

            for (int i = 0; i < n; i++) {
                double suma = 0;
                double inversa_D = 1 / matriz[i][i];

                for (int j = 0; j < n; j++) {
                    if (i != j){
                        suma += (inversa_D * matriz[i][j]) * x_k[j] ; // [ D^-1 * (L+U) ] * x^k
                    }
                }
                x_k2[i] = (inversa_D * b[i]) - suma; // Fórmula Jacobiana
                System.out.printf("    %d         x_%d     %.4f     \n", contador, i, x_k2[i]);
            }
            System.out.println();

            for (int i = 0; i < n; i++) {
                error += Math.abs(x_k2[i] - x_k[i]);
            }
        }
        return x_k2;
    }
}