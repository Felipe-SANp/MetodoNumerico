package IntegracionNumerica;

import MetodoBashForth.crearTabla;
import MetodoBiseccion.Evaluar;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class metodoTrapecio {
    static Scanner scn = new Scanner(System.in);


    public static double trapecio(String A, String B, int n, String fx) {
        double resultado;
        ArrayList<String> datos = new ArrayList<>();
        try {
            double a = Evaluar.evaluar(A, 0);
            double b = Evaluar.evaluar(B, 0);
            if (n > 0) {
                double[] x_i = new double[n + 1];
                double h = (b - a) / n;

                for (int k = 0; k < n + 1; k++) {
                    double temp = (a + k * h);
                    x_i[k] = f(fx, temp);
                    datos.add(String.format("%s, %s", round(temp, 2), round(x_i[k], 4)));
                }
                double sum = 0;
                for (int x = 1; x < n; x++) {
                    sum += x_i[x];
                }
                resultado = (h / 2) * (x_i[0] + (2 * (sum)) + x_i[n]);

            } else {
                double h = round((b - a), 2);
                resultado = h * ((f(fx, a) + f(fx, b)) / 2);
                datos.add(String.format("f(%s), %s", a, round((f(fx, a)), 4)));
                datos.add(String.format("f(%s), %s", b, round((f(fx, b)), 4)));
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al ingresar valores, verifique que sean correctos.");
            resultado = 0;
        }

        String[] columnas = {"f(x)", "Obtenido"};
        String[] datosArray = datos.toArray(new String[0]);
        System.out.println("\n Resultados: \n");
        System.out.println(crearTabla.table(columnas, datosArray, 12));

        return round(resultado, 4);
    }

    // Resto del código...


    public static double f(String f, double x) {
        return Evaluar.evaluar(f, x);
    }

    public static double round(double valor, int decimal) {
        return Math.round(valor * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }

    static final String Descripcion = """
            Nota: _para funciones con raíces utilice 'sqrt(valor)'_
            \nMetodo del trapecio
                       \s
            Para este método, se necesita lo siguientes valores:
            1. valor de a:
            2. valor de b:
            3. valor de n: (si n = 0, se toma el valor de h como b - a)
            4. la función correspondiente de f(x)
            Ingrese a continuación aquellos valores en el orden establecido.""";

    public static void menuTrapecio() {
        String fx = "";
        double a = 0, b = 0;
        int n;
        int opcion;
        System.out.println(Descripcion);
        String menu = """
                               \s
                Menu:
                1. Ingresar funcion f(x)
                2. Ingresar valores de a, b
                3. Ingresar numero de intervalos (n) y calcular
                4. Salir
               \s""";

        do {
            System.out.println(menu);
            System.out.print("Seleccione una opción: ");
            opcion = scn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la función f(x): ");
                    fx = scn.next();
                    break;
                case 2:
                    do {
                        System.out.print("Ingrese el valor de a: ");
                        a = scn.nextDouble();
                        System.out.print("Ingrese el valor de b: ");
                        b = scn.nextDouble();
                        if (a > b) {
                            System.out.println("Error: El valor de 'a' debe ser menor que el valor de 'b'");
                        }
                    } while (a > b);
                    break;
                case 3:
                    // asegurarse de que se haya ingresado la función y los valores de a y b
                    if (fx.isEmpty() || (a == 0 && b == 0)) {
                        System.out.println("Error: Ingrese la función y/o los valores de a y b primero");
                        break;
                    }

                    System.out.print("Ingrese el número de intervalos (n): ");
                    n = scn.nextInt();
                    System.out.println("\n Resultado final : " + trapecio(String.valueOf(a), String.valueOf(b), n, fx));
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 4);
    }
}