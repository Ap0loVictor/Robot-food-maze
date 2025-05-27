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
        isInvalid = true;
        while (isInvalid) {
            move = random.nextInt(4) + 1;
            if(move == lastInvalidMove){
                continue;
            }
            if(moveRobot(move)){
                lastInvalidMove = 0;
                isInvalid = false;
                break;
            } else {
                lastInvalidMove = move;
            }
        }       
    }

}
