import java.io.IOException;
import java.util.Scanner;
import java.lang.Math;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Bhaskara {
 
    public static void main(String[] args) throws IOException {
 
        Scanner ler = new Scanner(System.in);
        Double a, b, c, delta, formula1, formula2;
        
        a = ler.nextDouble();
        b = ler.nextDouble();
        c = ler.nextDouble();
        
        delta = Math.pow(b, 2) - (4*a*c);

        formula1 = ((-b) + (Math.sqrt(delta))) / (2*a);
        formula2 = ((-b) - (Math.sqrt(delta))) / (2*a);

        if(delta < 0 || a == 0){
            System.out.println("Impossivel calcular");
        }else{
            System.out.printf("R1 = %.5f\n", formula1);
            System.out.printf("R2 = %.5f\n", formula2);
        }
 
    }
 
}