package model;

import java.util.ArrayList;

public class Pessoal{
    private String matricula;
    private String nome;
    private int serie;
    private String turma;

    private ArrayList<Pessoal> pessoal = new ArrayList<>();

    public Pessoal(){
    }

    public Pessoal(String string, String nome2, String string2, String turma2) {
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public ArrayList<Pessoal> getAlunos(){
		return pessoal;
	}

    /*@Override
    public String toString() {
        return "Matrícula: " + getMatricula() + " Nome: " + getNome() + " Serie: " + getSerie() + " Turma: " + getTurma() + System.lineSeparator() +
        "-------------------------------------------------------------------------------------------------------------------------------------------";
    }*/
}
