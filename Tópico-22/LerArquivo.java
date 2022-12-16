import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LerArquivo{

    String valores[];

    public boolean lerArq(String Caminho, String email, String senha){
        try{
            FileReader arq = new FileReader(Caminho);
            try (BufferedReader lerArq = new BufferedReader(arq)){
                String linhas = "";
                try {
                    linhas = lerArq.readLine();
                    while (linhas != null) {
                        valores = linhas.split(";");
                        if (valores[3].toLowerCase().equals(email.toLowerCase()) && valores[4].toLowerCase().equals(senha.toLowerCase())) {
                            return true;
                        }
                        linhas = lerArq.readLine();
                    }
                    arq.close();

                }catch (FileNotFoundException ex){
                    System.out.println("Erro: Arquivo não encontrado!");
                }
            }

        }catch (IOException ex){
            System.out.println("Erro: Não foi possível ler o arquivo!");
        }

        return false;
    }

    public String[] getValores(){
        return this.valores;
    }
}