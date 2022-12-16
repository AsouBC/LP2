public class Administrativo extends CorpoAcademico{
    private String setor;

    public Administrativo(String cargo, int matricula, String nome, String email, String senha, String setor){
        super(cargo, matricula, nome, email, senha);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        String[] setoresValidos = {"Secretaria", "Biblioteca", "Estágio"};
        for(String setorValido : setoresValidos){
            if(setorValido.equals(setor)){
                this.setor = setor;
                return;
            }
        }
        throw new IllegalArgumentException("Setor inválido");
    }

    @Override
    public String toString() {
        return super.toString() + ";" + ";" + setor;
    }
}
