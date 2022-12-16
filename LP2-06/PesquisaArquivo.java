import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PesquisaArquivo{  //Parte 1
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> linhasNumero = new ArrayList<Integer>();
        
        Scanner ler = new Scanner(System.in);
        String palavra;
        int contador = 1;

        System.out.println("Digite a palavra a ser procurada no arquivo: ");
        palavra = ler.nextLine();

        File arquivo = new File(args[0]);
        Scanner sc = new Scanner(arquivo);
        while (sc.hasNextLine()){
            String[] linha = sc.nextLine().split("[ ,]");
            for(int i = 0; i < linha.length; i++){
                if(linha[i].toUpperCase().equals(palavra.toUpperCase())){
                    linhasNumero.add(contador);
            }
        }
            contador++;
        }
        sc.close();

        System.out.println("A palavra " + palavra + " aparece nas linhas: " + linhasNumero);
    }
}