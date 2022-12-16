import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;

public class Conexao{

    public Conexao() throws FileNotFoundException{

        //Conexão com o driver JDBC
        String nomeJDBC = "jdbc:mysql://localhost/discdb";
        String option = "?useTimezone=true&serverTimezone=UTC";
        String nomeUser = "root";
        String password = "";
        File txtFile = new File("MusicaArtista.txt");

        try {
            PrintWriter pw = new PrintWriter(txtFile);
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(nomeJDBC+option, nomeUser, password);

            //Acessa um banco de dados Específico
            Statement st = con.createStatement();
            st.executeUpdate("USE " + "discdb");

            //Faz a consulta SQL
            //String pedido = "Select * from musica;";
            String pedido2 = "SELECT artista.Nome, musica.Titulo FROM discdb.artista AS artista JOIN discdb.disco AS discs ON discs.CodArt = artista.CodArt JOIN discdb.faixa AS faixs ON faixs.CodDisco = discs.CodDisco JOIN musica ON musica.CodMus = faixs.CodMus";

            ResultSet rs = st.executeQuery(pedido2);

            //Mostra o resultado da consulta

            ResultSetMetaData rsmd = rs.getMetaData();

            int numeroColunas = rsmd.getColumnCount();
            int numeroLinhas = 1;

            while(rs.next()){
                pw.println("REGISTRO: " + numeroLinhas);

                for(int col = 1; col <= numeroColunas; col++){
                    pw.println(rsmd.getColumnLabel(col) + ": ");
                    pw.println(rs.getString(col));
                }
                numeroLinhas++;
            }

            st.close();
            con.close();
            pw.close();
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Conexao();
    }
}