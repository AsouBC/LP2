import java.util.*;

public class InsertionSort extends LerArquivo{

    public void insertionSort(ArrayList<String> vetor){
        int i, j;
        String x;

        for (i = 1; i < vetor.size(); i++){
           x = vetor.get(i);
           j = i;
           while(j > 0 && x.compareTo(vetor.get(j - 1)) < 0){
               vetor.set(j, vetor.get(j - 1));
               j--;
           }
           vetor.set(j, x);
        }
    }
}
