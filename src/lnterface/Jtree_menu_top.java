package lnterface;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Jtree_menu_top {
	private static JToolBar toolBar;
	private static JButton btn_delete= new JButton(new ImageIcon("icons/Delete.png"));
	private static JButton btn_refresh= new JButton(new ImageIcon("icons/refresh.png"));
	
	
	public static JToolBar get_menu() {
		toolBar = new JToolBar();
        toolBar.setFloatable(false);
        btn_delete.setBackground(Color.WHITE);
        btn_refresh.setBackground(Color.white);
        
        btn_delete.setToolTipText( "supprimer une base de donnee ou un tableau" );
        
        toolBar.add( btn_delete );
        toolBar.add( btn_refresh );toolBar.addSeparator();
        toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();toolBar.addSeparator();
        toolBar.setBackground(Color.WHITE);
		
		return toolBar;
		
	}

	static JButton getBtn_delete() {
		return btn_delete;
	}



	static void setBtn_delete(JButton btn_delete) {
		Jtree_menu_top.btn_delete = btn_delete;
	}

	static JButton getBtn_refresh() {
		return btn_refresh;
	}

	static void setBtn_refresh(JButton btn_refresh) {
		Jtree_menu_top.btn_refresh = btn_refresh;
	}


	

}
