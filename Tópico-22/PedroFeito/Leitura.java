import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leitura {

    String atributos[];

    public boolean Ler(String Caminho, String matricula, String email, String senha) {
        try {
            FileReader arq = new FileReader(Caminho);
            try (BufferedReader lerArq = new BufferedReader(arq)) {
                String linha = "";
                try {
                    linha = lerArq.readLine();
                    while (linha != null) {
                        atributos = linha.split(";");
                        if (atributos[1].toLowerCase().equals(matricula.toLowerCase())
                                && atributos[4].toLowerCase().equals(senha.toLowerCase())) {
                            return true;
                        }
                        linha = lerArq.readLine();
                    }
                    arq.close();

                } catch (FileNotFoundException ex) {
                    System.out.println("Erro: Arquivo não encontrado!");
                }
            }

        } catch (IOException ex) {
            System.out.println("Erro: Não foi possível ler o arquivo!");

        }
        return false;
    }

    public String[] getAtributos() {
        return this.atributos;
    }
}