package br.com.alissonrs.polimorfismo;
public class Vaca extends Mamifero {
	@Override
	public void emitirSom(){
		//super.emitirSom();
		System.out.println("MUUUUUUUUUU!!");
	}

	@Override
	public void mamar() {
		System.out.println("Buuuu!!! Chuck, chuck");
	}

	@Override
	public void correr() {
		System.out.println("Vaca, run, run");
	}

	
}
