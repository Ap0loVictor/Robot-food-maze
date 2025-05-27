public abstract class Obstacle {
    private static int nextId = 1;      
    private final int id; 
    protected int eixoX;
    protected int eixoY;
    public Obstacle(int eixoX, int eixoY){
        this.id = nextId;
        nextId++;
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }
    public abstract void bater(Robot robot);
    public int getId() {
        return id;
    }
}
