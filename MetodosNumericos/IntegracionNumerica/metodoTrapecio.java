package IntegracionNumerica;
import MetodoBiseccion.Evaluar;
import java.util.InputMismatchException;
import java.util.Scanner;
public class metodoTrapecio {
    static Scanner scn = new Scanner(System.in);
    /**
     * Método del trapecio
     * @param A: valor de a, límite inferior
     * @param B: valor de b, límite superior
     * @param n: valor de n, número de sub intervalos
     * @param fx: función f(x), ecuación a evaluar
     * @return resultado del método del trapecio <br>
     * @throws InputMismatchException si los valores ingresados no son correctos <br>
     * <h3> Notas sobre el método </h3>
     * <li>Si n = 0, se toma el valor de h como {@code b - a}</li>
     * <li>El resultado se calcula como {@code h * (f(a) + f(b) / 2)}</li>
     * <li>Si n > 0, se toma el valor de h como {@code (b - a) / n}</li>
     * <li>El resultado se calcula como {@code h/2 * (f(x_0) + 2[f(x_1) + .. + f(x_n-1)] + f(n))}</li>
     * <br>
     * Ejemplos de uso: <br>
     * <li>{@code trapecio("0", "4", 0, "x^2")} -> 32</li>
     * <li>{@code trapecio("0", "4", 5, "x^2")} -> 21.76</li>
     */
    public static double trapecio(String A, String B, int n, String fx) {
        double resultado;
        try {

            double a = Evaluar.evaluar(A, 0);
            double b = Evaluar.evaluar(B, 0);
            if (n > 0) {
                double[] x_i = new double[n+1];
                double h = (b - a) / n;

                System.out.println("\n * Valor de h: " + round(h, 4));

                for (int k = 0; k < n +1 ; k++) {

                    double temp = (a + k * h);
                    x_i[k] =  f(fx, temp);

                    System.out.printf(" * Valor de f(%s)_%s: %s \n", round(temp, 2),k, round(x_i[k], 4));
                }
                double sum = 0;
                for (int x = 1; x < n; x ++){ sum += x_i[x];}
                resultado = (h/2) * (x_i[0] + (2*(sum)) + x_i[n]);

            } else {

                double h = round((b - a), 2);

                System.out.println("\n * Valor de h: " + h);
                System.out.printf(" * Valor de f(%s): %s \n", a, round((f(fx, a)), 4) );
                System.out.printf(" * Valor de f(%s): %s \n", b, round((f(fx, b)), 4) );

                resultado = h * ((f(fx, a) + f(fx, b)) / 2);
            }
        } catch (InputMismatchException e) {
            System.out.println("Error al ingresar valores, verifique que sean correctos.");
            resultado = 0;
        }
        return round(resultado, 4);
    }

    public static double f(String f, double x) {
        return Evaluar.evaluar(f, x);
    }
    public static double round(double valor, int decimal){
        return Math.round(valor * Math.pow(10, decimal)) / Math.pow(10, decimal);
    }

    static final String Descripcion = """
            Nota: _para funciones con raíces utilice 'sqrt(valor)'_
            
            Metodo del trapecio
            
            Para este método, se necesita lo siguientes valores:
            1. valor de a:
            2. valor de b:
            3. valor de n: (si n = 0, se toma el valor de h como b - a)
            4. la función correspondiente de f(x)
            Ingrese a continuación aquellos valores en el orden establecido.
            """;

    static String print_str(String a){
        System.out.printf(" * %s : " ,a);
        return scn.next();
    }

    static int print_int (){
        System.out.printf(" * %s : " , "n");
        return scn.nextInt();
    }

    public static void menuTrapecio() {
        System.out.println(Descripcion);
        double a, b;
        try {
            do{
                do{
                    a = f(print_str("a"), 0);
                    b = f(print_str("b"), 0);
                    if(a > b){
                        System.out.println("Error: El valor de 'a' debe ser menor que el valor de 'b'");
                    }
                }while(a > b );

                System.out.println("\n resultado final : " + trapecio(String.valueOf(a), String.valueOf(b), print_int(), print_str("fx()")));
                System.out.print("\n ¿Desea realizar otra operación? (s/n): ");
            } while (scn.next().equalsIgnoreCase("s"));
        } catch (InputMismatchException e) {
            System.out.println("Error al ingresar valores, verifique que sean correctos.");
        }
    }
}