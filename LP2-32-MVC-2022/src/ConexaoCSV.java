import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import model.Pessoal;

//import java.util.Vector;
import java.io.File;
import java.io.FileNotFoundException;

public class ConexaoCSV implements ArrayPessoal{

	private static ConexaoCSV conexaoCSV;

	private ArrayList<Pessoal> pessoais = new ArrayList<>();

	private ConexaoCSV(){}

		public static ConexaoCSV instancia(){
			if(conexaoCSV == null){
				conexaoCSV = new ConexaoCSV();
			}
			return conexaoCSV;
		}

		@Override
		public ArrayList<Pessoal> getAllPessoa(){
			//ArrayList<Pessoal> lista = new ArrayList<>();
			
			try {
				Scanner leitor = new Scanner(new File("estudantes.csv"));
				leitor.nextLine(); //Remove cabeçalho.
				
				while (leitor.hasNextLine()){
					String linha = leitor.nextLine();
					String[] pessoas = linha.split(";", -1);
					Pessoal pessoal = new Pessoal();
					pessoal.setMatricula(pessoas[0]);
					pessoal.setNome(pessoas[1]);
					pessoal.setSerie(Integer.parseInt(pessoas[2]));
					pessoal.setTurma(pessoas[3]);
					pessoais.add(pessoal);
				}

			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (Exception e){
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			return pessoais;
		}
}