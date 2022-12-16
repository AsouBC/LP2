import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Principal {
    public static void main(String[] args) {
        ArrayList<Movel> listaMovel = new ArrayList<Movel>();
        int numeroRodas = 2, anoFabricacao = 2008, velocidade = 145;
        String fabricante = "Yamaha";

        System.out.println("\nQUESTÕES 1 E 2: ");

        Movel movel = new Movel(numeroRodas, anoFabricacao, fabricante, velocidade);

        System.out.println(movel.toString());

        System.out.println("\nQUESTÃO 3: \n");
        lerArq(listaMovel);
        for(Movel mov : listaMovel){
            System.out.println("-------------------------------");
            System.out.println(mov);
            System.out.println("\n");
        }

         /*
        System.out.println("Digite o número de rodas da moto: ");
        numeroRodas = ler.nextInt();
        System.out.println("Digite o fabricante da moto: ");
        ler.nextLine();
        fabricante = ler.nextLine();
        System.out.println("Digite o ano de fabricação da moto: ");
        anoFabricacao = ler.nextInt();
        System.out.println("Digite a vlocidade da moto: ");
        velocidade = ler.nextInt();
        */

        //ler.close();

    }

    public static void lerArq(ArrayList<Movel> listaMovel) {
        try (BufferedReader br = new BufferedReader(new FileReader("moveis.txt"))) {
            String linha = br.readLine();
            linha = br.readLine();
            while (linha != null) {
                String[] dados = linha.split(";");
                if(dados.length == 4) {
                    Movel mov = new Movel(Integer.parseInt(dados[0]), Integer.parseInt(dados[2]), dados[1], Integer.parseInt(dados[3]));
                    listaMovel.add(mov);
                } else if(dados.length == 6) {
                    Esportivo esp = new Esportivo(Integer.parseInt(dados[0]), Integer.parseInt(dados[2]), dados[1], Integer.parseInt(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]));
                    listaMovel.add(esp);
                } else if(dados.length == 8) {
                    Carga carg = new Carga(Integer.parseInt(dados[0]),  Integer.parseInt(dados[2]), dados[1], Integer.parseInt(dados[3]), Integer.parseInt(dados[6]), Integer.parseInt(dados[7]));
                    listaMovel.add(carg);
                }

                linha = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /*public static void lerArq(ArrayList<Movel> listaMovel) {
        try{
            File file = new File("moveis.txt");
            Scanner sc = new Scanner(file);
            String linha = sc.nextLine();
            linha = sc.nextLine();
            while(linha != null){
                String[] dados = sc.nextLine().split(";");
                if(dados.length == 4) {
                    Movel mov = new Movel(Integer.parseInt(dados[0]), Integer.parseInt(dados[2]), dados[1], Integer.parseInt(dados[3]));
                    listaMovel.add(mov);
                } else if(dados.length == 6) {
                    Esportivo esp = new Esportivo(Integer.parseInt(dados[0]), Integer.parseInt(dados[2]), dados[1], Integer.parseInt(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]));
                    listaMovel.add(esp);
                } else if(dados.length == 8) {
                    Carga carg = new Carga(Integer.parseInt(dados[0]),  Integer.parseInt(dados[2]), dados[1], Integer.parseInt(dados[3]), Integer.parseInt(dados[6]), Integer.parseInt(dados[7]));
                    listaMovel.add(carg);
                }

                linha = sc.nextLine();
            }
        }catch(Exception e){
            System.out.println("Erro ao abrir arquivo");
        }
    }*/
}
