public class Setor extends Funcionario{
    protected String setor;

    public Setor(int id, String nome, String email, String senha, String cargo, String setor){
        super(id, nome, email, senha, cargo);
        this.setor = setor;
    }

    @Override
    public String toString(){
        return "Id: " + id + "\nNome: " + nome + "\nEmail: " + email + "\nSenha: " + imprimirSenha(senha) + "\nCargo: " + cargo + "\nSetor: " + setor;
        }
}