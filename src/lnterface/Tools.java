package lnterface;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
public class Tools {
	
	public static  void makeFrameFullSize(JFrame aFrame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    aFrame.setSize(screenSize.width+10, screenSize.height-20);
	    aFrame.setLocation(screenSize.width/2-aFrame.getSize().width/2, screenSize.height/2-aFrame.getSize().height/2);
	}

}
