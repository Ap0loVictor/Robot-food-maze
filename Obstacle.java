public abstract class Obstacle {
    protected int[] position;
    private static int nextId = 1;      
    private final int id; 
    protected int eixoX;
    protected int eixoY;
    public Obstacle(int eixoX, int eixoY){
        this.position = new int[2];
        this.position[0] = eixoX;
        this.position[1] = eixoY;
        this.id = nextId;
        nextId++;
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }
    public abstract void bater(Robot robot);
    public int getId() {
        return id;
    }
    public int[] getPosition() {
        return this.position;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
}
