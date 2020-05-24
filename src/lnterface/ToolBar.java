package lnterface;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBar  {
	private static JToolBar toolBar;
	private static JButton btnNew= new JButton( new ImageIcon( "icons/ide.png") );

	    /* Méthode de construction de la barre d'outils */
	    static JToolBar createToolBar() {

	        // La barre d'outils à proprement parler
	        toolBar = new JToolBar();
	        toolBar.setFloatable(false);
	        toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();
	        toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();
	        btnNew.setBackground(Color.white);
	        btnNew.setToolTipText( "editeur de texte" );
	         
	        toolBar.add( btnNew );
	        toolBar.addSeparator();
 
	        toolBar.addSeparator();

	

	        return toolBar;
	    }

		static JButton getBtnNew() {
			return btnNew;
		}

		static void setBtnNew(JButton btnNew) {
			ToolBar.btnNew = btnNew;
		}
		
		
		
		

}
