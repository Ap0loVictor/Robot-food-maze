import java.util.Scanner;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        Board board = null;
        Robot robot1 = null;
        Robot robot2 = null;
        int menu = 1;
        while (menu == 1) {
            System.out.println("Escreva uma cor para o robô 1:");
            String comando1 = scanner.nextLine();
            System.out.println("Escreva uma cor para o robô 2:");
            String comando2 = scanner.nextLine();

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
            robot1 = new Robot(comando1);
            robot2 = new Robot(comando2);
            
            menu = 2;
        }
        while (menu == 2) {
            board.updateBoard(robot1);
            board.updateBoard(robot2);
            board.printVisualBoard();

            int mover1 = rand.nextInt(4); 
            int mover2 = rand.nextInt(4);

            robot1.moveRobot(mover1+1); 
            robot2.moveRobot(mover2+1); 
            if(board.foundFood(robot1)){
                board.updateBoard(robot1);
                board.updateBoard(robot2);
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
                JOptionPane.showMessageDialog(frame, "O robô " + robot1.getColor() + " encontrou a comida! Fim de Jogo!", "Vitória!", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
                JOptionPane.showMessageDialog(frame, "Número de movimentos inválidos do Robô " + robot1.getColor() + " : " + robot1.getInvalidMovement() + 
                    "\nNúmero de movimentos válidos do Robô " + robot1.getColor() + " : " + robot1.getValidMoves() + "\nNúmero de movimentos inválidos do Robô " + robot2.getColor() + " : " + robot2.getInvalidMovement()
                    + "\nNúmero de movimentos válidos do Robô " + robot2.getColor() + " : " + robot2.getValidMoves(),
                    "Relatório de Movimentos",
                    JOptionPane.INFORMATION_MESSAGE, resizedIcon2
                );
                System.exit(0);
                break;
            }
            if(board.foundFood(robot2)){

                board.updateBoard(robot1);
                board.updateBoard(robot2);
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
                JOptionPane.showMessageDialog(frame, "O robô " + robot2.getColor() + " encontrou a comida! Fim de Jogo!", "Vitória!", JOptionPane.INFORMATION_MESSAGE, resizedIcon);
                
                
               JOptionPane.showMessageDialog(frame, "Número de movimentos inválidos do Robô " + robot1.getColor() + " : " + robot1.getInvalidMovement() + 
                    "\nNúmero de movimentos válidos do Robô " + robot1.getColor() + " : " + robot1.getValidMoves() + "\nNúmero de movimentos inválidos do Robô " + robot2.getColor() + " : " + robot2.getInvalidMovement()
                    + "\nNúmero de movimentos válidos do Robô " + robot2.getColor() + " : " + robot2.getValidMoves(),
                    "Relatório de Movimentos",
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
    Main2 : Crie outra classe Main que instancie dois robôs, peça ao usuário para entrar com a posição do alimento,
            e faça os dois robôs se moverem randomicamente, um de cada vez, até que um deles encontre o alimento. 
            Ao final, mostre quem achou o alimento e o número de movimentos válidos e inválidos de cada robô.
*/