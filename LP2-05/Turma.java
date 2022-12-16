public class Turma extends Funcionario{
    protected String turma;

    public Turma(int id, String nome, String email, String senha, String cargo, String turma){
        super(id, nome, email, senha, cargo);
        this.turma = turma;
    }
    @Override
    public String toString(){
        return "Id: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nSenha: " + imprimirSenha(senha) + "\nCargo: " + cargo + "\nTurma: " + turma;
        }
}