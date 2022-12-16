import java.io.*;
import java.util.*;

public class Ordenar { // Classe Principal

  public static void main(String[] args) {
    OpenTXTFile openTXTFile = new OpenTXTFile(); // Instanciando a classe OpenTXTFile
    MergeSort mergesort = new MergeSort(); // Instanciando a classe MergeSort
    InsertionSort insertionSort = new InsertionSort(); // Instanciando a classe InsertionSort
    ShellSort shellSort = new ShellSort(); // Instanciando a classe ShellSort
    ExportToCSVFile exportar = new ExportToCSVFile(); // Instanciando a classe ExportToCSVFile
    Vector<String> vetorDeStrings; // Vetor de Strings
    long startTime, endTime, duration; // Variáveis de tempo

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-ale.txt"); // Lendo o arquivo de entrada
    startTime = System.currentTimeMillis(); // Iniciando o tempo
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size()); // Ordenando o vetor de Strings
    endTime = System.currentTimeMillis(); // Finalizando o tempo
    duration = endTime - startTime; // Calculando o tempo
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-ale-ordenada-por-mergesort.csv"
    ); // Exportando o vetor de Strings ordenado para um arquivo CSV

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-cre-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-dec-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-ale-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-cre-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-dec-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-ale-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-cre-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings =
      mergesort.OrdenarViaMergeSort(vetorDeStrings, vetorDeStrings.size());
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-dec-ordenada-por-mergesort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-ale-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-cre-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-dec-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-ale-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-cre-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-dec-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-ale-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-cre-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = insertionSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-dec-ordenada-por-insertionsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-ale-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-cre-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-100-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-100-dec-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-ale-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-cre-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-1000-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-1000-dec-ordenada-por-shellshort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-ale.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-ale-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-cre.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-cre-ordenada-por-shellsort.csv"
    );

    vetorDeStrings = openTXTFile.LerTXT("entrada-10000-dec.txt");
    startTime = System.currentTimeMillis();
    vetorDeStrings = shellSort.ordenar(vetorDeStrings);
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    exportar.ExportarCSV(
      vetorDeStrings,
      duration,
      "entrada-10000-dec-ordenada-por-shellshort.csv"
    );
  }
}

class MergeSort { // Classe que ordena o vetor

  public Vector<String> OrdenarViaMergeSort(
    Vector<String> vetorDeStrings,
    int tamanhoDoVetor
  ) { // Método que ordena o vetor
    if (tamanhoDoVetor < 2) { // Se o tamanho do vetor for menor que 2, ele retorna o vetor original
      return vetorDeStrings;
    }
    int meio = tamanhoDoVetor / 2; // Divide o vetor em 2 partes
    Vector<String> vetorEsquerda = new Vector<>();
    Vector<String> vetorDireita = new Vector<>();
    for (int i = 0; i < meio; i++) {
      vetorEsquerda.add(vetorDeStrings.get(i));
    }
    for (int i = meio; i < tamanhoDoVetor; i++) {
      vetorDireita.add(vetorDeStrings.get(i));
    }
    vetorEsquerda = OrdenarViaMergeSort(vetorEsquerda, vetorEsquerda.size()); // Chama o método recursivamente para ordenar as partes
    vetorDireita = OrdenarViaMergeSort(vetorDireita, vetorDireita.size());
    vetorDeStrings = Merge(vetorEsquerda, vetorDireita, vetorDeStrings); // Junta as partes ordenadas
    return vetorDeStrings; // Retorna o vetor ordenado
  }

  public Vector<String> Merge(
    Vector<String> vetorEsquerda,
    Vector<String> vetorDireita,
    Vector<String> vetorDeStrings
  ) { // Método que junta as partes ordenadas
    int i = 0; // Contador para o vetor esquerda
    int j = 0; // Contador para o vetor direita
    int k = 0; // Contador para o vetor de coisas
    while (i < vetorEsquerda.size() && j < vetorDireita.size()) { // Enquanto não chegar no final dos dois vetores, faz a comparação e junta os vetores
      if (vetorEsquerda.get(i).compareTo(vetorDireita.get(j)) < 0) { // Se o elemento do vetor esquerda for menor que o do vetor direito, ele junta
        vetorDeStrings.set(k, vetorEsquerda.get(i));
        i++;
      } else { // Se o elemento do vetor direito for menor que o do vetor esquerda, ele junta
        vetorDeStrings.set(k, vetorDireita.get(j));
        j++;
      }
      k++; // Incrementa o contador do vetor de coisas
    }
    while (i < vetorEsquerda.size()) { // Se o vetor esquerda ainda tiver elementos, junta
      vetorDeStrings.set(k, vetorEsquerda.get(i));
      i++;
      k++;
    }
    while (j < vetorDireita.size()) { // Se o vetor direita ainda tiver elementos, junta
      vetorDeStrings.set(k, vetorDireita.get(j));
      j++;
      k++;
    }
    return vetorDeStrings; // Retorna o vetor ordenado
  }
}

class InsertionSort { //Método de ordenar usando o Insertion Sort

