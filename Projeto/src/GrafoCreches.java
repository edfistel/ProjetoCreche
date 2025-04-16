public class GrafoCreches {
    static final int MAX_CRECHES = 20;
    static int[][] adjacencias = new int[MAX_CRECHES][MAX_CRECHES];
    static double[][] distancias = new double[MAX_CRECHES][MAX_CRECHES];
    public static ListaCreches listaCreches = new ListaCreches();

    public static void adicionarCreche(String nome) {
        listaCreches.adicionar(nome);
    }

    public static int indiceCreche(String nome) {
        return listaCreches.buscarIndice(nome);
    }

    public static void adicionarConexao(String origem, String destino, double distancia) {
        int i = indiceCreche(origem);
        int j = indiceCreche(destino);
        if (i != -1 && j != -1) {
            adjacencias[i][j] = 1;
            adjacencias[j][i] = 1;
            distancias[i][j] = distancia;
            distancias[j][i] = distancia;
        }
    }

    public static void numeroConexoes() {
        for (int i = 0; i < listaCreches.getTotal(); i++) {
            int count = 0;
            for (int j = 0; j < listaCreches.getTotal(); j++) {
                if (adjacencias[i][j] == 1) count++;
            }
            System.out.println(listaCreches.buscarNome(i) + ": " + count + " conexões");
        }
    }

    public static void listarConexoesOrdenadas(String nome) {
        int i = indiceCreche(nome);
        if (i == -1) return;
        Nodo inicio = null;
        for (int j = 0; j < listaCreches.getTotal(); j++) {
            if (adjacencias[i][j] == 1) {
                Nodo novo = new Nodo();
                novo.indice = j;
                novo.distancia = distancias[i][j];
                novo.proximo = null;

                if (inicio == null || novo.distancia < inicio.distancia) {
                    novo.proximo = inicio;
                    inicio = novo;
                } else {
                    Nodo atual = inicio;
                    while (atual.proximo != null && atual.proximo.distancia < novo.distancia) {
                        atual = atual.proximo;
                    }
                    novo.proximo = atual.proximo;
                    atual.proximo = novo;
                }
            }
        }
        System.out.println("Conexões de " + nome + ":");
        Nodo atual = inicio;
        while (atual != null) {
            System.out.println(" -> " + listaCreches.buscarNome(atual.indice) + ": " + atual.distancia + " km");
            atual = atual.proximo;
        }
    }

    public static void distanciaEntre(String origem, String destino) {
        int i = indiceCreche(origem);
        int j = indiceCreche(destino);
        if (i != -1 && j != -1 && adjacencias[i][j] == 1) {
            System.out.println("Distância entre " + origem + " e " + destino + ": " + distancias[i][j] + " km");
        } else {
            System.out.println("Não há conexão direta entre " + origem + " e " + destino);
        }
    }

}