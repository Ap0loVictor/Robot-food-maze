import java.util.Random;
public class SmartRobot extends Robot{
    private int lastInvalidMove;
    private Random random;    
    public SmartRobot(String color){
        super(color);
        this.lastInvalidMove = 0;
        this.random = new Random();
    }
    public void moveSmartRobot() {
        for (int i = 0; i < 4; i++) {
            int move = random.nextInt(4) + 1;
            if(move == lastInvalidMove){
                continue;
            }
            if(moveRobot(move)){
                lastInvalidMove = 0;
                break;
            } else {
                lastInvalidMove = move;
            }
        }       
    }

}
