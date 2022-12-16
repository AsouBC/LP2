import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class SubstituiPalavra{  //Parte 2
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner ler = new Scanner(System.in);
        String palavra, novaPalavra;
        File arquivo = new File(args[0]);
        File novoArquivo = new File("novoArquivo.txt");

        System.out.println("Digite a palavra a ser substituida no arquivo: ");
        palavra = ler.nextLine();

        System.out.println("Digite a nova palavra: ");
        novaPalavra = ler.nextLine();

        try{
        Scanner lerArq = new Scanner(arquivo);

        PrintWriter escrever = new PrintWriter(novoArquivo);

        while (lerArq.hasNextLine()){
            String[] linha = lerArq.nextLine().split("[ ,]");
            
            for(int i = 0; i < linha.length; i++){
                if(linha[i].toUpperCase().equals(palavra.toUpperCase())){
                    linha[i] = novaPalavra;
                }
            }
            String outraLinha = "";
            for(int i = 0; i < linha.length - 1; i++){
                outraLinha += linha[i] + " ";
            }
            outraLinha += linha[linha.length - 1];
            escrever.println(outraLinha);
        }
        ler.close();
        lerArq.close();
        escrever.close();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
    }
    arquivo.delete();
    novoArquivo.renameTo(arquivo);
    }
}