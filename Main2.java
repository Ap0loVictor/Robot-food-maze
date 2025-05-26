import java.util.Scanner;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        Board board = new Board(2, 3);
        Robot robot1 = null;
        Robot robot2 = null;

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

            robot1 = new Robot(comando1);
            robot2 = new Robot(comando2);
            
            menu = 2;
        }
        while (menu == 2) {
            board.updateBoard(robot1);
            board.printVisualBoard();

            int mover1 = rand.nextInt(3); 
            int mover2 = rand.nextInt(3);

            robot1.moveRobot(mover1+1); 
            robot2.moveRobot(mover2+1); 

            board.moveRobotWithLimits(robot1);

        }
        scanner.close();
    
    }
}
/*
    Main2 : Crie outra classe Main que instancie dois robôs, peça ao usuário para entrar com a posição do alimento,
            e faça os dois robôs se moverem randomicamente, um de cada vez, até que um deles encontre o alimento. 
            Ao final, mostre quem achou o alimento e o número de movimentos válidos e inválidos de cada robô.
*/