package lnterface;

import java.awt.Color;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login {
	private static JPanel frame;
	private static JPasswordField F_Password ;
	private static JTextField F_UserName = new JTextField();
	private static JLabel Jerror_message,lblNewLabel,lblNewLabel_1 ;
	private static JButton ValideButton = new JButton("VALIDE");
	private static JFrame f = new JFrame();
	private static JLabel lblNewLabel_2;
	private static JTextField l_port;
	


	/**
	 * @wbp.parser.entryPoint
	 */
	public static JFrame getLogin() {
		frame = new JPanel();
		frame.setBounds(100, 100, 696, 443);
		frame.setLayout(null);
		lblNewLabel = new JLabel("Port");
		lblNewLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		lblNewLabel.setBounds(159, 163, 139, 31);
		frame.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("MOTE DE PASSE");
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(159, 232, 104, 19);
		frame.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("UTILISATEUR");
		lblNewLabel_3.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(159, 201, 121, 16);
		frame.add(lblNewLabel_3);
		
		
		F_UserName.setBounds(275, 198, 151, 22);
		frame.add(F_UserName);
		F_UserName.setColumns(10);
		ValideButton.setBounds(300,290, 97, 25);ValideButton.setBackground(new Color(179, 217, 255));
		frame.add(ValideButton);
		Jerror_message = new JLabel("",SwingConstants.CENTER);
		Jerror_message.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		Jerror_message.setForeground(Color.RED);
		Jerror_message.setBounds(169, 264, 276, 16);
		frame.add(Jerror_message);
		F_Password = new JPasswordField();
		F_Password.setBounds(275, 230, 151, 22);
		frame.add(F_Password);
		
		f.getContentPane().add(frame);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("icons/logo.png"));
		lblNewLabel_2.setBounds(140, 0, 412, 204);
		frame.add(lblNewLabel_2);
		
		l_port = new JTextField();
		l_port.setColumns(10);
		l_port.setBounds(275, 169, 151, 22);
		frame.add(l_port);
		
 
		f.setBounds(100, 100, 696, 443);
		f.setLocationRelativeTo(null);  
		f.setTitle("SQL handle");
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		return f  ;
	}

	public static JPasswordField getF_Password() {
		return F_Password;
	}

	public static JTextField getF_UserName() {
		return F_UserName;
	}

	public static JLabel getJerror_message() {
		return Jerror_message;
	}



	public static JButton getValideButton() {
		return ValideButton;
	}

	public static void setF_Password(JPasswordField f_Password) {
		F_Password = f_Password;
	}

	public static void setF_UserName(JTextField f_UserName) {
		F_UserName = f_UserName;
	}

	public static void setJerror_message(JLabel jerror_message) {
		Jerror_message = jerror_message;
	}


	public static void setValideButton(JButton valideButton) {
		ValideButton = valideButton;
	}
	public static JTextField getL_port() {
		return l_port;
	}

	public static void setL_port(JTextField l_port) {
		Login.l_port = l_port;
	}


}
