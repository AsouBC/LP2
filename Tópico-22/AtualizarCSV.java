import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;

public class AtualizarCSV{
    ArrayList<String> linhas = new ArrayList<>();
    String valores[];
    int cont = 0, aux = 0;
    boolean trocou = false;

    public boolean Escrever(String Caminho, String dados, String email, String senha){
        ArrayList<String> linhas = new ArrayList<String>();
        try{
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try{
                linha = lerArq.readLine();
                while (linha != null) {
                    linhas.add(linha);
                    linha = lerArq.readLine();
                    if(linha != null)
                        valores = linha.split(";");
                    if(valores.length > 1){
                        if(valores[3].equals(email) || valores[4].equals(senha)){
                            aux = cont;
                            trocou = true;
                        }
                    }
                    cont++;
                }
            arq.close();

            if(trocou){
                linhas.set(aux + 1, dados);
            }
                
            }catch(FileNotFoundException ex){
                    System.out.println("Erro: Arquivo não encontrado!");
            }
            
            }catch(IOException ex){
                System.out.println("Erro: Não foi possível ler o arquivo!");
            }

            File arqCsv = new File(Caminho);
            try{
                PrintWriter pw = new PrintWriter(arqCsv);
                for(int i = 0; i < linhas.size(); i++){
                    pw.println(linhas.get(i));
                }
                pw.println();
                pw.close();
            }catch(Exception e) {
                System.out.println("Erro: " + e.getMessage());
                return false;
            }

        return true;
    }
}