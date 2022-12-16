public class Tabalho1Artur extends LerArquivo{
    public static void main(String[] args){
        LerArquivo lerA = new LerArquivo();
        lerA.nomes = lerA.lerArquivo();
        InsertionSort insertionsort = new InsertionSort();
        insertionsort.insertionSort(lerA.nomes);
        for(int i = 0; i < lerA.nomes.size(); i++){
            System.out.println(lerA.nomes.get(i));
        }
    }
}
