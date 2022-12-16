public class Carga extends Movel {
    private int volumeMaximo, pesoMaximo;

    public Carga(int numeroRodas, int anoFabricacao, String fabricante, int velocidade, int volumeMaximo, int pesoMaximo){
        super(numeroRodas, anoFabricacao, fabricante, velocidade);
        setvolumeMaximo(volumeMaximo);
        setpesoMaximo(pesoMaximo);
    }

    public int getvolumeMaximo(){
        return this.volumeMaximo;
    }

    public void setvolumeMaximo(int volumeMaximo){
        if(this.volumeMaximo >= 0){
            this.volumeMaximo = volumeMaximo;
        }else{
            System.out.println("Erro, valor é nulo, vazio ou negativo");
        }
    }

    public int getpesoMaximo(){
        return this.pesoMaximo;
    }

    public void setpesoMaximo(int pesoMaximo){
        if(this.pesoMaximo >= 0){
            this.pesoMaximo = pesoMaximo;
        }else{
            System.out.println("Erro, valor é nulo, vazio ou negativo");
        }
    }

    @Override
        public String toString() {
            return String.format("NumeroRodas: %d - AnoFabricante: %d - Fabricante: %s - Velocidade: %d - VolumeMaximo: %d - PesoMaximo: %d", this.numeroRodas, this.anoFabricacao, this.fabricante, getVelocidade(), getvolumeMaximo(), getpesoMaximo());
        }
}
