public class Robot {
    protected int[] position;
    protected String color;
    protected int invalidMovement;
    protected int validMoves;
    protected int geralMoves;

    public Robot(String color) {
        position = new int[2];
        this.color = color;
    }

    public boolean moveRobot(String sc){
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
                return false; 
        }
        if (positionX < 0 || positionX > 3 || positionY < 0 || positionY > 3) {
            incrementInvalidMovement();
            return false; // Movimento inválido, não atualiza posição
        }
        this.position[0] = positionX;
        this.position[1] = positionY;
        validMoves++;
        return true;
    }
    public boolean moveRobot(int move){
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
                return false; 
        }
        if (positionX < 0 || positionX > 3 || positionY < 0 || positionY > 3) {
            incrementInvalidMovement();
            return false; // Movimento inválido, não atualiza posição
        }
        this.position[0] = positionX;
        this.position[1] = positionY;
        validMoves++;
        return true;
    }
    
    public String getColor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    public int[] getPosition() {
        return position;
    }
    public void setInvalidMovement(int invalidMovement) {
        this.invalidMovement = invalidMovement;
    }
    public int getInvalidMovement() {
        return invalidMovement;
    }
    public void incrementInvalidMovement(){
        
        this.invalidMovement++;
    }
    public void setValidMoves(int validMoves) {
        this.validMoves = validMoves;
    }
    public int getValidMoves() {
        return validMoves;
    }
    public void setGeralMoves(int geralMoves) {
        this.geralMoves = geralMoves;
    }
    public int getGeralMoves() {
        return getInvalidMovement() + getValidMoves();
    }
}
