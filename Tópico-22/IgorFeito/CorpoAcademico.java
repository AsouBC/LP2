public class CorpoAcademico {
    private int matricula;
    private String nome, email, senha, cargo;

    public CorpoAcademico(String cargo, int matricula, String nome, String email, String senha){
        this.cargo = cargo;
        this.matricula = matricula;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public void setCargo(String cargo){
        String[] cargosValidos = {"Professor", "Aluno", "Administrativo"};
        for(String cargoValido : cargosValidos){
            if(cargoValido.equals(cargo)){
                this.cargo = cargo;
                return;
            }
        }
        throw new IllegalArgumentException("Cargo inválido");
    }
    
    public String getNome(){
        return this.nome;
    }

    public int getMatricula(){
        return this.matricula;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSenha(){
        return this.senha;
    }

    public String getCargo(){
        return this.cargo;
    }

    @Override
    public String toString() {
        return cargo + ";" + matricula + ";" + nome + ";" + email + ";" + senha;
    }
}
