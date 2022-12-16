import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;

public class AlterarCSV {
    ArrayList<String> linhas = new ArrayList<>();
    String atributos[];
    int cont = 0, aux = 0;
    boolean trocou = false;
    public boolean Escrever(String Caminho, String dados, String matricula, String senha) {

        ArrayList<String> linhas = new ArrayList<String>();
        try {
            FileReader arq = new FileReader(Caminho);
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = "";
            try {
                linha = lerArq.readLine();
                while (linha != null) {
                    linhas.add(linha);
                    linha = lerArq.readLine();
                    if(linha != null)
                        atributos = linha.split(";");
                    if(atributos.length > 1){
                        if(atributos[1].equals(matricula) || atributos[4].equals(senha)){
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
                
            }catch (FileNotFoundException ex) {
                    System.out.println("Erro: Arquivo não encontrado!");
            }
            
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
           
            }

            File csv = new File(Caminho);
            try {
                PrintWriter writer = new PrintWriter(csv);
                for (int i = 0; i < linhas.size(); i++) {
                writer.println(linhas.get(i));
                }
                writer.println();
                writer.close();
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                return false;
            }
        return true;
    }
    
}

