public class Robot {
    protected int positionX;
    protected int positionY;
    protected String color;

    public Robot(String color) {
        this.positionX = 0;
        this.positionY = 0;
        this.color = color;
    }

    public void moveRobot(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public String getColor() {
        return color;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionX) {
        this.positionY = positionX;
    }

    public void setcolor(String color) {
        this.color = color;
    }
}