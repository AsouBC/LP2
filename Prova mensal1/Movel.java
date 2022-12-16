public class Movel{
    protected int numeroRodas, anoFabricacao;
    protected String fabricante;
    private int velocidade;

    public Movel(int numeroRodas, int anoFabricacao, String fabricante, int velocidade){
        this.numeroRodas = numeroRodas;
        this.anoFabricacao = anoFabricacao;
        this.fabricante = fabricante;
        setVelocidade(velocidade);
    }

    public int getVelocidade(){
        return this.velocidade;
    }

    public void setVelocidade(int velocidade){
        if(this.velocidade >= 0){
        this.velocidade = velocidade;
        }else{
            System.out.println("Erro, valor é nulo, vazio ou negativo");
        }
    }

    @Override
    public String toString(){
        return String.format("\nNumeroRodas: %d\nAnoFabricante: %d\nFabricante: %s\nVelocidade: %d\n", this.numeroRodas, this.anoFabricacao, this.fabricante, getVelocidade());
    }
}