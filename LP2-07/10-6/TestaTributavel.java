interface Tributavel{
    double calculaTributos();
}

class Conta{
    public int numero;
    public double saldo, limite;
    public String nome;
    public boolean saca(double valor){
        if(valor > saldo){
            return false;
        } else{
            return true;
        }
    }
    public void deposita(double valor){
        this.saldo += valor;
    }

    public void transfere(double valor, Conta destino){
        if(saldo >= valor){
            this.saldo -= valor;
            destino.saldo += valor;
        }
    }
    public void getSaldo() {
        System.out.printf("O saldo é: %.2f", saldo);
    }
}

class ContaCorrente extends Conta implements Tributavel{
    public double calculaTributos(){
        return this.saldo * 0.01;
    }
}

class SeguroDeVida implements Tributavel{
    public double calculaTributos(){
        return 42;
    }
}

class TestaTributavel{
    public static void main(String[] args) {
        ContaCorrente cc= new ContaCorrente();
        cc.deposita(100);
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
    }
}