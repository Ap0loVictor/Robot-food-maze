import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Board {
    private int foodX;
    private int foodY;
    private int rodada;
    private List<Robot>[][] tabuleiroVisual; 
    private List<Rocha> rochas;
    private List<Bomba> bombas;
    
    // Construtor sem obstáculos
    public Board(int foodX, int foodY) {
        if (foodX < 0 || foodX >= 4 || foodY < 0 || foodY >= 4) {
            throw new IllegalArgumentException("Posição da comida está fora dos limites do tabuleiro (4x4).");
        }
        this.foodX = foodX;
        this.foodY = foodY;
        this.rochas = new ArrayList<>();
        this.bombas = new ArrayList<>();
        this.tabuleiroVisual = new ArrayList[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.tabuleiroVisual[i][j] = new ArrayList<>();
            }
        }
    }

    // Construtor com obstáculos
    public Board(int foodX, int foodY, List<Obstacle> obstacles) {
        if (foodX < 0 || foodX >= 4 || foodY < 0 || foodY >= 4) {
            throw new IllegalArgumentException("Posição da comida está fora dos limites do tabuleiro (4x4).");
        }
        this.foodX = foodX;
        this.foodY = foodY;
        this.rochas = new ArrayList<>();
        this.bombas = new ArrayList<>();
        this.tabuleiroVisual = new ArrayList[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.tabuleiroVisual[i][j] = new ArrayList<>();
            }
        }
        
        for (Obstacle o : obstacles) {
            if (o instanceof Rocha) {
                this.rochas.add((Rocha) o);
            } else if (o instanceof Bomba) {
                this.bombas.add((Bomba) o);
            }
        }
    }


    public void printVisualBoard() {
        rodada++;
        System.out.println(rodada + "ª Rodada");
        System.out.println("\n============================================================");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if ((i == foodY) && (j == foodX)) {
                    System.out.print("[   FOOD  ]\t"); 
                } else if (foundBomb(j, i)) {
                    System.out.print("[   BOMB  ]\t");
                } else if (foundObstacle(j, i)) {
                    System.out.print("[   ROCK  ]\t");
                } else if (!tabuleiroVisual[i][j].isEmpty()) {    
                    System.out.print("[  ");
                    for (Robot r : tabuleiroVisual[i][j]) {
                        System.out.print(r.getColor() + " "); 
                    }
                    System.out.print(" ]\t");
                } else {
                    System.out.print("[         ]\t");
                } 
            }
            System.out.println();
        }
        System.out.println("============================================================");
    }

    public void updateBoard(Robot robot) {
    try {
        // Remove o robô de todas as células, vivo ou morto
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                tabuleiroVisual[i][j].remove(robot);
            }
        }

        // Adiciona o robô na posição atual, vivo ou morto
        int[] pos = robot.getPosition();
        int x = pos[0];
        int y = pos[1];

        tabuleiroVisual[y][x].add(robot);

    } catch (ArrayIndexOutOfBoundsException error) {
        robot.incrementInvalidMovement();
    }
}

    public boolean foundFood(Robot r) {
        
        if (r.position[0] == foodX && r.position[1] == foodY) {
            foodX = -1;
            foodY = -1;
            return true; 
        } 
        return false;
    }

    private boolean foundBomb(int x, int y) {
        Iterator<Bomba> it = bombas.iterator();
        while (it.hasNext()) {
        Bomba b = it.next();
        if (!b.actived) {
            it.remove();
            continue;
        }
            int[] pos = b.getPosition();
            if (pos[0] == x && pos[1] == y) {
                return true;
            }
        }
        return false;
    }

    private boolean foundObstacle(int x, int y) {
        for (Rocha r : rochas) {
            int[] pos = r.getPosition();
            if (pos[0] == x && pos[1] == y) {
                return true;
            }
        }
        return false;
    }

    // Getters e Setters
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
