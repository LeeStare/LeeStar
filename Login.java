package system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

//�n�J����
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterUsername;
	private JPasswordField passwordField_Userpassword;

	/**
	 * Launch the application.
	 */
	//�D����
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	//�����]�m
	public Login() {
		
		//�~��
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//��F�誺�ĤG�ج[(���O�i�ܪŶ�)
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(65, 105, 225));
		panel_1.setBounds(0, 0, 700, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		//���D����
		JLabel lblNewLabel = new JLabel("USER LOGIN");
		lblNewLabel.setBounds(247, 0, 200, 55);
		lblNewLabel.setLabelFor(contentPane);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("�L�n������", Font.BOLD, 33));
		panel_1.add(lblNewLabel);
		
		//��F�誺�ĤT�ج[
		JPanel panel = new JPanel();
		panel.setBackground(new Color(17, 79, 95));
		panel.setBounds(0, 51, 700, 350);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//User Name����
		JLabel lblUserName = new JLabel("User Name : ");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setFont(new Font("�L�n������ Light", Font.PLAIN, 25));
		lblUserName.setBounds(54, 95, 195, 30);
		panel.add(lblUserName);
		
		//Password����
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("�L�n������ Light", Font.PLAIN, 25));
		lblPassword.setBounds(54, 138, 195, 30);
		panel.add(lblPassword);
		
		//Username��J��
		txtEnterUsername = new JTextField();
		txtEnterUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtEnterUsername.setFont(new Font("�L�n������", Font.PLAIN, 15));
		txtEnterUsername.setText("Enter username");
		txtEnterUsername.setBounds(248, 95, 321, 30);
		panel.add(txtEnterUsername);
		txtEnterUsername.setColumns(10);
		
		
		//Login���s
		JButton Login_Button = new JButton("Login");
		Login_Button.setBackground(new Color(202,233,255));
		Login_Button.setFont(new Font("�L�n������", Font.PLAIN, 25));
		Login_Button.setBounds(119, 200, 450, 50);
		Login_Button.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0)
					{
						PreparedStatement ps;
						ResultSet rs;
						
						String username = txtEnterUsername.getText();
						String password = String.valueOf(passwordField_Userpassword.getPassword());
						
						//���b �S��Jusername
						if(username.trim().equals(""))
						{
							JOptionPane.showMessageDialog(rootPane, "Enter Username to login", "Empty Username", 2);
						}
						//���b �S��Jpassword
						else if(password.trim().equals(""))
						{
							JOptionPane.showMessageDialog(rootPane, "Enter Password to login", "Empty Password", 2);
						}
						else
						{
							//�T�{��Ʈw�����b���K�X
							MysqlConnection myconnection = new MysqlConnection();
							String selectQuery = "SELECT * FROM login WHERE username = ? AND password = ?";
							try
							{
								ps = myconnection.createConnection().prepareStatement(selectQuery);
								ps.setString(1, username);
								ps.setString(2, password);
								
								rs = ps.executeQuery();
								
								if(rs.next())
								{
									MainOne mainone = new MainOne();
									mainone.setVisible(true);
									mainone.setLocationRelativeTo(null);
									mainone.pack();
									
									mainone.setBounds(100, 100, 700, 405);
									
									this.dispose();
								}
								else
								{
									JOptionPane.showMessageDialog(rootPane, "Wrong UserName Or Password to login", "Login Error", 2);
								}
							}
							catch (SQLException e) {
								// TODO �۰ʲ��ͪ� catch �϶�
								e.printStackTrace();
							}
						}
					}

					private void dispose()
					{
						setVisible(false);
					}
				});
		panel.add(Login_Button);
		
		//��Enter��n�J
		passwordField_Userpassword = new JPasswordField();
		passwordField_Userpassword.addKeyListener(new KeyAdapter()
		{
			private void dispose()
			{
				setVisible(false);
			}
			@Override
			public void keyTyped(KeyEvent e)
			{
				int key = e.getKeyChar();
			    if (key == '\n')
			    {
			    	System.out.println("ENTER pressed");
			    	PreparedStatement ps;
					ResultSet rs;
					
					String username = txtEnterUsername.getText();
					String password = String.valueOf(passwordField_Userpassword.getPassword());
					
					if(username.trim().equals(""))
					{
						JOptionPane.showMessageDialog(rootPane, "Enter Username to login", "Empty Username", 2);
					}
					else if(password.trim().equals(""))
					{
						JOptionPane.showMessageDialog(rootPane, "Enter Password to login", "Empty Password", 2);
					}
					else
					{
						MysqlConnection myconnection = new MysqlConnection();
						String selectQuery = "SELECT * FROM login WHERE username = ? AND password = ?";
						try
						{
							ps = myconnection.createConnection().prepareStatement(selectQuery);
							ps.setString(1, username);
							ps.setString(2, password);
							
							rs = ps.executeQuery();
							
							if(rs.next())
							{
								MainOne mainone = new MainOne();
								mainone.setVisible(true);
								mainone.setLocationRelativeTo(null);
								mainone.pack();
								
								mainone.setBounds(100, 100, 700, 405);
								
								this.dispose();
							}
							else
							{
								JOptionPane.showMessageDialog(rootPane, "Wrong UserName Or Password to login", "Login Error", 2);
							}
						}
						catch (SQLException ex)
						{
							// TODO �۰ʲ��ͪ� catch �϶�
							ex.printStackTrace();
						}
					}
					
			    }
			}
		});
		passwordField_Userpassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_Userpassword.setEchoChar('��');
		passwordField_Userpassword.setToolTipText("");
		passwordField_Userpassword.setBounds(248, 138, 321, 30);
		panel.add(passwordField_Userpassword);
	}
	
	
	
}
