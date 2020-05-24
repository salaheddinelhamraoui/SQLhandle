package lnterface;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class Panel_down_right {
	private static JSplitPane sp;
	private static JPanel p,panel_down_right_Bottom,panel_down_right_top,pann;
	public static JPanel right() {
		p= new JPanel();sp=new JSplitPane(JSplitPane.VERTICAL_SPLIT);pann=new JPanel();sp.setBackground(Color.BLACK);
		panel_down_right_Bottom= Panel_down_right_Bottom.getPanel_down_right_top();panel_down_right_top=Pnael_down_right_top.getPanel_down_right_top(pann, "tab1");
		panel_down_right_Bottom.setBackground(Color.white);
		panel_down_right_top.setBackground(Color.white);
		p.setLayout(new BorderLayout());
		p.setBorder(BorderFactory.createLineBorder(new Color(217, 217, 217),2));
		sp.setDividerLocation(400);sp.setBackground(Color.WHITE);
		p.add(sp,BorderLayout.CENTER);
		sp.setTopComponent(panel_down_right_top);
		sp.setBottomComponent(panel_down_right_Bottom);
		sp.setDividerSize(5);
		return p;
	}

}
