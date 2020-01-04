package manage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.SwingConstants;


public class Cus extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField nametextField;
	private JTextField phonetextField;
	private JTextField addtextField;
	private JTextField cardtextField;
	private static JTable table = new JTable();
	
	
	static CusC cusc = new CusC();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cus frame = new Cus();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}
	public Cus() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(238, 232, 170));
		panel.setBounds(0, 0, 882, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 882, 100);
		panel_1.setBackground(new Color(255, 165, 0));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCustomerManage = new JLabel("Customer manage");
		lblCustomerManage.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		lblCustomerManage.setForeground(new Color(255, 255, 255));
		lblCustomerManage.setBounds(14, 24, 393, 60);
		panel_1.add(lblCustomerManage);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblId.setBounds(63, 147, 88, 24);
		panel.add(lblId);
		
		idtextField = new JTextField();
		idtextField.setBounds(151, 148, 305, 25);
		panel.add(idtextField);
		idtextField.setColumns(10);
		
		nametextField = new JTextField();
		nametextField.setColumns(10);
		nametextField.setBounds(151, 185, 305, 25);
		panel.add(nametextField);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblName.setBounds(39, 184, 112, 24);
		panel.add(lblName);
		
		phonetextField = new JTextField();
		phonetextField.setColumns(10);
		phonetextField.setBounds(151, 230, 305, 25);
		panel.add(phonetextField);
		
		JLabel lblPhone = new JLabel("Phone : ");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblPhone.setBounds(39, 229, 112, 24);
		panel.add(lblPhone);
		
		addtextField = new JTextField();
		addtextField.setColumns(10);
		addtextField.setBounds(151, 275, 305, 25);
		panel.add(addtextField);
		
		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblAddress.setBounds(26, 274, 125, 24);
		panel.add(lblAddress);
		
		cardtextField = new JTextField();
		cardtextField.setColumns(10);
		cardtextField.setBounds(151, 323, 305, 25);
		panel.add(cardtextField);
		
		JLabel lblCreditCard = new JLabel("Credit Card : ");
		lblCreditCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCard.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblCreditCard.setBounds(0, 322, 151, 24);
		panel.add(lblCreditCard);
		
		/*String[] columns = {"ID", "name", "phone", "address", "credit card"};
		Object[][] action = {};
		DefaultTableModel dtm = new DefaultTableModel();
        Vector<String> vcolumn = new Vector<String>();
        Vector<Vector> vrow = new Vector<Vector>();
        Vector<Object> temp;

        //取得欄的Vector,這樣跑下去剛好取得一個禮拜的欄位
        for(String jumpcol : columns)
            vcolumn.add(jumpcol);

        //這個是取得列的Vector,之前是用二維陣列,現在改成Vector內存著Vector
        //意思類似這樣{{Vector},{Vector},....},Vector可以是任何的物件
        for(int i=0; i <action.length; i++)
        {
            temp = new Vector<Object>();
            for(int j=0; j<action[i].length; j++)
            {
                temp.add(action[i][j]);
            }
            vrow.add(temp);
        }

        dtm.setDataVector(vrow, vcolumn);*/
		
		
		table = new JTable();
		table.setRowHeight(30);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		table.setFocusTraversalKeysEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "name", "phone", "address", "credit card"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(2).setMinWidth(20);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setMinWidth(20);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setMinWidth(20);
		JScrollPane jscrollpane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int rIndex = table.getSelectedRow();
				
				idtextField.setText(model.getValueAt(rIndex, 0).toString());
				nametextField.setText(model.getValueAt(rIndex, 1).toString());
				phonetextField.setText(model.getValueAt(rIndex, 2).toString());
				addtextField.setText(model.getValueAt(rIndex, 3).toString());
				cardtextField.setText(model.getValueAt(rIndex, 4).toString());
			}
		});
		jscrollpane.setBounds(480, 147, 376, 331);
		panel.add(jscrollpane);
		cusc.fillCusJTable(table);
		JButton addbtn = new JButton("Add New Customer");
		addbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String name = nametextField.getText();
				String phone = phonetextField.getText();
				String address = addtextField.getText();
				String credit = cardtextField.getText();
				String id = idtextField.getText();
				
				if(name.trim().equals("") || phone.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Required Fields -> Name + The Phone Num ", "Add Customer Data", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					if(!id.equals(""))
					{
						if(cusc.addInCus(Integer.valueOf(id), name, phone, address, credit))
						{
							JOptionPane.showMessageDialog(rootPane, "New Customer Data Added Successfully", "Add Customer Data", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							
							JOptionPane.showMessageDialog(rootPane, "Customer ID Error", "Add Customer Data Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						if(cusc.addCus(name, phone, address, credit))
						{
							JOptionPane.showMessageDialog(rootPane, "New Customer Data Added Successfully", "Add Customer Data", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							
							JOptionPane.showMessageDialog(rootPane, "Customer Data didn't Add", "Add Customer Data Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		addbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addbtn.setBounds(26, 395, 217, 40);
		panel.add(addbtn);
		
		JButton editbtn = new JButton("Edit");
		editbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		editbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int id = 0;
				String name = nametextField.getText();
				String phone = phonetextField.getText();
				String address = addtextField.getText();
				String credit = cardtextField.getText();
				
				if(name.trim().equals("") || phone.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Required Fields -> Name + The Phone Num ", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					try
					{
						id = Integer.valueOf(idtextField.getText());
						if(cusc.editCus(id, name, phone, address, credit))
						{
							JOptionPane.showMessageDialog(rootPane, "Customer Data Updated Successfully", "Edit Customer Data", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							
							JOptionPane.showMessageDialog(rootPane, "Customer Data didn't Updated", "Edit Customer Data Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Customer ID(number)", "Customer ID Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
				
			}
		});
		editbtn.setBounds(248, 394, 90, 40);
		panel.add(editbtn);
		
		JButton removebtn = new JButton("Remove");
		removebtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		removebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					int id = Integer.valueOf(idtextField.getText());
					if(cusc.removeCus(id))
					{
						JOptionPane.showMessageDialog(rootPane, "Customer Deleted Successfully", "Remove Customer Data", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						
						JOptionPane.showMessageDialog(rootPane, "Customer Data didn't Deleted", "Remove Customer Data Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Customer ID(number)", "Customer ID Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		removebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removebtn.setBounds(340, 394, 116, 40);
		panel.add(removebtn);
		
		JButton clearbtn = new JButton("Clear Data");
		clearbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				idtextField.setText("");
				nametextField.setText("");
				phonetextField.setText("");
				addtextField.setText("");
				cardtextField.setText("");
			}
		});
		clearbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearbtn.setBounds(26, 438, 430, 40);
		panel.add(clearbtn);
		
		Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
		clearbtn.setBorder(border);
		
		JButton refbtn = new JButton("Refresh");
		refbtn.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		refbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				table.setFocusTraversalKeysEnabled(false);
				table.getTableHeader().setReorderingAllowed(false);
				table.setModel(new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ID", "name", "phone", "address", "credit card"
						}
					) {
						public boolean[] columnEditables = new boolean[] {
							false, false, false, false, false
						};
						public boolean isCellEditable(int row, int column) {
							return columnEditables[column];
						}
					});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setMinWidth(20);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(2).setMinWidth(20);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(3).setMinWidth(20);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(4).setMinWidth(20);
				cusc.fillCusJTable(table);
			}
		});
		refbtn.setBounds(757, 113, 99, 27);
		panel.add(refbtn);
		
		JButton button = new JButton("Reset");
		button.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					cusc.resetAI();
				} catch (SQLException e) {
					// TODO 自動產生的 catch 區塊
					e.printStackTrace();
				}
			}
		});
		button.setBounds(644, 113, 99, 27);
		panel.add(button);
	}
}
