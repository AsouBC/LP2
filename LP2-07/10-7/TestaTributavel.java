interface Tributavel{
    double calculaTributos();
}

interface Conta{
    double getSaldo();
    void deposita(double valor);
    void retira(double valor);
    void atualiza(double tavaSelic);
}

interface ContaTributavel extends Conta, Tributavel {
}
    

class ContaCorrente implements Conta, ContaTributavel{
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

    public double calculaTributos(){
        return this.saldo * 0.01;
    }
    
    public void deposita(double valor){
        this.saldo += valor;
    }

    public void transfere(double valor, ContaCorrente destino){
        if(saldo >= valor){
            this.saldo -= valor;
            destino.saldo += valor;
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public void retira(double valor){
        this.saldo -= valor;
    }

    public void atualiza(double tavaSelic){
    }
}

class ContaPoupança implements Conta, Tributavel{
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

    public double calculaTributos(){
        return this.saldo * 0.01;
    }
    
    public void deposita(double valor){
        this.saldo += valor;
    }

    public void transfere(double valor, ContaCorrente destino){
        if(saldo >= valor){
            this.saldo -= valor;
            destino.saldo += valor;
        }
    }

    public double getSaldo(){
        return saldo;
    }

    public void retira(double valor){
        this.saldo -= valor;
    }

    public void atualiza(double tavaSelic) {
        this.saldo = this.saldo + (this.saldo * (tavaSelic/100));
    }
}

class SeguroDeVida implements Tributavel{
    public double calculaTributos(){
        return 42;
    }
}

class TestaTributavel{
    public static void main(String[] args) {
        ContaPoupança cc= new ContaPoupança();
        cc.deposita(100);
        Tributavel t = cc;
        System.out.println(t.calculaTributos());
    }
}