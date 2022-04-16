package data.controleur;

import data.vue.SaveFenetre;

import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSave extends JButton implements ActionListener {

	public ButtonSave () {
		this.addActionListener(this);
		this.setText("Bouton avec action");
	}

  public void actionPerformed(ActionEvent e) {
		SaveFenetre buttsave = new SaveFenetre();
	}
}
