package infection;

public class Ia{
  public static int ffff=0;

  public Ia(){}

    //##############################################

  public Pacquet minMax(State s,double profondeur){
    this.ffff++;
    //System.out.println(this.ffff);
    if (profondeur==0 || s.isFinished()){
      return new Pacquet(s,s.getScore("N"/*s.getCurrentPlayer()*/));//rajouter currentPlayer
    }
    else{
    //System.out.println(profondeur);
      //if (s.getCurrentPlayer()=="N"){
        double valeurM = Double.NEGATIVE_INFINITY;
         //sTest = null;
        State SBest = null;
        for (int i=0; i<s.getMove().size(); i++){
          //if (ffff<50){
            State sTest = s.play(s.getMove().get(i));
            sTest.createMove();
            //System.out.println("test:\nValeurM: "+valeurM+"\nProfondeur: "+profondeur+"\nnbExecutin: "+ffff);
            //s.affiche();

            Pacquet v = this.minMax(sTest,profondeur-1);
            //System.out.println("yup2 "+ valeurM);
            if (v.getDoubleB() >= valeurM){
              valeurM = v.getDoubleB();
              SBest = s.play(s.getMove().get(i));
            }
          //}
        }
      return new Pacquet(SBest,SBest.getScore("N"/*SBest.getCurrentPlayer()*/));
    //  }
    //return new Pacquet(null,Double.NEGATIVE_INFINITY);
    }
  }

}
