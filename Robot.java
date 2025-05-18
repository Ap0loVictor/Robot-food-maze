public class Robot {
    protected int[] position;
    protected String color;

    public Robot(String color) {
        position = new int[2];
        this.color = color;
    }

    public void moveRobot(int positionX, int positionY){
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