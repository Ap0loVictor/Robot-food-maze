import java.util.Scanner;
import java.util.Random;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Board board = new Board(2, 3);
        Robot robot = null;
        SmartRobot smartRobot = null;

        int menu = 1;
        while (menu == 1) {
            System.out.println("============================================================");
            System.out.println("Escreva uma cor para o robô 1:");
            String comando1 = scanner.nextLine();
            System.out.println("Escreva uma cor para o robô 2:");
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
            System.out.println("Adição de obstáculos: ");
            System.out.println("Quantas bombas deseja inserir?");
            int numBombas = scanner.nextInt();
            System.out.println("Quantas rochas deseja inserir?");
            int numRochas = scanner.nextInt();
            for(int i=0; i<numBombas; i++){
                // N vou fazer agora.
                // Decidir depois se vai ser feito pedindo X e depois Y ou de uma forma mais decente
            }
            for(int i=0; i<numRochas; i++){
                // N vou fazer agora.
                // Decidir depois se vai ser feito pedindo X e depois Y ou de uma forma mais decente
            }
        }
        while (menu == 3) {
            board.updateBoard(robot);
            board.printVisualBoard();

            int mover1 = rand.nextInt(3); 
            int mover2 = rand.nextInt(3);

            robot.moveRobot(mover1+1); 
            smartRobot.moveRobot(mover2+1); 

            board.moveRobotWithLimits(smartRobot);

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