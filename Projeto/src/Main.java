import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GrafoCreches grafo = new GrafoCreches();
        LeitorArquivo.carregarArquivo("Projeto\\src\\grafo.txt", grafo);

        Menu menu = new Menu();
        Scanner ler = new Scanner(System.in);
        boolean status = true;
        do {
            menu.MostrarMenu();
            status = menu.escolherOpcao(ler.nextByte());
        } while(status);
    }

}

