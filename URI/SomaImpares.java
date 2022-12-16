import java.io.IOException;
import java.util.Scanner;
 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class SomaImpares {
 
    public static void main(String[] args) throws IOException {
 
        Scanner ler = new Scanner(System.in);
        int n, x, y, soma = 0, min, max;

        n = ler.nextInt();

        for(int i = 0; i < n; i++){
            x = ler.nextInt();
            y = ler.nextInt();
            
            min = Math.min(x, y);
            max = Math.max(x, y);

            
            for(int j = min + 1; j < max; j++){
                if(j % 2 != 0){
                    soma += j;
                }
            }
            System.out.println(soma);
            soma = 0;
        }
 
    }
 
}