  public Vector<String> ordenar(Vector<String> vetor) { //Usando Vector<String>
    int i, j; //Declaração de variáveis
    String x; //Declaração de variáveis

    for (i = 1; i < vetor.size(); i++) { //Percorre o vetor
      x = vetor.get(i); //Pega o elemento do vetor
      j = i; //Pega o elemento do vetor
      while (j > 0 && x.compareTo(vetor.get(j - 1)) < 0) { //Compara o elemento com o elemento anterior
        vetor.set(j, vetor.get(j - 1)); //Se o elemento for menor, ele troca
        j--; //Decrementa o contador
      }
      vetor.set(j, x); //Se o elemento for maior, ele não troca
    }
    return vetor; // Retorna o vetor ordenado
  }
}

class ShellSort {
  Vector<String> listaNomes = new Vector<String>(); // Cria um vetor de Strings

  public Vector<String> ordenar(Vector<String> vectorNames) { // Método que ordena o vetor
    int i, j, h = 1; // Cria variaveis
    String temp; // Cria variavel
    while (h <= vectorNames.size() / 3) { // Enquanto h for menor ou igual ao tamanho do vetor dividido por 3, h recebe o valor de h + 1
      h = h * 3 + 1;
    }
    while (h > 0) { // Enquanto h for maior que 0,
      for (i = h; i < vectorNames.size(); i++) { // Para i igual a h,
        temp = vectorNames.get(i); // temp recebe o valor do vetor na posição i
        for (
          j = i;
          j >= h && vectorNames.get(j - h).compareTo(temp) > 0;
          j -= h
        ) { // Para j igual a i, e enquanto j for maior que h e o vetor na posição j - h for maior que temp,
          vectorNames.set(j, vectorNames.get(j - h)); // o vetor na posição j recebe o vetor na posição j - h
        }
        vectorNames.set(j, temp); // o vetor na posição j recebe o valor de temp
      }
      h = (h - 1) / 3; // h recebe o valor de h - 1 dividido por 3
    }
    return vectorNames; // Retorna o vetor ordenado
  }
}

class OpenTXTFile { // Classe que lê o arquivo TXT e retorna um vetor com os dados

  public Vector<String> LerTXT(String file) {
    Scanner scanner;
    File txt = new File(file);
    Vector<String> vetorDeStrings = new Vector<>();

    try { // Tenta abrir o arquivo
      scanner = new Scanner(txt);
      scanner.nextLine(); // Pula a primeira linha do arquivo

      while (scanner.hasNextLine()) { // Enquanto o arquivo ainda tiver linhas, pega os dados
        String line = scanner.nextLine(); // Pega a linha
        vetorDeStrings.add(line); // Adiciona o dado no vetor
      }
      scanner.close(); // Fecha o scanner
    } catch (Exception e) { // Se der erro, exibe a mensagem
      System.out.println("Erro: " + e.getMessage());
    }
    return vetorDeStrings;
  }
}

class ExportToCSVFile { // Classe que exporta o vetor ordenado para um arquivo CSV

  public void ExportarCSV(
    Vector<String> vetorDeStrings,
    long duration,
    String filename
  ) {
    File csv = new File(filename); // Cria o arquivo CSV
    try {
      PrintWriter writer = new PrintWriter(csv);
      writer.println("Nomes ordenados"); // Cabeçalho do arquivo
      for (int i = 0; i < vetorDeStrings.size(); i++) { // Percorre o vetor e escreve os dados no arquivo
        writer.println(vetorDeStrings.get(i));
      }
      writer.println();
      writer.println("Tempo de execução: " + duration + " milissegundos"); // Escreve o tempo de execução no
      // arquivo
      writer.close();
    } catch (Exception e) { // Se der erro, exibe a mensagem
      System.out.println("Erro: " + e.getMessage());
    }
  }
}
/*
 * Fontes Consultadas:
 * https://www.baeldung.com/java-csv
 * https://www.youtube.com/watch?v=HnO13VKQJKo
 * https://www.javatpoint.com/java-vector#:~:text=Vector%20is%20like%20the%20dynamic,is%20found%20in%20the%20java.
 * https://www.baeldung.com/java-merge-sort
 * http://www.universidadejava.com.br/pesquisa_ordenacao/merge-sort/
 * https://beginnersbook.com/2018/10/java-program-to-sort-strings-in-an-alphabetical-order/
 * https://www.w3schools.com/java/ref_string_compareto.asp
 * https://www.youtube.com/watch?v=xLDViuYlqGM
 * https://github.com/devsuperior/aulao002
 * https://copilot.github.com
 * https://www.arquivodecodigos.com.br/dicas/3850-java-java-insertion-sort-como-ordenar-um-vetor-de-inteiros-usando-a-ordenacao-insertion-sort-ordenacao-por-insercao.html
 * https://www.youtube.com/watch?v=4P95xpLjbQ4
 * https://codegym.cc/groups/posts/insertion-sort-in-java
 * https://www.guj.com.br/t/ordenacao-de-string-insertion-sort/75346
 * https://stackabuse.com/insertion-sort-in-java/
 * http://tufangorel.blogspot.com/2015/10/insertion-sort-comparable-array-items-in-java.html
 * https://www.youtube.com/watch?v=0lOnnd50cGI
 */
