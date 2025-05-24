import java.util.List;
// import java.util.Scanner;
import java.util.ArrayList;

// import java.util.Arrays;
public class Board 
{
    // private int width = 4, height = 4;
    // private ArrayList<Obstacle> obstacles;
    // private Robot[] robots;
    private int foodX;
    private int foodY;
    public List<Robot>[][] tabuleiroVisual;

    public Board(int foodX, int foodY) 
    {
        this.foodX = foodX;
        this.foodY = foodY;
        this.tabuleiroVisual = new ArrayList[4][4];

        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 4; j++) {
                this.tabuleiroVisual[i][j] = new ArrayList<>();
            }
        }
    }

    public void printVisualBoard() {
        System.out.println("\n==========================");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i == foodY)&& (j == foodX)){

                        System.out.print("[" + 5 + "]\t"); 
                    }
                    else if (!tabuleiroVisual[i][j].isEmpty()) {    
                        System.out.print("[");
                        for (Robot r : tabuleiroVisual[i][j]) {
                            System.out.print(r.getColor() + ""); 
                        }
                        System.out.print("]\t");
                    } else {
                    System.out.print("[ VAZIO ]\t");
                } 
                }
                System.out.println();
            }
        
        System.out.println("=================================");
    }

    public void moveRobotWithLimits(Robot r) {
        int newX = r.position[0];
        int newY = r.position[1];
        

    if (newX < 0) {
        newX = 0;
        System.out.println("Você esbarrou na parede esquerda!");
    } else if (newX > 3) {
        newX = 3;
        System.out.println("Você esbarrou na parede direita!");
    }

    if (newY < 0) {
        newY = 0;
        System.out.println("Você esbarrou na parede superior!");
    } else if (newY > 3) {
        newY = 3;
        System.out.println("Você esbarrou na parede inferior!");
    }
    }
    public void updateBoard(Robot robot){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tabuleiroVisual[i][j].remove(robot);
            }
        }

        // Adiciona o robô na nova posição
        int x = robot.position[0];
        int y = robot.position[1];
        tabuleiroVisual[y][x].add(robot);
    }
    public boolean foundFood(Robot r){
        return r.position[0] == foodX && r.position[1] == foodY ;
    }
    public int getFoodX() {
        return foodX;
    }
    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }
    public int getFoodY() {
        return foodY;
    }
    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }
}