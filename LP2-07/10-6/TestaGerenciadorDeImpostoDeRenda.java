class GerenciadorDeImpostoDeRenda{
    private double total;

    void adiciona(Tributavel t){
        System.out.println("Adicionando tributavel: " + t);

        this.total = this.total + t.calculaTributos();
    }

    public double getTotal(){
        return total;
    }

public static void main(String[] args) {
    GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();
    Conta conta = new Conta();

    SeguroDeVida sv = new SeguroDeVida();
    gerenciador.adiciona(sv);

    ContaCorrente cc= new ContaCorrente();
        cc.deposita(1000);
        gerenciador.adiciona(cc);

        System.out.println(gerenciador.getTotal());
        conta.getSaldo();
    }
}