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
    private int rodada;
    private List<Robot>[][] tabuleiroVisual; 
    private List<Rocha> rochas;
    private List<Bomba> bombas;
    
    public Board(int foodX, int foodY) 
    {
        if (foodX < 0 || foodX >= 4 || foodY < 0 || foodY >= 4) {
        throw new IllegalArgumentException("Posição da comida está fora dos limites do tabuleiro (4x4).");
    }
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

    public Board(int foodX, int foodY, List<Rocha> rochas, List<Bomba> bombas) 
    {
        if (foodX < 0 || foodX >= 4 || foodY < 0 || foodY >= 4) {
        throw new IllegalArgumentException("Posição da comida está fora dos limites do tabuleiro (4x4).");
    }
        this.foodX = foodX;
        this.foodY = foodY;
        this.rochas = rochas;
        this.bombas = bombas;
        this.tabuleiroVisual = new ArrayList[4][4];

        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 4; j++) {
                this.tabuleiroVisual[i][j] = new ArrayList<>();
            }
        }
    }

    
    public void printVisualBoard() {
        rodada++;
        System.out.println( rodada + "º Rodada");
        System.out.println("\n============================================================");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i == foodY)&& (j == foodX)){

                        System.out.print("[   " + "FOOD" + "  ]\t"); 
                    } else if (foundBomb(j,i)){
                        System.out.print("[   " + "BOMB" + "  ]\t");
                    } else if (foundObstacle(j,i)){
                        System.out.println("[   " + "ROCK" + "  ]\t");
                    } else if (!tabuleiroVisual[i][j].isEmpty()) {    
                        System.out.print("[  ");
                        for (Robot r : tabuleiroVisual[i][j]) {
                            System.out.print(r.getColor() + " "); 
                        }
                        System.out.print("  ]\t");
                    } else {
                    System.out.print("[         ]\t");
                } 
                }
                System.out.println();
            }
        
        System.out.println("=============================================================");
    }

    public void updateBoard(Robot robot){
        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    tabuleiroVisual[i][j].remove(robot);
                }
            }

        // Adiciona o robô na nova posição
            int[] pos = robot.getPosition();
            int x = pos[0];
            int y = pos[1];
            tabuleiroVisual[y][x].add(robot);   
            } catch (ArrayIndexOutOfBoundsException error) {
                robot.incrementInvalidMovement();
            }
    }
    public boolean foundFood(Robot r){
        if (r.position[0] == foodX && r.position[1] == foodY){
            foodX = -1;
            foodY = -1;
            return true; 
        } return false;
    }
   public boolean foundBomb(int x, int y){
        if (bombas == null){
        return false;
        } else {
        for (Bomba b : bombas){
            if (b.eixoX == x && b.eixoY == y) {
                return true;
            }
        }
        return false;
        }
    } 
    public boolean foundObstacle(int x, int y) {
        if(rochas == null){
            return false;
        }   
        for (Rocha r : rochas) {
        if (r.eixoX == x && r.eixoY == y) {
            return true;
        }
    }
    return false;
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
    public List<Robot>[][] getTabuleiroVisual() {
        return tabuleiroVisual;
    }
    public void setTabuleiroVisual(List<Robot>[][] tabuleiroVisual) {
        this.tabuleiroVisual = tabuleiroVisual;
    }
}