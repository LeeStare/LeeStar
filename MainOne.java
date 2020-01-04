package system;

import java.awt.EventQueue;
import manage.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainOne extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainOne frame2 = new MainOne();
					frame2.setVisible(true);
					frame2.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainOne() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 695, 407);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(194,175,143));
		panel.setBounds(0, 0, 692, 374);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//匯入
//		try
//		{
//			Image img = ImageIO.read(getClass().getResource("resources/water.bmp"));
//			button.setIcon(new ImageIcon(img));
//		} catch (Exception ex) {
//			System.out.println(ex);
//		}
		ImageIcon imageForOne = new ImageIcon("C:\\program_test\\Hotel_System\\image\\1.png");
		//, imageForOne
		Image image = imageForOne.getImage();
		Image smallImage = image.getScaledInstance(251,144,Image.SCALE_FAST);
		ImageIcon smallIcon = new ImageIcon(smallImage);
		JButton cusbutton = new JButton("<html>Customer<br>Manage</html>" ,smallIcon);
		cusbutton.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		cusbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cus cusForm = new Cus();
				cusForm.setVisible(true);
				cusForm.pack();
				cusForm.setLocationRelativeTo(null);
				cusForm.setBounds(100, 100, 900, 600);
				cusForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		cusbutton.setBounds(82, 29, 251, 144);
		panel.add(cusbutton);
		
		ImageIcon imageForTwo = new ImageIcon("C:\\program_test\\Hotel_System\\image\\2.png");
		//, imageForOne
		Image image2 = imageForTwo.getImage();
		Image smallImage2 = image2.getScaledInstance(251, 144, Image.SCALE_FAST);
		ImageIcon smallIcon2 = new ImageIcon(smallImage2);
		JButton roombtn = new JButton("<html>Room Manage</html>" ,smallIcon2);
		roombtn.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		roombtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Room roomForm = new Room();
				roomForm.setVisible(true);
				roomForm.pack();
				roomForm.setLocationRelativeTo(null);
				roomForm.setBounds(100, 100, 900, 600);
				roomForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		roombtn.setBounds(82, 188, 251, 144);
		panel.add(roombtn);
		
		ImageIcon imageForThree = new ImageIcon("C:\\program_test\\Hotel_System\\image\\3.png");
		
		Image image3 = imageForThree.getImage();
		Image smallImage3 = image3.getScaledInstance(251, 144, Image.SCALE_FAST);
		ImageIcon smallIcon3 = new ImageIcon(smallImage3);
		JButton resbtn = new JButton("<html>Reservetation</html>" ,smallIcon3);
		resbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reservetation resForm = new Reservetation();
				resForm.setVisible(true);
				resForm.pack();
				resForm.setLocationRelativeTo(null);
				resForm.setBounds(100, 100, 900, 600);
				resForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		resbtn.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		resbtn.setBounds(347, 29, 251, 144);
		panel.add(resbtn);
		
		
		ImageIcon imageForFour = new ImageIcon("C:\\program_test\\Hotel_System\\image\\5.png");
		//, imageForOne
		Image image4 = imageForFour.getImage();
		Image smallImage4 = image4.getScaledInstance(251,144,Image.SCALE_FAST);
		ImageIcon smallIcon4 = new ImageIcon(smallImage4);
		JButton btnNewButton = new JButton("<html>New button</html>" ,smallIcon4);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BillManage billForm = new BillManage();
				billForm.setVisible(true);
				billForm.pack();
				billForm.setLocationRelativeTo(null);
				billForm.setBounds(100, 100, 900, 600);
				billForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 25));
		btnNewButton.setBounds(347, 188, 251, 144);
		panel.add(btnNewButton);
	}
}
