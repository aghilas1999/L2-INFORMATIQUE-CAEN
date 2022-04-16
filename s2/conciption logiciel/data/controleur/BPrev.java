package data.controleur;

import data.vue.PanneauText;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BPrev extends JButton implements ActionListener {

  protected PanneauText panT;

	public BPrev (PanneauText p) {
    this.panT = p;
  	this.addActionListener(this);
  	this.setText("<==");
  }

  public void actionPerformed(ActionEvent e) {
    this.panT.getLivre().getListe().get(this.panT.getCurrent()).save(
    this.panT.getZoneTexte().getText(),this.panT.getZoneQuestion().getText());

    if (this.panT.getCurrent() != 0){
  		this.panT.rewrite(this.panT.getCurrent()-1);
    }else{
      this.panT.rewrite(this.panT.getLivre().getListe().size()-1);
    }
    this.panT.getLab().setText("Paragraphe "+this.panT.getLivre().getListe().get(this.panT.getCurrent()).GetterId());
	}
}
