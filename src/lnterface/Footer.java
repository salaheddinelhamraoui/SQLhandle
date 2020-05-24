package lnterface;

import java.awt.Color;

import javax.swing.JToolBar;

public class Footer {
	private static JToolBar footer= new JToolBar();
	
	public static JToolBar getFooter() {
		footer.addSeparator();
		footer.setFloatable(false);
		footer.setBackground(new Color(168, 168, 168));
		
		
		return footer;
	}

}
