package Gauss_Jacobi_Seidel;

public class metodo {

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