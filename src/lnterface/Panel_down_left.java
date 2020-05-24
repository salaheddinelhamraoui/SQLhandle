package lnterface;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import models.Database;

public class Panel_down_left {
	
	private static JPanel p;
	static JScrollPane tree;
	public static JPanel left(Vector<Database> databases) {
		tree=Jtree.getTree(databases);
		p= new JPanel();
		p.setBorder(BorderFactory.createEmptyBorder(5,8,2,1));
		
		p.setLayout(new BorderLayout());
		p.add(Jtree_menu_top.get_menu(),BorderLayout.NORTH);
		p.add(tree,BorderLayout.CENTER);
	
		
		return p;
	}
	
	public static void traitment() {
		
		
		
		
	}
	public static void Reload_jtree_panel() {
		p.revalidate();
		p.repaint();
		
	}
}
