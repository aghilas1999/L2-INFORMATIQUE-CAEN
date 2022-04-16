package data.model;
import java.util.Scanner;
//scanner ??
public class Paragraph{
    private int id;
    private String question;
    private String texte;
    private boolean toTheEnd;
    private boolean toYourEnd;
    private int prochainPara;
    private static int number = 0;


//constructeur
  public Paragraph(String txt,String question,boolean fin,boolean mort,int prochain){
    this.number +=1 ;
    this.id= this.number;
    this.question= question;
    this.texte=txt;
    this.toTheEnd=fin;
    this.toYourEnd=mort;
    this.prochainPara=prochain;
    QuestionList listeQuestion = new QuestionList();
  }
  public Paragraph(Paragraph p){
    this.number +=1 ;
    this.id= this.number;
    this.question=p.question;
    this.texte=p.texte;
    this.toTheEnd=p.toTheEnd;
    this.toYourEnd=p.toYourEnd;
    this.prochainPara=p.prochainPara;
    QuestionList listeQuestion = new QuestionList();
  }
  public Paragraph(){
    this.number +=1 ;
    this.id= this.number;
    this.question="Question";
    this.texte="Je suis le pingouin n°"+this.id;
    this.toTheEnd=false;
    this.toYourEnd=false;
    this.prochainPara=0;
    QuestionList listeQuestion = new QuestionList();
  }

  //getter ext
  public int GetterId(){
    return this.id;
  }
  public String GetterQuestion(){
    return this.question;
  }
  public String GetterText(){
    return this.texte;
  }
  public boolean GetterEnd(){
    return this.toTheEnd;
  }
  public boolean GetterDeath(){
    return this.toYourEnd;
  }
  public int GetterNextPara(){
    return this.prochainPara;
  }
  public static void reset(){
    number=0;
  }


  public void save(String st, String sq){
    this.texte=st;
    this.question=sq;
  }



}
