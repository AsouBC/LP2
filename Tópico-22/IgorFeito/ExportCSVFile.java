import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class ExportCSVFile {

    public void exportCSV(ArrayList<CorpoAcademico> dados, String filename) {
      File csv = new File(filename);
      try {
        PrintWriter writer = new PrintWriter(csv);
        writer.println("cargo;matricula;nome;email;senha;turma;setor");
        for (int i = 0; i < dados.size(); i++) {
          writer.println(dados.get(i));
        }
        writer.println();
        writer.close();
      } catch (Exception e) {
        System.out.println("Erro: " + e.getMessage());
      }
    }
  }