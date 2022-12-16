//Várias práticas básicas de Java
//Vários exercício foram feitos nesse arquivo

package Prática1;

class Pratica1{
    public static void main(String[] args){
        int anterior = 0, atual = 1;
        while(atual < 10){
            System.out.println(atual);
            atual = anterior + atual;
            anterior = atual - anterior;
        }
        System.out.println(atual);
    }
}