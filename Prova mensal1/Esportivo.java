public class Esportivo extends Movel {
    private int cilindradas, numPassageiros;

    public Esportivo(int numeroRodas, int anoFabricacao, String fabricante, int velocidade, int cilindradas, int numPassageiros){
        super(numeroRodas, anoFabricacao, fabricante, velocidade);
        setcilindradas(cilindradas);
        setnumPassageiros(numPassageiros);
    }

    public int getcilindradas(){
            return this.cilindradas;
    }

    public void setcilindradas(int cilindradas){
        if(this.cilindradas >= 0){
        this.cilindradas = cilindradas;
        }else{
            System.out.println("Erro, valor é nulo, vazio ou negativo");
        }
    }

    public int getnumPassageiros(){
            return this.numPassageiros;
    }

    public void setnumPassageiros(int numPassageiros){
        if(this.numPassageiros == 1 || this.numPassageiros == 2 || this.numPassageiros == 3 || this.numPassageiros == 4){
        this.numPassageiros = numPassageiros;
        }else{
            System.out.println("Erro, valor é nulo, vazio ou negativo");
        }
    }

    @Override
        public String toString() {
            return String.format("NumeroRodas: %d - AnoFabricante: %d - Fabricante: %s - Velocidade: %d - Cilindradas: %d - numPassageiros: %d", this.numeroRodas, this.anoFabricacao, this.fabricante, getVelocidade(), getcilindradas(), getnumPassageiros());
        }
}
