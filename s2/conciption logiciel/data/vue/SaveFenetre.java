package data.vue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;

public class SaveFenetre extends JFrame {

  private JPanel pan= new JPanel();
  private JLabel label = new JLabel();

  public SaveFenetre(){
    pan.setLayout(new BorderLayout());
    this.setTitle("fenetre de sauvegarde");
    this.setSize(400,250);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(this);
    this.setVisible(true);
  }
}
