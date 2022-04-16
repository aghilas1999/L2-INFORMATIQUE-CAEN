package firstgames;Player

 public class Nim{

     private int tailleI;
     private int maxAl;
     public Player j1;
     public Player j2;
     private int tailleC;
     public Player playerC;


     public Nim (int tailleI,int maxAl,Player j1,Player j2,int tailleC){
       this.tailleI=tailleI;
       this.maxAl=max;
       this.j1=j1;
       this.j2=j2;
       this.tailleC=tailleC;
     }

     public int getInitialNbMatches (){

       return this.tailleI;
     }

     public int getCurrentNbMatches (){

        return this.tailleC;
     }

     public Player getCurrentPlayer(){
       return this.playerC;
     }

      public String situationToString (){
          return "(" +this.tailleC + "," + this.playerC + ")";
      }
      public void removeMatches (int nbAl){
        nbAl= this.tailleI-this.tailleC;
        if{  this.tailleC = j1;
             j1=j2;
          }
          else{
            j2=j1;
          }

      }

 }
