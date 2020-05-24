package lnterface;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Panel_down_right_Bottom {
	
	 private static CloseableTabbedPane tab= new CloseableTabbedPane();
	 private static JPanel  p= new JPanel();
	
	 public static  JPanel getPanel_down_right_top() {
		 p.setLayout(new BorderLayout()); 
		 p.add(tab,BorderLayout.CENTER);
		 return p;
	 }

	static JTabbedPane getTab() {
		return tab;
	}

	static JPanel getP() {
		return p;
	}


}
