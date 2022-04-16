package infection;

public class Ia{
  public static int ffff=0;

  public Ia(){}

    //##############################################

  public Pacquet minMax(State s,double d){
    this.ffff++;

    if (d==0 || s.isFinished()){
      return new Pacquet(s,s.getScoreB());//rajouter currentPlayer
    }
    else{
    System.out.println(d);
      //if (s.getCurrentPlayer()=="N"){
        double b = Double.NEGATIVE_INFINITY;
        State c = null;
        for (int i=0; i<s.getMove().size() ;i++){
          State sPrime = s.play(s.getMove().get(i));
          Pacquet v = this.minMax(sPrime,d-1);
          if (v.getDoubleB()>b){
            b=v.getDoubleB();
            c=s.play(s.getMove().get(i));
          }
        }
      return new Pacquet(c,b);
    //  }
    //return new Pacquet(null,Double.NEGATIVE_INFINITY);
    }
  }

}
