package br.com.alissonrs.polimorfismo;

import java.util.ArrayList;

public class Zoologico {

	public static void main(String[] args) {
		ArrayList<Mamifero> mamiferos = new ArrayList<Mamifero>();
		// Mamifero mama;
		// Cachorro cachorro;
		// Vaca vaca;
		// Gatos gato;

		//cachorro = new Cachorro("Snoopy");
		mamiferos.add(new Cachorro());
		mamiferos.add(new Vaca());
		mamiferos.add(new Gatos());

		for(Mamifero mamifero : mamiferos){
			mamifero.emitirSom();
			mamifero.mamar();
			mamifero.correr();
		}
	}

}