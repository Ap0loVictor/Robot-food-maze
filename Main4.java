import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Board board = null;
        Robot robot = null;
        SmartRobot smartRobot = null;
        List<Rocha> rochas = new ArrayList<>();
        List<Bomba> bombas = new ArrayList<>();

        int menu = 1;
        while (menu == 1) {
            System.out.println("============================================================");
            System.out.println("Escreva uma cor para o robô 1:");
            String comando1 = scanner.nextLine();
            System.out.println("Escreva uma cor para o robô inteligente:");
            String comando2 = scanner.nextLine();

            System.out.println("Ecolha a posição do eixo X da comida: ");
            int eixoXComida = scanner.nextInt();
            System.out.println("Ecolha a posição do eixo Y da comida: ");
            int eixoYComida = scanner.nextInt();

            board = new Board(eixoXComida-1, eixoYComida-1);

            robot = new Robot(comando1);
            smartRobot = new SmartRobot(comando2);
            
            menu = 2;
        }
        while (menu == 2) {

            System.out.println("============================================================");
            System.out.println("    Adição de obstáculos: ");
            System.out.println("1 - Adicionar bombas.\n2 - Adicionar rochas.\n3 - Finalizar adição de obstáculos");
            int escolha = scanner.nextInt();
            if (escolha == 3) {
                menu = 3;
                break;
            }
            System.out.print("Posição X: ");
            int positionX = scanner.nextInt();
            System.out.print("Posição Y: ");
            int positionY = scanner.nextInt();

            if(escolha == 1){
                bombas.add(new Bomba(positionX, positionY));
            }
            else if(escolha == 2){
                rochas.add(new Rocha(positionX, positionY));
            }
            else{
                System.out.println("Escreva um dos números indicados");
            }
            
            
        }
        while (menu == 3) {
            board.updateBoard(robot);
            board.printVisualBoard();

            int mover1 = rand.nextInt(4); 
            int mover2 = rand.nextInt(4);

            robot.moveRobot(mover1+1); 
            smartRobot.moveRobot(mover2+1); 

    

        }
        scanner.close();
    
    }
}
/*
    Main4 : Crie uma classe Main que instancie um robô normal e outro inteligente, peça ao usuário para entrar com a 
            posição do alimento e inserir algumas bombas e rochas no tabuleiro, e faça os dois robôs se moverem 
            randomicamente, um de cada vez, até que um deles encontre o alimento ou ambos explodam.
            Ao final, mostre o número de movimentos que cada robô fez para encontrar o alimento ou até explodir.
*/