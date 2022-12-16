public class Professor extends CorpoAcademico{
    public Professor(String cargo, int matricula, String nome, String email, String senha){
        super(cargo, matricula, nome, email, senha);
    }

    @Override
    public String toString() {
        return super.toString() + ";" + ";";
    }
}
