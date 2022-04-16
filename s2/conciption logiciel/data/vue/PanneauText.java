package data.vue;

import java.awt.Graphics;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import data.model.Paragraph;
import data.model.Livre;

public class PanneauText extends JPanel {

  private JTextArea zoneTexte=new JTextArea();
  private JTextArea zoneQuestion=new JTextArea();
  private JLabel lab= new JLabel();
  private Livre liv;
  private int current;
  //private Paragraph para;

  public PanneauText(Livre l){
    this.current=0;
    //Paragraph associé
    this.liv=l;
    //modifiable=true
    zoneTexte.setLineWrap(true);
    //texte de base
    lab.setText("Paragraphe "+this.liv.getListe().get(0).GetterId());
    zoneTexte.setText(this.liv.getListe().get(0).GetterText());
    zoneQuestion.setText(this.liv.getListe().get(0).GetterQuestion());
    //position
    this.setLayout(new BorderLayout());
    this.add(lab,BorderLayout.NORTH);
    this.add(zoneTexte,BorderLayout.CENTER);
    this.add(zoneQuestion,BorderLayout.SOUTH);

    //this.setBackground(Color.ORANGE);
  }

  public JTextArea getZoneTexte(){
    return this.zoneTexte;
  }
  public JTextArea getZoneQuestion(){
    return this.zoneQuestion;
  }
  public Livre getLivre(){
    return this.liv;
  }
  public int getCurrent(){
    return this.current;
  }
  public JLabel getLab(){
    return this.lab;
  }

  public void setLivre(Livre l){
    this.liv=l;
  }

  public void rewrite(int i){
    this.current=i;
    zoneTexte.setText(this.liv.getListe().get(i).GetterText());
    zoneQuestion.setText(this.liv.getListe().get(i).GetterQuestion());
  }
}
