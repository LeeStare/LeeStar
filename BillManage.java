package manage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BillManage extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField CIDtextField;
	private JTextField RoomNumtextField;
	private static JTable table = new JTable();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillManage frame = new BillManage();
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
	public BillManage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(176, 224, 230));
		panel.setBounds(0, 0, 882, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 882, 100);
		panel_1.setBackground(new Color(70, 130, 180));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCustomerManage = new JLabel("Check manage");
		lblCustomerManage.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		lblCustomerManage.setForeground(new Color(255, 255, 255));
		lblCustomerManage.setBounds(14, 24, 393, 60);
		panel_1.add(lblCustomerManage);
		
		JLabel lblId = new JLabel("ID : ");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblId.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblId.setBounds(95, 147, 53, 24);
		panel.add(lblId);
		
		idtextField = new JTextField();
		idtextField.setBounds(151, 148, 305, 25);
		panel.add(idtextField);
		idtextField.setColumns(10);
		
		CIDtextField = new JTextField();
		CIDtextField.setColumns(10);
		CIDtextField.setBounds(151, 185, 305, 25);
		panel.add(CIDtextField);
		
		JLabel lblCID = new JLabel("Customer ID : ");
		lblCID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCID.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblCID.setBounds(0, 184, 148, 24);
		panel.add(lblCID);
		
		RoomNumtextField = new JTextField();
		RoomNumtextField.setColumns(10);
		RoomNumtextField.setBounds(151, 230, 305, 25);
		panel.add(RoomNumtextField);
		
		JLabel lblRoomNum = new JLabel("Room Num : ");
		lblRoomNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRoomNum.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblRoomNum.setBounds(14, 229, 134, 24);
		panel.add(lblRoomNum);
		
		table = new JTable();
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.setFocusTraversalKeysEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cus_ ID", "Room_Num", "Check"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		JScrollPane jscrollpane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int rIndex = table.getSelectedRow();
				
				idtextField.setText(model.getValueAt(rIndex, 0).toString());
				CIDtextField.setText(model.getValueAt(rIndex, 1).toString());
				RoomNumtextField.setText(model.getValueAt(rIndex, 2).toString());
			}
		});
		jscrollpane.setBounds(480, 147, 376, 331);
		panel.add(jscrollpane);
		BillC.fillBillJTable(table);
		
		JButton btnNewButton = new JButton("Check In");
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.valueOf(idtextField.getText());
				String CID = CIDtextField.getText();
				String RoomNum = RoomNumtextField.getText();
				
				try
				{
					if(BillC.editCheck(id, CID, RoomNum))
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
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + "", "Customer ID Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(14, 362, 215, 48);
		panel.add(btnNewButton);
		
		JButton button = new JButton("Check Out");
		button.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		button.setBounds(243, 362, 213, 48);
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int id = Integer.valueOf(idtextField.getText());
				String ids = id + "";
				int CID = Integer.valueOf(CIDtextField.getText());
				int RoomNum = Integer.valueOf(RoomNumtextField.getText());
				String CusName = CusC.getCusName(CID);
				String CusPhone = CusC.getCusPhone(CID);
				String CusCredit = CusC.getCusCredit(CID);
				String RoomPhone = RoomC.getRoomPhone(RoomNum);
				String dateIn = ReservationC.getDinRes(id);
				String dateOut = ReservationC.getDoutRes(id);
				int resPrice = ReservationC.getPrice(id);
				
				try
				{
					System.out.println(ids);
					String filename = "訂房編號_" + ids + ".txt";
					File file = new File(filename);
					// creates the file
					file.createNewFile();
					// creates a FileWriter Object
					FileWriter writer = new FileWriter(file);
					// Writes the content to the file
					writer.write("客戶名稱：\t" + CusName + "\r\n");
					writer.write("客戶電話：\t" + CusPhone + "\r\n");
					writer.write("信用卡號：\t" + CusCredit + "\r\n");
					writer.write("入住房號：\t" + RoomPhone + "\r\n");
					writer.write("入住日期：\t" + dateIn + "\r\n");
					writer.write("退房日期：\t" + dateOut + "\r\n");
					writer.write("消費金額：\t" + resPrice + "\r\n");
					
					writer.flush();
					
				    writer.close();
				}
				catch(IOException eg)
				{
					eg.getMessage();
				}
				try
				{
					int reservation_id = Integer.valueOf(idtextField.getText());
					if(ReservationC.removeReservation(reservation_id))
					{
						JOptionPane.showMessageDialog(rootPane, "Reservation Deleted Successfully", "Remove Reservation", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						
						JOptionPane.showMessageDialog(rootPane, "Reservation didn't Deleted", "Remove Reservation Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter Reservation ID", "Reservation ID Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		panel.add(button);
		
		JButton btnNewButton_1 = new JButton("Clear button");
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		btnNewButton_1.setBounds(14, 423, 442, 55);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				idtextField.setText("");
				CIDtextField.setText("");
				RoomNumtextField.setText("");
				
			}
		});
		panel.add(btnNewButton_1);
		
		JButton refbtn = new JButton("Refresh");
		refbtn.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		refbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
				table.setRowHeight(30);
				table.setFocusTraversalKeysEnabled(false);
				table.getTableHeader().setReorderingAllowed(false);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"ID", "Cus_ ID", "Room_Num", "Check"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(0).setPreferredWidth(30);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(1).setPreferredWidth(60);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(80);
				
				BillC.fillBillJTable(table);
			}
		});
		refbtn.setBounds(757, 113, 99, 27);
		panel.add(refbtn);
	}
}
