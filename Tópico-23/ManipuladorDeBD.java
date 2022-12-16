import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ManipuladorDeBD {
    Connection con;
    Statement st;
    List<Pessoal> ListaPessoal = new ArrayList<Pessoal>();
    String entrada = "tabela.csv";

    public ManipuladorDeBD() throws FileNotFoundException{
        String nomeJDBC = "jdbc:mysql://localhost/recursoshumanos";
        String option = "?useTimezone=true&serverTimezone=UTC";
        String nomeUser = "root";
        String password = "";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(nomeJDBC+option, nomeUser, password);

            st = con.createStatement();
            //st.executeUpdate("USE " + "recursoshumanos");

        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public void insert(String query){
        try{
            st.executeUpdate(query);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try{
            con.close();
            st.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
