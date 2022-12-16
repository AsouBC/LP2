import java.io.IOException;
import java.util.Scanner;

public class Cedulas {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        int n, cem, cinquenta, vinte, dez, cinco, dois;

        n = ler.nextInt();

        System.out.println(n);

        cem = n / 100;
        n = n % 100;
        cinquenta = n / 50;
        n = n % 50;
        vinte = n / 20;
        n = n % 20;
        dez = n / 10;
        n = n % 10;
        cinco = n / 5;
        n = n % 5;
        dois = n / 2;
        n = n % 2;


        System.out.println(cem + " nota(s) de R$ 100,00");
        System.out.println(cinquenta + " nota(s) de R$ 50,00");
        System.out.println(vinte + " nota(s) de R$ 20,00");
        System.out.println(dez + " nota(s) de R$ 10,00");
        System.out.println(cinco + " nota(s) de R$ 5,00");
        System.out.println(dois + " nota(s) de R$ 2,00");
        System.out.println(n + " nota(s) de R$ 1,00");
        
    }
}
