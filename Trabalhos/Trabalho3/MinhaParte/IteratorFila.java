import java.util.Iterator;

public class IteratorFila<T> implements Iterator<T>{
    private No<T> noAtual;

    public IteratorFila(No<T> primeiro){
        this.noAtual = primeiro;
    }

    @Override
    public boolean hasNext(){
        return noAtual != null;
    }

    @Override
    public T next(){
        T dado = noAtual.getDado();
        noAtual = noAtual.getProximo();
        return dado;
    }

    @Override
    public void remove(){
        throw new UnsupportedOperationException();
    }
}
