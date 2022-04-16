package infection;

import java.util.*;

public class Main{
  public static void main(String[] args){

    State s = new State(5,5);
    Ia ia = new Ia();

    while(!s.isFinished()){
      System.out.println("\nTour de "+s.getCurrentPlayer()+":\n");
      ArrayList<Move> l=s.getMove();
      int n = (int)(Math.random() * l.size());
      //int n = 1;
      //if (s.getCurrentPlayer()=="N"){n = (int)(ia.minMax(s,4).getDoubleB());}
      //else{n = (int)(Math.random() * l.size());}

      s=s.play(l.get(n));
      s.affiche();
      //if (ia.minMax(s,2).getStateC()!=null){
        //ia.minMax(s,2).getStateC().affiche();
      //}

      System.out.println("score de B : "+s.getScore("B"));
      System.out.println("score de N : "+s.getScore("N")+"\n");
      System.out.println("======================================\n");
    }
  }
}
