package data.vue;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import data.controleur.ButtonSave;
import data.controleur.BNext;
import data.controleur.BPrev;
import data.vue.PanneauText;


public class PanButton extends JPanel{

  public PanButton(PanneauText pan1){
    ButtonSave button1 = new ButtonSave();
    BPrev button2 = new BPrev(pan1);
    BNext button3 = new BNext(pan1);

    this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    this.add(button1);
    this.add(button2);
    this.add(button3);
  }

}
