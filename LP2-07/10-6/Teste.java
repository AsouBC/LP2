interface AreaCalculavel{
    double calculaArea();
}

class Quadrado implements AreaCalculavel{
    private int lado;

    public Quadrado(int lado){
        this.lado = lado;
    }

    public double calculaArea(){
        return this.lado * this.lado;
    }
}

class Retangulo implements AreaCalculavel{
    private int largura, altura;

    public Retangulo(int largura, int altura){
        this.largura = largura;
        this.altura = altura;
    }

    public double calculaArea(){
        return this.largura * this.altura;
    }
}

class Teste{
    public static void main(String[] args) {
        AreaCalculavel a = new Retangulo(3, 2);
        System.out.println(a.calculaArea());
    }
}