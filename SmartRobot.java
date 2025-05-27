import java.util.Random;
public class SmartRobot extends Robot{
    private int lastInvalidMove;
    private Random random;    
    public SmartRobot(String color){
        super(color);
        this.lastInvalidMove = 0;
        this.random = new Random();
    }
    public boolean moveRobot(int move) {
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
            int attempts = 0;
            lastInvalidMove = move;
            while (attempts < 16) {
                int newMove = random.nextInt(4) + 1;
                if(newMove == lastInvalidMove){
                    attempts++;
                    continue;
                }
                int newPositionX = position[0];
                int newPositionY = position[1];
                switch(newMove)
                {
                    case 1:
                        newPositionY--;
                        break;
                    case 2:
                        newPositionY++;
                        break;
                    case 3:
                        newPositionX--;
                        break;
                    case 4:
                        newPositionX++;
                        break;
                    default:
                        return false; 
                }
                if (newPositionX < 0 || newPositionX > 3 || newPositionY < 0 || newPositionY > 3){
                    incrementInvalidMovement();
                    lastInvalidMove = newMove;
                } else {
                    validMoves++;
                    position[0] = newPositionX;
                    position[1] = newPositionY;
                    return true;
                }                
                attempts++;
            }
            return false;
        } else {
            validMoves++;
            position[0] = positionX;
            position[1] = positionY;
            return true;
        }
             
    }

}
