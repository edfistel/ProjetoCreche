public class GrafoCreches {
    static final int MAX_CRECHES = 20;
    static final int SEM_CONEXAO = 0;

    static int[][] adjacencias = new int[MAX_CRECHES][MAX_CRECHES];
    static double[][] distancias = new double[MAX_CRECHES][MAX_CRECHES];
    static String[] nomes = new String[MAX_CRECHES];
    static int totalCreches = 0;


    public static void adicionarCreche(String nome) {
        nomes[totalCreches++] = nome;
    }

    public GrafoCreches(){
        GrafoCreches.adicionarCreche("JoanaTimoteo");
        GrafoCreches.adicionarCreche("AmaroCavalcante");
        GrafoCreches.adicionarCreche("AnaReinaldo");
        GrafoCreches.adicionarCreche("FranciscoPauloDeOliveira");
        GrafoCreches.adicionarCreche("JoãoGama");
        GrafoCreches.adicionarCreche("PorfiroGabrielDosAnjos");
        GrafoCreches.adicionarCreche("HiginoRoberto");
        GrafoCreches.adicionarCreche("AntonioMartins");
        GrafoCreches.adicionarCreche("JoseVicente");
        GrafoCreches.adicionarCreche("PedroFernandes");
        GrafoCreches.adicionarCreche("HerculanoDeMelo");

        GrafoCreches.adicionarConexao("JoanaTimoteo", "AmaroCavalcante", 2.9);
        GrafoCreches.adicionarConexao("JoanaTimoteo", "AnaReinaldo", 5.7);
        GrafoCreches.adicionarConexao("AmaroCavalcante", "AnaReinaldo", 5.7);
        GrafoCreches.adicionarConexao("AnaReinaldo", "JoãoGama", 13.6);
        GrafoCreches.adicionarConexao("JoãoGama", "FranciscoPauloDeOliveira", 14.7);
        GrafoCreches.adicionarConexao("JoãoGama", "PorfiroGabrielDosAnjos", 7.6);
        GrafoCreches.adicionarConexao("PorfiroGabrielDosAnjos", "HiginoRoberto", 1.5);
        GrafoCreches.adicionarConexao("PorfiroGabrielDosAnjos", "AntonioMartins", 7.9);
        GrafoCreches.adicionarConexao("HiginoRoberto", "AntonioMartins", 10.0);
        GrafoCreches.adicionarConexao("AntonioMartins", "JoseVicente", 12.9);
        GrafoCreches.adicionarConexao("JoãoGama", "PedroFernandes", 11.4);
        GrafoCreches.adicionarConexao("FranciscoPauloDeOliveira", "PedroFernandes", 3.6);
        GrafoCreches.adicionarConexao("PedroFernandes", "HerculanoDeMelo", 14.5);
    }
    public static int indiceCreche(String nome) {
        for (int i = 0; i < totalCreches; i++) {
            if (nomes[i].equals(nome)) return i;
        }
        return -1;
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
        for (int i = 0; i < totalCreches; i++) {
            int count = 0;
            for (int j = 0; j < totalCreches; j++) {
                if (adjacencias[i][j] == 1) count++;
            }
            System.out.println(nomes[i] + ": " + count + " conexões");
        }
    }

    public static void listarConexoesOrdenadas(String nome) {
        int i = indiceCreche(nome);
        if (i == -1) return;

        Nodo inicio = null;

        for (int j = 0; j < totalCreches; j++) {
            if (adjacencias[i][j] == 1) {
                Nodo novo = new Nodo();
                novo.indice = j;
                novo.distancia = distancias[i][j];
                novo.proximo = null;

                // Inserção ordenada
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
            System.out.println(" -> " + nomes[atual.indice] + ": " + atual.distancia + " km");
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