package model;

import java.util.ArrayList;

public class Cliente {
    //gets e sets do objeto

    String nome;
    String matricula;
    String serie;
    String curso;
    
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome, String matricula, String serie, String curso){
        this.nome = nome;
        this.matricula = matricula;
        this.serie = serie;
        this.curso = curso;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getNome()
    {
        return nome;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public String getSerie()
    {
        return serie;
    }

    public void setSerie(String serie)
    {
        this.serie = serie;
    }

    public String getCurso()
    {
        return curso;
    }

    public void setCurso(String curso)
    {
        this.curso = curso;
    }

    public String getMatricula()
    {
        return matricula;
    }
	
	public ArrayList<Cliente> getClientes(){
		return clientes;
	}
	
	public void addCliente(Cliente c) {
		clientes.add(c);
	}
}
