package lnterface;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Pnael_down_right_top {
	 private static CloseableTabbedPane tab= new CloseableTabbedPane();
	 private static JPanel  p= new JPanel();
	
	 public static  JPanel getPanel_down_right_top(JPanel Pa, String name) {
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



	static void setP(JPanel p) {
		Pnael_down_right_top.p = p;
	}
	@SuppressWarnings("unused")//_____________________________________________________________________________________/
	private static void removeTabWithTitle(String tabTitleToRemove) {
	    for (int i = 0; i < tab.getTabCount(); i++) {
	        String tabTitle = tab.getTitleAt(i);
	        if (tabTitle.equals(tabTitleToRemove)) {
	            tab.remove(i);
	            break;
	        }
	    }
	}
	 

}
