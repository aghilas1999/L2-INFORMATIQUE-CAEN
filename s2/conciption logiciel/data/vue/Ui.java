package data.vue;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTree;
//////
import data.model.Paragraph;
import data.model.Livre;
//////
import data.controleur.Add;

    //import data.model.graphique.GraphEditor;
    //  import data.model.graphique.*;
    //  import java.awt.Point;

public class Ui extends JFrame{

  Livre p = new Livre(3);
  PanneauText pan1 = new PanneauText(p);
  JPanel pan2 = new JPanel();
  PanButton pan3 = new PanButton(pan1);
  MenuEditeur men = new MenuEditeur(pan1);
  Unfault un = new Unfault(p);
  //JButton addP = new JButton(new Add("add"));
  /*  Graph gg =new Graph();
      GraphEditor g = new GraphEditor(gg);
      JPanel pan4 = new JPanel();*/


  public Ui(){


    //Graph.exemple();

    //pan4.add(g);
      //  pan4.setPreferredSize(new Dimension(300,300));

    //panel1
    pan2.add(new JScrollPane(new JTree(un)));
    pan2.setPreferredSize(new Dimension(140,300));

    this.setJMenuBar(men);

    //fenetre setting
    this.setTitle("Editeur de livres");
    this.setSize(830, 630);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setLayout(new BorderLayout());
    this.setVisible(true);

    //position panel
    this.getContentPane().add(new JScrollPane(pan1), BorderLayout.CENTER);
    this.getContentPane().add(pan2, BorderLayout.EAST);
    this.getContentPane().add(pan3, BorderLayout.SOUTH);
    //this.getContentPane().add(pan4, BorderLayout.WEST);
  }
}
