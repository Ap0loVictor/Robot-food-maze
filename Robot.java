import java.util.Scanner;
public class Robot {
    protected int[] position;
    protected String color;
    Scanner sc = new Scanner(System.in);

    public Robot(String color) {
        position = new int[2];
        this.color = color;
    }

    public void moveRobot(String sc){
        int positionX = position[0];
        int positionY = position[1];
        sc = sc.toLowerCase();

        switch(sc)
        {
            case "up":
                positionY--;
                break;
            case "down":
                positionY++;
                break;
            case "left":
                positionX--;
                break;
            case "right":
                positionX++;
                break;
            default:
                System.out.println("Comando inválido!");
                return; 
        }
        this.position[0] = positionX;
        this.position[1] = positionY;
        }
        public void moveRobot(int move){
        int positionX = position[0];
        int positionY = position[1];
        switch(move)
        {
            case 1:
                positionY--;
                break;
            case 2:
                positionY++;
                break;
            case 3:
                positionX--;
                break;
            case 4:
                positionX++;
                break;
            default:
                System.out.println("Comando inválido!");
                return; 
        }
        this.position[0] = positionX;
        this.position[1] = positionY;
        }
    
    public String getColor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }
}
