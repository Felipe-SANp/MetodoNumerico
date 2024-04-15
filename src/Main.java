import ErrorAbsoluto.Menu_Error_Absoluto;
import Gauss_Jacobi_Seidel.menuGJS;
import MetodoBiseccion.MenuBiseccion;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        
        Scanner scn = new Scanner(System.in);
        int op;
        
        try {
            do {
                imprimir("\n MÉTODOS NUMÉRICOS \n");
                
                imprimir("""
                    
                    MENU PRINCIPAL DE OPCIONES

                    - 1. Ir a Código de Error Absoluto
                    - 2. Ir a Código de Metodo de Bisección
                    - 3. Ir a Código de Método de Gauss-Jacobi/Seidel
                    - 4. Terminar Código

                     Ingrese una Opcion: \
                    """
                );
                op = scn.nextInt();
            
                switch (op) {
                    case 1:
                        Menu_Error_Absoluto.menu1();
                    break;
                
                    case 2:
                        MenuBiseccion.menu2();
                    break;

                    case 3:
                        menuGJS.menu(scn);
                        break;
                
                    case 4:
                        imprimir("\nTerminando...");
                    break;
                    
                    default:
                        imprimir("Opcion invalida");
                    break;
                }
                
            } while (op!=4);
            
        } catch (InputMismatchException e) {
            imprimir("\n Error: Trate de ingresar solo números validos\n");
        } catch (Exception e){
            imprimir("\n Error: Trate de ingresar solo valores correspondidos\n");
        }
        
        scn.close();
    }

    public static void imprimir (String text){
        System.out.print(text);
    }
}