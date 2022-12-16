import java.util.Iterator;

public class Fila<T> implements Iterable<T>{
    No<T> primeiro;
    No<T> ultimo;

    public Fila(){
        this.primeiro = null;
        this.ultimo = null;
    }

    public void insert(T valor){
        No<T> novo = new No<T>(valor);
        //novo.setDado(valor);
        if(this.primeiro == null){
            this.primeiro = novo;
            this.ultimo = novo;
            novo.setProximo(null);
        }else{
            ultimo.setProximo(novo);
            novo.setProximo(null);
            this.ultimo = novo;
        }
    }

    public void check(){
        No<T> aux = this.primeiro;
        while(aux != null){
            System.out.println("Dados: " + aux.getDado());
            aux = aux.getProximo();
        }
    }

    public T remove(){
        No<T> aux = this.primeiro;
        if(this.primeiro == ultimo && this.primeiro != null){
            this.primeiro = null;
            ultimo = null;
        }else{
            this.primeiro = primeiro.getProximo();
        }
        return aux.getDado();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorFila<T>(this.primeiro);
    }
}