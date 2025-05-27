public class Rocha extends Obstacle{
    public Rocha(int eixoX, int eixoY){
    
    super(eixoX, eixoY);
}
    @Override
    public void bater(Robot robot){
        System.out.println("O Robô " + robot.getColor() + " Colidiu em uma rocha!");
        robot.setPosition(robot.getPreviousPosition());
    }
}