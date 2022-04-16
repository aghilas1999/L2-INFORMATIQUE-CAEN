package data;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import data.view.Ia;

public class Main{
  public static void main(String[] args) throws Exception{
	UIManager.setLookAndFeel(new NimbusLookAndFeel());
	Ia u = new Ia();

  }

}
