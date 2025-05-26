import java.util.Scanner;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Board board = new Board(2, 3);
        Robot robot = null;
        SmartRobot smartRobot = null;

        int menu = 1;
        while (menu == 1) {
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
            board.updateBoard(robot);
            board.printVisualBoard();

            int mover1 = rand.nextInt(3); 
            int mover2 = rand.nextInt(3);

            robot.moveRobot(mover1+1); 
            smartRobot.moveRobot(mover2+1); 


            
        }
        scanner.close();
    
    }
}
/*
    Main3 : Crie uma classe Main que instancie um robô normal e outro inteligente, peça ao usuário para entrar com a 
            posição do alimento, e faça os dois robôs se moverem randomicamente, um de cada vez, até que ambos encontrem
            o alimento. Ao final, mostre o número de movimentos que cada robô fez para encontrar o alimento.
*/