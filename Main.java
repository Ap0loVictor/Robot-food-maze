import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(2, 3);
        Robot robot = board.tabuleiroVisual[0][0].get(0);  // pegar o robô que já está no tabuleiro

        while (true) {
            board.printVisualBoard();

            System.out.print("Digite o comando para mover o robô (up, down, left, right) ou 'sair' para encerrar: ");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Jogo encerrado.");
                break;
            }

            // Move o robô conforme comando
            robot.moveRobot(comando);

            // Corrige posição caso ultrapasse limites
            board.moveRobotWithLimits(robot);

            // Atualiza o tabuleiro visual para refletir a nova posição
            board.updateBoard(robot);

        }
        scanner.close();
    }

}
/*
    Main1 : Crie uma classe Main que instancie um robô, peça ao usuário para determinar a posição do alimento, 
            e peça ao usuário para ficar movendo o robô até ele encontrar o alimento – não esqueça de tratar a exceção.
*/