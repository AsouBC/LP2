package br.com.alissonrs.polimorfismo;
public class Gatos extends Mamifero{

    @Override
    public void mamar() {
        System.out.println("xuc, xuc, miau");
    }

    @Override
    public void correr() {
        System.out.println("Gato, run, run");
    }

    @Override
    public void emitirSom(){
        System.out.println("Miau, miau, miau");
    }
    
}
