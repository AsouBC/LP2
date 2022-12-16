import java.io.*;
import java.util.*;

public class ReadCSVFile{
	public ArrayList<CorpoAcademico> readCSV(String fileName, ArrayList<CorpoAcademico> corpoAcademico){
		try{
			String linha = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			br.readLine();
			while((linha = br.readLine()) != null){
				String[] values = linha.split(";");
				if(values[0].equals("Administrativo")){
					Administrativo adm = new Administrativo(values[0], Integer.parseInt(values[1]), values[2], values[3], values[4], values[6]);
					corpoAcademico.add(adm);
				}else if(values[0].equals("Aluno")){
					Aluno aluno = new Aluno(values[0], Integer.parseInt(values[1]), values[2], values[3], values[4], values[5]);
					corpoAcademico.add(aluno);
				}else if(values[0].equals("Professor")){
					Professor prof = new Professor(values[0], Integer.parseInt(values[1]), values[2], values[3], values[4]);
					corpoAcademico.add(prof);
				}
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return corpoAcademico;
	}
}
