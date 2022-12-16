package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Cliente;

public class Conexao {
    //acesso dos dados
    String file;
	private Cliente model;
	private Scanner sc;

    public Conexao(String filename, Cliente model){
        this.file = filename;
		this.model = model;
    }

    public void abrirConexao(){
        try
		{
			sc = new Scanner(new File(file));	
		}catch (FileNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
    }

    public void fecharConexao(){
		sc.close();
    }

	public void carregarDados()
	{
		sc.nextLine(); //Remove cabeçalho.					
		
		while (sc.hasNextLine()) {
			String[] linha = sc.nextLine().split(";", -1);
			Cliente c = new Cliente(linha[1], linha[0], linha[2], linha[3]);
			model.addCliente(c);
		}
	}
}
