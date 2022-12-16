public class Alimento {
    public String dataValidade, tipo;

    public Alimento(String dataValidade, String tipo){
        this.dataValidade = dataValidade;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("Alimento [dataDeValidade=%s, tipo=%s]", dataValidade, tipo);
    }
}

class Pao extends Alimento{
    public boolean glutem;

    public Pao(String dataValidade, String tipo, boolean glutem) {
        super(dataValidade, tipo);
        this. glutem = glutem;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Pão [contemGlutem=%s]", glutem);
    }
}

class Grao extends Alimento{
    public int peso;

    public Grao(String dataValidade, String tipo, int peso){
        super(dataValidade, tipo);
        this.peso = peso;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Grão [Peso=%d]", peso);
    }
}

class Fruta extends Alimento{
    public double preco;

    public Fruta(String dataValidade, String tipo, double preco){
       super(dataValidade, tipo);
        this.preco = preco;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Fruta [Preço=%s]", preco);
    }
}

class Leite extends Alimento{
    String fabricante;

    public Leite(String dataValidade, String tipo, String fabricante){
        super(dataValidade, tipo);
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("Leite [Fabricante=%s]", fabricante);
    }
}