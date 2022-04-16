package data.model;

import java.util.ArrayList;
import java.util.List;

public class Livre{

  protected List<Paragraph> listeP = new ArrayList<>();

  public Livre (){}

  public Livre(int j){
    this.fakeBook(j);
  }

  public List<Paragraph> getListe(){
    return this.listeP;
  }

  public void ajoutP(Paragraph p){
    this.listeP.add(p);
  }

  public void fakeBook(int j){
    for (int i=0; i<j ; i++){
      this.listeP.add(new Paragraph());
    }
  }

}
