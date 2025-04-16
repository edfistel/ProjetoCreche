import java.util.Scanner;
public class LeitorArquivo {
    public static void carregarArquivo(String caminho, GrafoCreches grafo) {
        try { Scanner scanner = new Scanner(new java.io.File(caminho));
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(";");

                if (partes.length == 3) {
                    String origem = partes[0];
                    String destino = partes[1];
                    double distancia = Double.parseDouble(partes[2]);
                    grafo.adicionarCreche(origem);
                    grafo.adicionarCreche(destino);
                    grafo.adicionarConexao(origem, destino, distancia);
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
}

}