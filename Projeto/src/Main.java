import java.util.Scanner;

public class Main {
      public static void main(String[] args) {
        Menu menu = new Menu();
        new GrafoCreches();
        Scanner ler = new Scanner(System.in);
        Byte op = 0;
        boolean status = true;
        do {
            menu.MostrarMenu();
            op = ler.nextByte();
            status = menu.escolherOpcao(op);
        }while(status);

    }
}
