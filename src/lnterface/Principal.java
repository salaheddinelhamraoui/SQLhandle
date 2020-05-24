package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.GridLayout;

import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import models.Database;



public class Principal  {
	private static JPanel panel_menu_top,panel_container,panel_down;
	private static JMenuBar menu_top= Menu_top.MenuExample();
	private static JFrame f = new JFrame();

	public static JFrame getPrincipal(Vector<Database> databases) {
		panel_container= new JPanel();
		panel_menu_top=new JPanel();
		panel_down= new JPanel();
		panel_container.setBorder(BorderFactory.createLineBorder(new Color(209, 209, 209),4));
		panel_down.setBackground(new Color(209, 209, 209));
		panel_container.setLayout(new BorderLayout());
		panel_container.add(panel_menu_top,BorderLayout.NORTH);panel_container.add(Panel_down.getDownPanel(databases),BorderLayout.CENTER);
		panel_menu_top.setLayout(new GridLayout(2,0));
		panel_menu_top.add(menu_top);menu_top.setBackground(Color.white );
		panel_menu_top.add(ToolBar.createToolBar());
		panel_container.add(Footer.getFooter(),BorderLayout.SOUTH);
		f.add(panel_container);
		Tools.makeFrameFullSize(f);
		f.setTitle("SQL handle");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		return f;
	}

	
	
	}
	
	
	
	
	
	


