package infection;

public class Pacquet{
  private State c;
  private double b;

  public Pacquet(State s, double b){
    this.c=s;
    this.b=b;
  }
  
  public State getStateC(){return this.c;}
  public double getDoubleB(){return this.b;}
}
