import java.util.Scanner;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Random;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Board board = null;
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
            scanner.nextLine();
            System.out.println("Ecolha a posição do eixo Y da comida: ");
            int eixoYComida = scanner.nextInt();
            scanner.nextLine();
            board = new Board(eixoXComida-1, eixoYComida-1);

            robot = new Robot(comando1);
            smartRobot = new SmartRobot(comando2);
            
            menu = 2;
        }
        while (menu == 2) {
            board.updateBoard(robot);
            board.updateBoard(smartRobot);
            board.printVisualBoard();

            int mover1 = rand.nextInt(4); 
            
            robot.moveRobot(mover1 + 1); 
            smartRobot.moveSmartRobot(); 
            board.updateBoard(robot);
            board.updateBoard(smartRobot);
            if(board.foundFood(robot)){
                board.printVisualBoard();
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
                JOptionPane.showMessageDialog(frame, "O Robô " + robot.getColor() + " Encontrou a comida! Fim de Jogo!", "Vitória!", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
                JOptionPane.showMessageDialog(frame, "Número de movimentos do Robô " + robot.getColor() + " : " + robot.getGeralMoves() + 
                    "\nNúmero de movimentos do Robô " + smartRobot.getColor() + " : " + smartRobot.getGeralMoves(),
                    "Movimentos",
                    JOptionPane.INFORMATION_MESSAGE, resizedIcon2
                );
                System.exit(0);
                break;
            } 
            if (board.foundFood(smartRobot)) {
                board.printVisualBoard();
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
                JOptionPane.showMessageDialog(frame, "O Robô " + smartRobot.getColor() + " Encontrou a comida! Fim de Jogo!", "Vitória!", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
                JOptionPane.showMessageDialog(frame, "Número de movimentos do Robô " + robot.getColor() + " : " + robot.getGeralMoves() + 
                    "\nNúmero de movimentos do Robô " + smartRobot.getColor() + " : " + smartRobot.getGeralMoves(),
                    "Movimentos",
                    JOptionPane.INFORMATION_MESSAGE, resizedIcon2
                );
                System.exit(0);
                break;
            }
        }
        scanner.close();
    
    }
}
/*
    Main3 : Crie uma classe Main que instancie um robô normal e outro inteligente, peça ao usuário para entrar com a 
            posição do alimento, e faça os dois robôs se moverem randomicamente, um de cada vez, até que ambos encontrem
            o alimento. Ao final, mostre o número de movimentos que cada robô fez para encontrar o alimento.
*/