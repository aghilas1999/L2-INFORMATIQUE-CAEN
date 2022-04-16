package infection;

import java.util.*;

public class Main{
  public static void main(String[] args){

    State s = new State(5,5);
    Ia ia = new Ia();


    /*System.out.println(s.possibleCase(4,3));
    System.out.println(s.possibleCase(-5,2));
    System.out.println(s.possibleCase(0,0));*/
    //System.out.println(s.isFinished());
    /*while(!s.isFinished()){
      p=s.currentplayer;
      l=s.getMove(p);
      n=random(l);
      s=s.play(n);
    }*/
    while(!s.isFinished()){
      System.out.println(s.getCurrentPlayer()+" vient de jouer\n");
      //String p=s.currentPlayer;
      ArrayList<Move> l=s.getMove();
      int n = (int)(Math.random() * l.size());
      s=s.play(l.get(n));
      s.affiche();
      //ss.getscore();
      //System.out.println("score de "+s.getCurrentPlayer()+" : "+s.getScoreB());
      if (ia.minMax(s,2).getStateC()!=null){
        ia.minMax(s,2).getStateC().affiche();
      }

      System.out.println("score de B : "+s.getScoreB());
      System.out.println("score de N : "+s.getScoreN()+"\n");
      System.out.println("======================================\n");
      //Thread.sleep(1000);
    }
  }
}
