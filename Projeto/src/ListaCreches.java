public class ListaCreches {
    NodoCreche inicio = null;
    int total = 0;

    public void adicionar(String nome) {
        if (buscarIndice(nome) != -1) return;
        NodoCreche novo = new NodoCreche(nome, total++);
        if (inicio == null) {
            inicio = novo;
        } else {
            NodoCreche atual = inicio;
            while (atual.proximo != null) atual = atual.proximo;
            atual.proximo = novo;
        }
    }

    public int buscarIndice(String nome) {
        NodoCreche atual = inicio;
        while (atual != null) {
            if (atual.nome.equals(nome)) return atual.indice;
            atual = atual.proximo;
        }
        return -1;
    }

    public String buscarNome(int indice) {
        NodoCreche atual = inicio;
        while (atual != null) {
            if (atual.indice == indice) return atual.nome;
            atual = atual.proximo;
        }
        return null;
    }

    public int getTotal() {
        return total;
    }

}
