public abstract class Obstacle {
    protected int id;
    protected int eixoX;
    protected int eixoY;
    public Obstacle(int eixoX, int eixoY){
        this.eixoX = eixoX;
        this.eixoY = eixoY;
    }
    
    public abstract void bater(Robot robot);
}
