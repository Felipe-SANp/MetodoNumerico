package MetodoBashForth;
import java.util.Scanner;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class adamsBashforth {

    // Método para evaluar la función f(t, y)
    public static double evaluateFunction(Expression f, double t, double y) {
        return f.setVariable("t", t).setVariable("y", y).evaluate();
    }

    // Método de Adams-Bashforth de 2 pasos
    public static double[] adamsBashforth2Steps(Expression f, double y0, double t0, double h, int nSteps) {
        double[] y = new double[nSteps + 1];
        double[] t = new double[nSteps + 1];
        y[0] = y0;
        t[0] = t0;

        // Primer paso usando Euler
        y[1] = y[0] + h * evaluateFunction(f, t[0], y[0]);
        t[1] = t[0] + h;

        for (int i = 1; i < nSteps; i++) {
            y[i + 1] = y[i] + (h / 2) * (3 * evaluateFunction(f, t[i], y[i]) - evaluateFunction(f, t[i - 1], y[i - 1]));
            t[i + 1] = t[0] + (i + 1) * h;
        }

        return y;
    }

    private static double requestDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Por favor ingrese un número.");
            }
        }
    }

    private static void printResults(double[] y, double a, double h, int nSteps) {
        System.out.println("\nResultados:");
        String[] column = {"i", "t_i", "y_i"};
        String[] datos = new String[nSteps + 1];
        for (int i = 0; i <= nSteps; i++) {
            double t = a + i * h;
            datos[i] = String.format("%d, %.2f, %.4f", i, t, y[i]);
        }

        // Imprimir la tabla
        System.out.println(crearTabla.table(column, datos, 20));
    }
    // ... (resto del código) ...

    public static void menuAdamsBashforth(Scanner scanner) {
        String equation;
        double y0 = 0, a = 0, b = 0, h = 0, l = 0;
        Expression f = null;

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Ingresar la ecuación diferencial");
            System.out.println("2. Ingresar datos para la ecuación (y0, a, b, h)");
            System.out.println("3. Calcular y obtener resultados");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume the newline

            switch (option) {
                case 1:
                    // Pedir al usuario la ecuación diferencial
                    while (true) {
                        System.out.print("Ingrese la ecuación diferencial en la forma de f(t, y): ");
                        equation = scanner.nextLine();

                        try {
                            f = new ExpressionBuilder(equation)
                                    .variables("t", "y")
                                    .build();
                            break;
                        } catch (Exception e) {
                            System.out.println("Error en la ecuación ingresada. Asegúrese de que esté en el formato correcto.");
                        }
                    }
                    break;
                case 2:
                    // Pedir la condición inicial
                    y0 = requestDoubleInput(scanner, "Ingrese la condición inicial y0: ");
                    // Pedir el intervalo
                    a = requestDoubleInput(scanner, "Ingrese el inicio del intervalo a: ");
                    b = requestDoubleInput(scanner, "Ingrese el final del intervalo b: ");
                    // Pedir el tamaño del paso h
                    h = requestDoubleInput(scanner, "Ingrese el tamaño del paso h: ");
                    l = 1;
                    break;
                case 3:
                    if (f == null || l == 0) {
                        System.out.println("\n - Primero debe ingresar la ecuación diferencial y los datos.");
                    } else {
                        // Calcular el número de pasos
                        int nSteps = (int) ((b - a) / h);

                        System.out.println("\nPasos (N) = " + nSteps);
                        System.out.println("\nFórmula del método de Adams-Bashforth de 2 pasos:");
                        System.out.println("w_{i+1} = w_i + (h/2) [3f(t_i, w_i) - f(t_{i-1}, w_{i-1})]");

                        System.out.println("\nCalcular y1 usando el método de Euler:");
                        System.out.printf("y1 = y0 + h * f(t0, y0) = %.4f + %.2f * f(%.2f, %.4f) = %.4f + %.2f * %.4f = %.4f\n",
                                y0, h, a, y0, y0, h, evaluateFunction(f, a, y0), y0 + h * evaluateFunction(f, a, y0));

                        // Ejecutar el método de Adams-Bashforth
                        double[] y = adamsBashforth2Steps(f, y0, a, h, nSteps);

                        // Imprimir los resultados detallados
                        System.out.println("""

                                Notas:
                                i = 1 se saco por el metodo de Euler
                                A partir de i = 2, se usa el metodo de Adams-Bashforth
                                """);

                        printResults(y, a, h, nSteps);
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opción no válida. Por favor seleccione una opción del menú.");
            }
        }
    }
}
