package manage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DropMode;
import javax.swing.SwingConstants;

public class Reservetation extends JFrame {

	private JPanel contentPane;
	private JTextField idtextField;
	private JTextField CIDtextField;
	private JTextField RoomNumtextField;
	private static JTable table = new JTable();
	
	
	static ReservationC resc = new ReservationC();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservetation frame = new Reservetation();
					frame.setVisible(true);
					//cusc.fillCusJTable(table);
					
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
	public Reservetation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(0, 0, 882, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 882, 100);
		panel_1.setBackground(new Color(60, 179, 113));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCustomerManage = new JLabel("Reservations manage");
		lblCustomerManage.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		lblCustomerManage.setForeground(new Color(255, 255, 255));
		lblCustomerManage.setBounds(14, 24, 445, 60);
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
		
		JDateChooser dateInChooser = new JDateChooser();
		dateInChooser.setDateFormatString("yyyy-MM-dd");
		dateInChooser.setBounds(151, 275, 305, 25);
		panel.add(dateInChooser);
		

		JDateChooser dateOutChooser = new JDateChooser();
		dateOutChooser.setDateFormatString("yyyy-MM-dd");
		dateOutChooser.setBounds(151, 321, 305, 25);
		panel.add(dateOutChooser);
		
		JLabel lblAddress = new JLabel("Date In : ");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblAddress.setBounds(58, 274, 90, 24);
		panel.add(lblAddress);
		
		JLabel lblCreditCard = new JLabel("Date Out : ");
		lblCreditCard.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCreditCard.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblCreditCard.setBounds(32, 322, 116, 24);
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
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		table.setRowHeight(30);
		table.setFocusTraversalKeysEnabled(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Cus_ ID", "Room_Num", "Data In", "Data Out"
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
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(80);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(80);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
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
				try {
					Date dateIn = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rIndex, 3).toString());
					dateInChooser.setDate(dateIn);
					Date dateOut = new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(rIndex, 4).toString());
					dateOutChooser.setDate(dateOut);
				} catch (ParseException e) {
					// TODO 自動產生的 catch 區塊
					e.printStackTrace();
				}
			}
		});
		jscrollpane.setBounds(480, 147, 376, 331);
		panel.add(jscrollpane);
		ReservationC.fillReservationJTable(table);
		
		
		JButton addbtn = new JButton("Add New Reservation");
		addbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String id = idtextField.getText();
					int customer_id = Integer.valueOf(CIDtextField.getText());
					int room_Number = Integer.valueOf(RoomNumtextField.getText());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String date_in = dateFormat.format(dateInChooser.getDate());
					String date_out = dateFormat.format(dateOutChooser.getDate());
					String td = dateFormat.format(new Date());
					
					Date date_in2 = dateFormat.parse(date_in);
					Date date_out2 = dateFormat.parse(date_out);
					
					Date toDay = dateFormat.parse(td);
					
					if(!(date_in2.after(toDay) || date_in2.equals(toDay)))
					{
						JOptionPane.showMessageDialog(rootPane, "The Date In Must Be After today", "Date In Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(!date_out2.after(date_in2))
					{
						JOptionPane.showMessageDialog(rootPane, "The Date Out Must Be After Date In", "Date Out Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(!id.equals(""))
						{
							if(ReservationC.addInReservation(Integer.valueOf(id), customer_id, room_Number, date_in, date_out))
							{
								JOptionPane.showMessageDialog(rootPane, "New Reservation Added Successfully", "Add Reservation", JOptionPane.INFORMATION_MESSAGE);	
							}
							else
							{
								JOptionPane.showMessageDialog(rootPane, "Reservation ID Error", "Add Reservation Error", JOptionPane.ERROR_MESSAGE);
								
							}
						}
						else
						{
							if(ReservationC.addReservation(customer_id, room_Number, date_in, date_out))
							{
								JOptionPane.showMessageDialog(rootPane, "New Reservation Added Successfully", "Add Reservation", JOptionPane.INFORMATION_MESSAGE);	
							}
							else
							{
								JOptionPane.showMessageDialog(rootPane, "Reservation didn't add", "Add Reservation Error", JOptionPane.ERROR_MESSAGE);
								
							}
						}
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Room Number + Customer ID", "Inputs Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(ParseException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		addbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addbtn.setBounds(14, 394, 239, 40);
		panel.add(addbtn);
		
		JButton editbtn = new JButton("Edit");
		editbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		editbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				
				try
				{
					int reservation_id = Integer.valueOf(idtextField.getText());
					int customer_id = Integer.valueOf(CIDtextField.getText());
					int room_number = Integer.valueOf(RoomNumtextField.getText());
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String date_in = dateFormat.format(dateInChooser.getDate());
					String date_out = dateFormat.format(dateOutChooser.getDate());
					String td = dateFormat.format(new Date());
					
					Date date_in2 = dateFormat.parse(date_in);
					Date date_out2 = dateFormat.parse(date_out);
					
					Date toDay = dateFormat.parse(td);
					
					
					if(!(date_in2.after(toDay) || date_in2.equals(toDay)))
					{
						JOptionPane.showMessageDialog(rootPane, "The Date In Must Be After today", "Date In Error", JOptionPane.ERROR_MESSAGE);
					}
					else if(!date_out2.after(date_in2))
					{
						JOptionPane.showMessageDialog(rootPane, "The Date Out Must Be After Date In", "Date Out Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						if(ReservationC.editReservation(reservation_id, customer_id, room_number, date_in, date_out))
						{
							JOptionPane.showMessageDialog(rootPane, "Reservation Inf Updated Successfully", "Edit Reservation", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane, "Reservation Inf didn't Updated", "Edit Reservation Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Room number + Customer ID + Reservation ID", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(NullPointerException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter Date In + Date Out", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
				catch(ParseException ex)
				{
					ex.printStackTrace();
				}
			}
		});
		editbtn.setBounds(258, 394, 83, 40);
		panel.add(editbtn);
		
		JButton removebtn = new JButton("Remove");
		removebtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		removebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
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
		removebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removebtn.setBounds(345, 394, 111, 40);
		panel.add(removebtn);
		
		JButton clearbtn = new JButton("Clear Data");
		clearbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		clearbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				idtextField.setText("");
				CIDtextField.setText("");
				RoomNumtextField.setText("");
				dateInChooser.setDate(null);
				dateOutChooser.setDate(null);
			}
		});
		clearbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearbtn.setBounds(14, 438, 442, 40);
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
						"ID", "Cus_ ID", "Room_Num", "Data In", "Data Out"
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
				table.getColumnModel().getColumn(1).setPreferredWidth(60);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(2).setPreferredWidth(80);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(3).setPreferredWidth(80);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(4).setPreferredWidth(80);
				
				ReservationC.fillReservationJTable(table);
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
					ReservationC.resetAI();
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
