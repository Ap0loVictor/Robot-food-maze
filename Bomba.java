public class Bomba extends Obstacle{
    public Bomba(int eixoX, int eixoY){
        super(eixoX, eixoY);
    }
    @Override
    public void bater(Robot robot){
        System.out.println("O robô bateu na bomba e morreu!!!");
        robot.setAlive(false);
    }

}
