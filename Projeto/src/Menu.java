import java.sql.SQLOutput;
import java.util.Scanner;

public class Menu {
    private Scanner ler = new Scanner(System.in);
    public void MostrarMenu(){
        System.out.println("\n\n1- Mostrar conexões de cada creche"
        + "\n2- Informar a distância entre 2 creches"
        + "\n3- Incluir novas conexões entre creches"
        + "\n4- Cadastrar nova Creche"
        + "\n5- Sair"
        + "\n Digite aqui: ");
    }

    public boolean escolherOpcao(byte op){
        String origem;
        String destino;
        Double distancia;
        switch (op){
            case 1:
                GrafoCreches.numeroConexoes();
                return true;

            case 2:
                System.out.println("Digite a origem: ");
                origem = ler.next();
                System.out.println("Digite o Destino: ");
                destino =  ler.next();
                GrafoCreches.distanciaEntre(origem, destino);
                return true;

            case 3:
                System.out.println("Digite a origem da nova conexão: ");
                origem = ler.next();
                System.out.println("Digite o destino da nova conexão: ");
                destino = ler.next();
                System.out.println("Digite a distância: ");
                distancia = ler.nextDouble();
                GrafoCreches.adicionarConexao(origem,destino,distancia);
                return true;

            case 4:
                System.out.println("Digite o nome da nova creche que deseja cadastrar: ");
                origem = ler.next();
                GrafoCreches.adicionarCreche(origem);
                return true;

            case 5:
                System.out.println("Programa encerrado com sucesso!!");
                return false;

            default:
                System.out.println("Digite uma opção válida");
                return true;
        }
    }
}
