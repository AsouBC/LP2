import java.io.IOException;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Funcoes {
    public static void main(String[] args) throws IOException {
 
        Scanner ler = new Scanner(System.in);
        int n, x, y, r, b, c;

        n = ler.nextInt();
        
        for(int i = 0; i < n; i++){
            x = ler.nextInt();
            y = ler.nextInt();
            
            r = ((3*x) * ((3*x)) + (y*y));
            b = (2*(x*x)) + ((5*y) * (5*y));
            c = (-100*x) + (y*y*y);

            if(r > b && r > c){
                System.out.println("Rafael ganhou");
            }else if(b > r && b > c){
                System.out.println("Beto ganhou");
            }else if(c > r && c > b){
                System.out.println("Carlos ganhou");
            }

            }
            ler.close();
        }
    }