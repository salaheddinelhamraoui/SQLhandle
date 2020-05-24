package lnterface;

import models.KeywordStyledDocument;
import models.HiliteWord;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Panel_editeur_de_texte extends JPanel {
	
	   private  JPanel p= new  JPanel(), p1 = new JPanel(), p2 = new JPanel();
		
		private  JButton Effacer= new JButton("<Html><strong style=color:white >Effacer</strong></html>");
		private  JButton Execute= new JButton("<Html><strong style=color:white >Execute</strong></html>");
		  
	    private static final long serialVersionUID = 1L;
		private StyleContext styleContext = new StyleContext();
		private Style defaultStyle = styleContext.getStyle(StyleContext.DEFAULT_STYLE);
		private Style cwStyle = styleContext.addStyle("ConstantWidth", null);
		private  JTextPane pane = new JTextPane(new KeywordStyledDocument(defaultStyle, cwStyle));



		public  JPanel get_creation_panel(boolean x) {
			
            
            
            StyleConstants.setForeground(cwStyle, Color.BLUE);
            StyleConstants.setBold(cwStyle, true);

            
            pane.setFont(new Font("Courier New", Font.PLAIN, 16));

            JScrollPane scrollPane = new JScrollPane(pane);
            p.setLayout(new BorderLayout());
            p.add(scrollPane,BorderLayout.CENTER);
			
			
			Effacer.setBackground(Color.BLACK);
			Execute.setBackground(Color.BLUE);
			p2.setLayout(new FlowLayout());
			p2.add(Effacer);
			p2.add(Execute);
			p.add(p2,BorderLayout.SOUTH);
			
			
			
			
			
			
			
			
			return p;
		}












		public void setExecute(JButton execute) {
			Execute = execute;
		}






		public JButton getEffacer() {
			return Effacer;
		}






		public JButton getExecute() {
			return Execute;
		}

		public JTextPane getPane() {
			return pane;
		}












		public void setPane(JTextPane pane) {
			this.pane = pane;
		}
		
		
}
