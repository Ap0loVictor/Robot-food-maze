import java.util.Scanner;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = null;
        Robot robot = null;

        int menu = 1;
        while (menu == 1) {
            System.out.println("Escreva uma cor para o robô:");
            String comando = scanner.nextLine();

            boolean posicaoValida = false;
            while(!posicaoValida){
            System.out.println("Ecolha a posição do eixo X da comida: ");
            int eixoXComida = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ecolha a posição do eixo Y da comida: ");
            int eixoYComida = scanner.nextInt();
            scanner.nextLine();
            try {
            board = new Board(eixoXComida-1, eixoYComida-1);
            posicaoValida = true;
            } catch (IllegalArgumentException e) {
                 System.out.println("Erro: " + e.getMessage() + " Tente novamente.");
            }
            }    
            robot = new Robot(comando);
            menu = 2;
}
        while (menu == 2) {
            board.updateBoard(robot);
            board.printVisualBoard();

            System.out.print("Mover o robô: (1/up, 2/down, 3/left, 4/right) ou 'sair' para encerrar: ");
            String comando = scanner.nextLine();

            if (comando.equalsIgnoreCase("sair")) {
                System.out.println("Jogo encerrado.");
                break;
            }

            if (comando.matches("[1-4]")) {
                int movimento = Integer.parseInt(comando);
                if (!robot.moveRobot(movimento)) {
                    JFrame frame = new JFrame();
                    ImageIcon icon = new ImageIcon("C://Users//guilh//Downloads//Parede.jpg");
                    Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(image);
                    frame.setAlwaysOnTop(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(false);
                    frame.setUndecorated(true);
                    frame.setType(JFrame.Type.UTILITY);
                    JOptionPane.showMessageDialog(frame, "Movimento inválido! Esbarrou em uma parede!", "AVISO!", JOptionPane.WARNING_MESSAGE, resizedIcon);
                } 
            } 
            else {
                if(!robot.moveRobot(comando)) {
                    JFrame frame = new JFrame();
                    ImageIcon icon = new ImageIcon("C://Users//guilh//Downloads//Parede.jpg");
                    Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                    ImageIcon resizedIcon = new ImageIcon(image);
                    frame.setAlwaysOnTop(true);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(false);
                    frame.setUndecorated(true);
                    frame.setType(JFrame.Type.UTILITY);
                    JOptionPane.showMessageDialog(frame, "Movimento inválido! Esbarrou em uma parede!", "AVISO!", JOptionPane.WARNING_MESSAGE, resizedIcon);
                } 
            }
            board.updateBoard(robot);
            if(board.foundFood(robot)){
                board.printVisualBoard();
                ImageIcon icon = new ImageIcon("C:/Users/guilh/Downloads/trofeu.png");
                Image image = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(image);
                JFrame frame = new JFrame();
                frame.setAlwaysOnTop(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(false);
                frame.setUndecorated(true);
                frame.setType(JFrame.Type.UTILITY);
                JOptionPane.showMessageDialog(frame, "Comida encontrada! Fim de Jogo!", "Vitória!", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
                System.exit(0);
                break;
            }
        }
        scanner.close();
    }
}
/*
    Main1 : Crie uma classe Main que instancie um robô, peça ao usuário para determinar a posição do alimento, 
            e peça ao usuário para ficar movendo o robô até ele encontrar o alimento – não esqueça de tratar a exceção.
*/