package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import models.Database;

public class Panel_down {
	private static  JPanel panel_down;
	private static JSplitPane sp;
	
	
	public static JPanel getDownPanel(Vector<Database> databases) {
		panel_down=new JPanel();sp=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		panel_down.setLayout(new BorderLayout());
		sp.setDividerLocation(200);sp.setBackground(Color.WHITE);
		panel_down.add(sp,BorderLayout.CENTER);
		sp.setLeftComponent(Panel_down_left.left(databases));
		sp.setRightComponent(Panel_down_right.right());
		sp.setDividerSize(5);
		return panel_down;
	}
}
