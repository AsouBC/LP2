import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;

public class Main {

    String entrada = "tabela.csv";
    String saida = "lista.csv";

    String cabecalho;

    List<Pessoal> ListaPessoal = new ArrayList<Pessoal>();
    ManipuladorDeBD manipular = new ManipuladorDeBD();

    public Main() throws FileNotFoundException{
        manipular = new ManipuladorDeBD();


        try {
            //Carrega do arquivo de entrada
            List<String> listaEntrada = ManipuladorDeArquivos.buscaLinhasEmArquivo(entrada);
            cabecalho = listaEntrada.remove(0); // remove cabeçalho
            carregaPessoal(listaEntrada);

           //Salva no arquivo de saida
            //List<String> listaSaida = converteListaPessoas2String();
            //listaSaida.add(0, cabecalho);
            //ManipuladorDeArquivos.gravaLinhasEmArquivo(saida, listaSaida);
            for(Pessoal pessoa : ListaPessoal){
                if(pessoa instanceof Aluno){
                    manipular.insert("INSERT INTO pessoal(cargo, matricula, nome, email, senha, turma, setor) values ('"+ pessoa.cargo + "','" + pessoa.matricula + "','" + pessoa.nome + "','" + pessoa.email + "','" + pessoa.senha + "','" + ((Aluno)pessoa).turma + "','" + null +"')");
                }else if(pessoa instanceof Administrativo){
                    manipular.insert("INSERT INTO pessoal(cargo, matricula, nome, email, senha, turma, setor) values ('"+ pessoa.cargo + "','" + pessoa.matricula + "','" + pessoa.nome + "','" + pessoa.email + "','" + pessoa.senha + "','" + null + "','" + ((Administrativo)pessoa).setor +"')");
                }else{
                    manipular.insert("INSERT INTO pessoal(cargo, matricula, nome, email, senha, turma, setor) values ('"+ pessoa.cargo + "','" + pessoa.matricula + "','" + pessoa.nome + "','" + pessoa.email + "','" + pessoa.senha + "','" + null + "','" + null +"')");
                }
            }

            manipular.closeDB();
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> converteListaPessoas2String() {
        List<String> lista = new ArrayList<String>();

        for(Pessoal pessoa : ListaPessoal) {
            lista.add(pessoa.toString());
        }

        return lista;
    }

    void carregaPessoal(List<String> lista) {
        Pessoal pessoa;

        String cargo;
        int matricula;
        String nome, email, senha;
        String turma = "", setor = "";

        for (String linha : lista) {

            String palavras[] = linha.split(";", -1);
            if (palavras.length < 5) {
                System.err.println("Linha mal formada: " + linha);
                continue;
            }
            cargo = palavras[0];
            matricula = Integer.parseInt(palavras[1]);
            nome = palavras[2];
            email = palavras[3];
            senha = palavras[4];

            if (palavras[5].length() != 0) { // Aluno
                turma = palavras[5];
                pessoa = new Aluno(cargo, matricula, nome, email, senha, turma);
            } else if (palavras[6].length() != 0) { // Administrativo
                setor = palavras[6];
                pessoa = new Administrativo(cargo, matricula, nome, email, senha, setor);
            } else { // Professor
                pessoa = new Professor(cargo, matricula, nome, email, senha);
            }
            ListaPessoal.add(pessoa);

        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new Main();
    }

}
