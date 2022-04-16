package code;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.Dimension; 
import javax.swing.UIManager;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;
public class MaFenetre extends JFrame {
	public MaFenetre(){
		super("MaFenetre");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(600,400);
		this.setLocationRelativeTo(null);
		JPanel contertpane = (JPanel)this.getContentPane();
		contertpane.setLayout(new FlowLayout());
		contertpane.add(new JButton("saha"));
		contertpane.add(new JButton("azul"));
		contertpane.add(new JCheckBox("chek me"));
		contertpane.add(new JTextField("edite me"));
	}	
	public static void main(String[] args) throws Exception{
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		MaFenetre maFenetre = new MaFenetre();
		maFenetre.setVisible(true);
	}
}