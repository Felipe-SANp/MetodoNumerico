package Gauss_Jacobi_Seidel;
import java.util.Scanner;

public class menuGJS {
    private static final String menuOpciones = """
        Métodos de solución de sistemas de ecuaciones lineales
        1. Método de Gauss-Jacobi
        2. Método de Gauss-Seidel
        3. Salir
        """;

    private static final String menuGaussJacobi = """
        Método de Gauss-Jacobi
        1. Ingresar matriz
        2. Ingresar la iteración máxima
        3. Calcular
        4. Salir
        """;

    private static final String menuGaussSeidel = """
        Método de Gauss-Seidel
        1. Ingresar matriz
        2. Ingresar la iteración máxima
        3. Calcular
        4. Salir
        """;

    private static void print(String texto){
        System.out.printf("\n%s",texto);
    }

    private static void gauss_Jacobi(Scanner scn, int version){
        double[][] matriz = null;
        double[] vector = null;
        double tolerancia = 0;
        int iteraciones = 100;
        int n;
        int op;

        do {
            if(version == 1){
                print(menuGaussJacobi);
            }
            else if(version == 2){
                print(menuGaussSeidel);
            }

            print("Seleccione una opción: ");
            op = scn.nextInt();
            switch (op){
                case 1 -> {
                    print("Ingrese el tamaño de la matriz cuadrática: ");
                    n = scn.nextInt();
                    matriz = new double[n][n];
                    int f = 0;
                    print("");
                    for (int i = 0; i < n; i++) {
                        f++;
                        System.out.print("\r Ingrese los valores de la fila " + f + ": ");
                        for (int j = 0; j < n; j++) {
                            matriz[i][j] = scn.nextDouble();
                        }
                    }
                    vector = new double[matriz.length];
                    print("Ingrese los valores del vector de soluciones: ");
                    for (int i = 0; i < vector.length; i++) {
                        vector[i] = scn.nextDouble();
                    }
                    print("Ingrese la tolerancia: ");
                    tolerancia = scn.nextDouble();
                }

                case 2 -> {
                    print("Ingrese el número de iteraciones máximos: ");
                    iteraciones = scn.nextInt();
                }
                case 3 -> {
                    assert vector != null;
                    double[] resultado;
                    if(version == 1){
                        resultado = metodo.jacobi(matriz, vector, tolerancia, iteraciones);
                        print("\nResultados finales:\n");
                        for (double valor : resultado) {
                            System.out.printf(" * %.4f \n",valor);
                        }
                    }
                    else if(version == 2){
                        resultado = metodo.gaussSeidel(matriz, vector, tolerancia, iteraciones);
                        print("\nResultados finales:\n");
                        for (double valor : resultado) {
                            System.out.printf(" * %.4f \n",valor);
                        }
                    }
                }
                case 4 -> System.out.print("Saliendo...\n");
                default -> print("Opción no válida");
            }
        } while (op != 4);
    }

    public static void menu (Scanner scn){
        print(menuOpciones);
        print("Seleccione una opción: ");
        int opcion;
        opcion = scn.nextInt();
        switch (opcion){
            case 1 -> gauss_Jacobi(scn, 1);
            case 2 -> gauss_Jacobi(scn, 2);
            case 3 -> print("Saliendo...\n");
            default -> print("Opción no válida");
        }
    }
}
