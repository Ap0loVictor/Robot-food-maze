public class Robot {
    protected int[] position;
    protected int[] previousPosition;
    protected String color;
    protected int invalidMovement;
    protected int validMoves;
    protected int geralMoves;
    protected boolean alive;
    public Robot(String color) {
        this.position = new int[2];
        this.previousPosition = new int[2];
        this.color = color;
        this.alive = true;
    }

    public boolean moveRobot(String sc){
        previousPosition[0] = position[0];
        previousPosition[1]= position[1];
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
        previousPosition[0] = position[0];
        previousPosition[1]= position[1];
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
    public int[] previewMove(int move) {
        int tx = position[0], ty = position[1];
        switch(move) {
            case 1: ty--; break; // up
            case 2: ty++; break; // down
            case 3: tx--; break; // left
            case 4: tx++; break; // right
        }
        return new int[]{ tx, ty };
    }

    public String getColor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }
    public void setPosition(int[] position) {
        previousPosition[0] = position[0];
        previousPosition[1] = position[1];
        this.position[0] = position[0];         
        this.position[1] = position[1];
    }
    public int[] getPosition() {
        return position;
    }
    public int[] getPreviousPosition() {
        return previousPosition;
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
    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}