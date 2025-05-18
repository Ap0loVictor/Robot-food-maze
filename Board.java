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
    private List<Robot>[][] tabuleiroVisual;

    public Board(int foodX, int foodY) 
    {
        this.foodX = foodX;
        this.foodY = foodY;
        ArrayList<String>[][] tabuleiroVisual = new ArrayList[4][4];
        for (int i = 0; i < 4; i++) 
        {
            for (int j = 0; j < 4; j++) {
                tabuleiroVisual[i][j] = new ArrayList<>();
            }
        }

    }

    public void printVisualBoard() {
        System.out.println("\n==========================");
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((i == foodY)&& (j == foodX)){
                        System.out.print(".[Comida]\t"); 
                    }
                    else{
                    System.out.print(".[" + tabuleiroVisual[i][j].size() + "]\t");} 
                }
                System.out.println();
            }
        
        System.out.println("=================================");
    }

    public void updateBoard(List<Robot>[][]  tabuleiroVisual){

    }
    
}

