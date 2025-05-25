import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(2, 3);
        Robot robot = null;

        int menu = 1;
        while (menu == 1) {
            System.out.println("Escreva uma cor para o robô e comece a jogar!");
            String comando = scanner.nextLine();
            robot = new Robot(comando);
            menu = 2;
        }
        while (menu == 2) {
            board.updateBoard(robot);
            board.printVisualBoard();

            System.out.print("Digite o comando para mover o robô (1/up, 2/down, 3/left, 4/right) ou 'sair' para encerrar: ");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Jogo encerrado.");
                break;
            }

            if (comando.matches("[1-4]")) {
                int movimento = Integer.parseInt(comando);
                robot.moveRobot(movimento); 
            } 
            else {
                robot.moveRobot(comando); 
            }

            board.moveRobotWithLimits(robot);

        }
        scanner.close();
    }

}
/*
    Main1 : Crie uma classe Main que instancie um robô, peça ao usuário para determinar a posição do alimento, 
            e peça ao usuário para ficar movendo o robô até ele encontrar o alimento – não esqueça de tratar a exceção.
*/