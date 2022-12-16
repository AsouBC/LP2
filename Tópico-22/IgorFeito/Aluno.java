public class Aluno extends CorpoAcademico{
    private String turma;
    public Aluno(String cargo, int matricula, String nome, String email, String senha, String turma){
        super(cargo, matricula, nome, email, senha);
        this.turma = turma;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        String[] turmasValidas = {"INF1", "ELE1", "CAMB1", "INF2", "ELE2", "CAMB2", "INF3", "ELE3", "CAMB3"};
        for(String turmaValida : turmasValidas){
            if(turmaValida.equals(turma)){
                this.turma = turma;
                return;
            }
        }
        throw new IllegalArgumentException("Turma inválida");
    }

    @Override
    public String toString() {
        return super.toString() + ";" + turma + ";";
    }
}
