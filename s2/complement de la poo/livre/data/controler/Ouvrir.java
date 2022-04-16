package data.controler;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractAction;

import data.model.Livre;
import data.model.Paragraph;
import data.view.PanneauText;

public class Ouvrir extends AbstractAction{

  protected PanneauText fiche;

  public Ouvrir(String texte, PanneauText pt){
  	super(texte);
    this.fiche=pt;
  }
  public void actionPerformed(ActionEvent e) {
	  String texte = this.fiche.getZoneTexte().getText();//zoneTexte.GetterText();
	    String question = this.fiche.getZoneQuestion().getText();
    try {
      File f = new File("livre_test.txt");
      BufferedReader br = new BufferedReader(new FileReader(f));
      String line;
      Livre lv = new Livre();
      String st ="";
      String sq ="";
      Paragraph.reset();
      while ((line = br.readLine()) != null) {
        if (line.contains("[text]")){
          while ((line = br.readLine()) != "[/text]"){
                                      System.out.println(line);
            st = line;
          }
        }
        if (line.contains("[question]")){
          while ((line = br.readLine()) != "[/question]"){
                                      System.out.println(line);
            sq = line;
          }
        }
        if (line.contains("<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>")){
          lv.ajoutP(new Paragraph(st,sq,false,false, 1));
        }
      //  found = text.contains(word);
      }
      br.close();
      this.fiche.setLivre(lv);
      this.fiche.rewrite(0);
    }
    catch (IOException er) {}
  }

}
