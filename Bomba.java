public class Bomba extends Obstacle{
    protected boolean actived;
    public Bomba(int eixoX, int eixoY){
        super(eixoX, eixoY);
        this.actived = true;
    }
    @Override
    public void bater(Robot robot){
        System.out.println("O robô bateu na bomba e morreu!!!");
        robot.setAlive(false);
        this.actived = false;
    }
    public boolean isActived() {
        return actived;
    }
}