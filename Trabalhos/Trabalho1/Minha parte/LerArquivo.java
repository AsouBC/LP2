import java.io.*;
import java.util.*;

public class LerArquivo{

	String path = "C:\\Users\\Artur Borges\\Desktop\\CEFET Stuff\\CEFET-INFO 3\\LP2\\Exercicio\\Trabalhos\\Trabalho1\\entrada-100-ale.txt";
	public ArrayList<String> nomes;

	public ArrayList<String> lerArquivo(){
		ArrayList<String> nomes = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				nomes.add(line);
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return nomes;
	}
}