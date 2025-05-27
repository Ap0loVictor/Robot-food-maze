public abstract class Obstacle {
    protected int id;
    protected int[] position;
    public Obstacle(int eixoX, int eixoY){
       this.position = new int[2];
    
    }
    public abstract void bater(Robot robot);
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
}
