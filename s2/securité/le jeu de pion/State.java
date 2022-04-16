package infection;

import java.util.*;

public class State{

  private int boardX;
  private int boardY;
  private String[][] board;
  private String currentPlayer;
  private ArrayList<Move> mood = new ArrayList<Move>();

//constructeur
  public State(int x, int y){
    this.boardX=x;
    this.boardY=y;
    this.currentPlayer="B";
    this.board = new String[this.boardX][this.boardY];
    this.newBoard();
  }

  public State(State ss){
    this.boardX=ss.boardX;
    this.boardY=ss.boardY;
    if (ss.currentPlayer=="B"){this.currentPlayer="N";}
    else{this.currentPlayer="B";}
    this.board = ss.board;
  }

//Tableau tout neuf est dénué de guerre
  public void newBoard(){
    for (int i=0 ; i<this.boardX; i++ ) {
      for (int j=0 ; j<this.boardY; j++) {
        this.board[i][j]="0";
      }
    }
    this.board[0][0]="B";
    this.board[this.boardX-1][this.boardY-1]="N";
  }
//accesseur

public String getCurrentPlayer(){
  return this.currentPlayer;
}

//Méthode

  public boolean isFinished(){
    return this.getMove().isEmpty();
  }

  public boolean possibleCase(int x, int y){return x>=0 && x<this.boardX && y>=0 && y<this.boardY && this.board[x][y]=="0";}
  public boolean possibleClone(int x, int y){
    return x>=0 && x<this.boardX && y>=0 && y<this.boardY && this.board[x][y]!="0";
  }

  public ArrayList<Move> getMove(/*player p*/){
    for (int i=0 ; i<this.boardX; i++ ) {
      for (int j=0 ; j<this.boardY; j++) {
        if (this.board[i][j]==this.currentPlayer){
          if (this.possibleCase(i+1,j)){
            Move m = new Move(i,j,i+1,j,false);
            this.mood.add(m);
          }
          if (this.possibleCase(i-1,j)){    Move m = new Move(i,j,i-1,j,false);    this.mood.add(m);  }
          if (this.possibleCase(i,j+1)){    Move m = new Move(i,j,i,j+1,false);    this.mood.add(m);  }
          if (this.possibleCase(i,j-1)){    Move m = new Move(i,j,i,j-1,false);    this.mood.add(m);  }
          if (this.possibleCase(i+2,j)){    Move m = new Move(i,j,i+2,j,true);    this.mood.add(m);  }
          if (this.possibleCase(i-2,j)){    Move m = new Move(i,j,i-2,j,true);    this.mood.add(m);  }
          if (this.possibleCase(i,j+2)){    Move m = new Move(i,j,i,j+2,true);    this.mood.add(m);  }
          if (this.possibleCase(i,j-2)){    Move m = new Move(i,j,i,j-2,true);    this.mood.add(m);  }
        }
      }
    }
    return this.mood;
  }


 public State play(Move m){
   State ns=new State(this);
   if (m.getType()){
     ns.board[m.getStartX()][m.getStartY()] ="0";
     ns.board[m.getEndX()][m.getEndY()] = this.currentPlayer;
   }
   else{
     ns.board[m.getEndX()][m.getEndY()] = this.currentPlayer;
     if(ns.possibleClone(m.getEndX()+1,m.getEndY())){ns.board[m.getEndX()+1][m.getEndY()]=this.currentPlayer;}
     if(ns.possibleClone(m.getEndX()-1,m.getEndY())){ns.board[m.getEndX()-1][m.getEndY()]=this.currentPlayer;}
     if(ns.possibleClone(m.getEndX(),m.getEndY()+1)){ns.board[m.getEndX()][m.getEndY()+1]=this.currentPlayer;}
     if(ns.possibleClone(m.getEndX(),m.getEndY()-1)){ns.board[m.getEndX()][m.getEndY()-1]=this.currentPlayer;}
   }
   return ns;
 }

public float getScoreN(){
  float n = 0.0f;
  float b = 0.0f;
  for (int i=0 ; i<this.boardX; i++ ) {
    for (int j=0 ; j<this.boardY; j++) {
      if (this.board[i][j]=="N"){n+=1;}
      if (this.board[i][j]=="B"){b+=1;}
    }
  }
  return n/(n+b);
}

public float getScoreB(){
  float n = 0.0f;
  float b = 0.0f;
  for (int i=0 ; i<this.boardX; i++ ) {
    for (int j=0 ; j<this.boardY; j++) {
      if (this.board[i][j]=="N"){n+=1;}
      if (this.board[i][j]=="B"){b+=1;}
    }
  }
  return b/(n+b);
}


// Afficheur

public void affiche(){
  for (int i=0 ; i<this.boardX; i++ ) {
    for (int j=0 ; j<this.boardY; j++) {
        System.out.print(this.board[i][j]+" ");
      }
      System.out.println("");
    }
    System.out.println("");
  }




}
