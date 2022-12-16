import java.util.Scanner;

public class Exercicio4{
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        float peso, altura, IMC;
        
        System.out.println("Digite o seu peso em quilos: ");
        peso = ler.nextFloat();
        System.out.println("Digite a sua altura em metros: ");
        altura = ler.nextFloat();

        IMC = peso/(altura * altura);
        
        System.out.println("Valor IMC: " + IMC);
        System.out.println("\nMAGREZA: MENOR QUE 18,5");
        System.out.println("\nNORMAl: ENTRE 18,5 E 24,9");
        System.out.println("\nSOBREPESO: ENTRE 24,9 E 30,0");
        System.out.println("\nOBESIDADE: 30,0 OU MAIOR.");
    }
}