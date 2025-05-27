import java.util.Scanner;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
        List<Obstacle> obstacles = new ArrayList<>();
        int menu = 1;

        int eixoXComida = 0; 
        int eixoYComida = 0;

        while (menu == 1) {
            System.out.println("============================================================");
            System.out.println("Escreva uma cor para o robô 1:");
            String comando1 = scanner.nextLine();
            System.out.println("Escreva uma cor para o robô inteligente:");
            String comando2 = scanner.nextLine();

            boolean posicaoValida = false;
            while(!posicaoValida){
                System.out.println("Escolha a posição do eixo X da comida: ");
                eixoXComida = scanner.nextInt();
                System.out.println("Escolha a posição do eixo Y da comida: ");
                eixoYComida = scanner.nextInt();
                 try {
            board = new Board(eixoXComida-1, eixoYComida-1);
            posicaoValida = true;
            } catch (IllegalArgumentException e) {
                 System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
            }

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

            if (escolha == 1) {
                obstacles.add(new Bomba(positionX, positionY));
            } else if (escolha == 2) {
                obstacles.add(new Rocha(positionX, positionY));
            } else {
                System.out.println("Escreva um dos números indicados");
            }
        }

        try {
            board = new Board(eixoXComida - 1, eixoYComida - 1, obstacles);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar o tabuleiro: " + e.getMessage());
            System.exit(1);
        }

        while (menu == 3) {
            board.updateBoard(robot);
            board.updateBoard(smartRobot);
            board.printVisualBoard();

            robot.moveRobot(rand.nextInt(4) + 1); 
            smartRobot.moveRobot(rand.nextInt(4) + 1);              

            for (Obstacle obstacle : obstacles) {
                int[] posObstacle = obstacle.getPosition();
                int[] posRobo = robot.getPosition();
                int[] posSmartRobo = smartRobot.getPosition();

                if (posObstacle[0] == posRobo[0] && posObstacle[1] == posRobo[1]) {
                    obstacle.bater(robot);   
                }
                if (posObstacle[0] == posSmartRobo[0] && posObstacle[1] == posSmartRobo[1]) {
                    obstacle.bater(smartRobot);
                }
            }

            if (smartRobot.isAlive()) {
                smartRobot.moveRobot(rand.nextInt(4) + 1); 
                board.updateBoard(smartRobot);
            }
            if (robot.isAlive()) {
                robot.moveRobot(rand.nextInt(4) + 1); 
                board.updateBoard(robot);
            }

            if (board.foundFood(robot)) {
                board.printVisualBoard();
                exibirMensagens(robot, smartRobot);
                System.exit(0);
            }
            if (board.foundFood(smartRobot)) {
                board.printVisualBoard();
                exibirMensagens(smartRobot, robot);
                System.exit(0);
            }
        }
        scanner.close();
    }

    private static void exibirMensagens(Robot vencedor, Robot outro) {
        ImageIcon icon = new ImageIcon("C:/Users/guilh/Downloads/trofeu.png");
        ImageIcon icon2 = new ImageIcon("C:/Users/guilh/Downloads/Robo.jpg");
        Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        Image image2 = icon2.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(image);
        ImageIcon resizedIcon2 = new ImageIcon(image2);

        JFrame frame = new JFrame();
        frame.setAlwaysOnTop(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(false);
        frame.setUndecorated(true);
        frame.setType(JFrame.Type.UTILITY);

        JOptionPane.showMessageDialog(frame, "O Robô " + vencedor.getColor() + " Encontrou a comida! Fim de Jogo!", "Vitória!", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
        JOptionPane.showMessageDialog(frame, "Número de movimentos do Robô " + vencedor.getColor() + " : " + vencedor.getGeralMoves() + 
            "\nNúmero de movimentos do Robô " + outro.getColor() + " : " + outro.getGeralMoves(),
            "Movimentos",
            JOptionPane.INFORMATION_MESSAGE, resizedIcon2
        );
    }
}
