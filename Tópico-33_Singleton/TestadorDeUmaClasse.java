class UmaClasse{
    static int contador = 0;
    private static UmaClasse instanciaUnica;
    
    /*public UmaClasse(){
        contador++;
    }*/

    private UmaClasse(){
        contador++;
    }

    public static UmaClasse instancia(){
        if(instanciaUnica == null){
            instanciaUnica = new UmaClasse();
        }
        return instanciaUnica;
    }

    public static int getContador(){
        return contador;
    }
}

public class TestadorDeUmaClasse{
    public static void main(String[] args){
        //UmaClasse uma;
        for(int i = 0; i < 4; i++){
            //uma = new UmaClasse();
            UmaClasse uma = UmaClasse.instancia();
        }
        System.out.println("Total de instâncias criadas = " + UmaClasse.getContador());
    }
}