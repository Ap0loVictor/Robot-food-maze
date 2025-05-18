public class Robot {
    protected int positionX;
    protected int positionY;
    protected String color;

    public Robot(int positionX, int positionY, String color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.color = color;
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

    public void getPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void getPositionY(int positionX) {
        this.positionY = positionX;
    }

    public void setcolor(String color) {
        this.color = color;
    }
}