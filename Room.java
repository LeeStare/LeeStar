package manage;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import newForm.ShowType;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Room extends JFrame {
	
	
	private JPanel contentPane;
	private final JTable table = new JTable();
	
	static RoomC roomC = new RoomC();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Room frame = new Room();
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
	public Room() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 882, 553);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 105, 180));
		panel_1.setBounds(0, 0, 882, 100);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room manage");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 40));
		lblNewLabel.setBounds(14, 24, 364, 60);
		panel_1.add(lblNewLabel);
		
		JLabel numlblId = new JLabel("Number : ");
		numlblId.setHorizontalAlignment(SwingConstants.RIGHT);
		numlblId.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		numlblId.setBounds(29, 147, 120, 24);
		panel.add(numlblId);
		
		JTextField numtextField = new JTextField();
		numtextField.setBounds(151, 148, 305, 25);
		panel.add(numtextField);
		numtextField.setColumns(10);
		
		JLabel lblRes = new JLabel("Reserved : ");
		lblRes.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRes.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblRes.setBounds(29, 355, 120, 24);
		panel.add(lblRes);
		
		JLabel lblQuality = new JLabel("Quality : ");
		lblQuality.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQuality.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblQuality.setBounds(29, 318, 120, 24);
		panel.add(lblQuality);
		
		JLabel lblSmoking = new JLabel("Smoking : ");
		lblSmoking.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSmoking.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblSmoking.setBounds(29, 236, 120, 24);
		panel.add(lblSmoking);
		table.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		
		
		
		table.setRowHeight(30);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"number",  "type", "phone","quality", "smoking", "reserved"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		JScrollPane jscrollpane = new JScrollPane(table);
		
		
		
		jscrollpane.setBounds(483, 147, 373, 331);
		panel.add(jscrollpane);
		
		
		JLabel ResLabel = new JLabel("");
		ResLabel.setVisible(false);
		ResLabel.setBounds(151, 113, 57, 19);
		panel.add(ResLabel);
		
		JLabel SmokingLabel = new JLabel("");
		SmokingLabel.setVisible(false);
		SmokingLabel.setBounds(151, 130, 57, 19);
		panel.add(SmokingLabel);
		
		
		JRadioButton jrb1 = new JRadioButton("NO");
		jrb1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		JRadioButton jrb2 = new JRadioButton("YES");
		jrb2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		jrb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ResLabel.setText(arg0.getStateChange()==1?"YES":"NO");
				
			}
		});
		jrb1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ResLabel.setText(arg0.getStateChange()==1?"NO":"YES");
				
			}
		});
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrb1);
		bg.add(jrb2);
		
		
		jrb1.setBounds(306, 355, 150, 27);
		jrb2.setBounds(150, 355, 150, 27);
		panel.add(jrb1);
		panel.add(jrb2);
		
		JRadioButton jrS1 = new JRadioButton("YES");
		jrS1.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		jrS1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				SmokingLabel.setText(arg0.getStateChange()==1?"YES":"NO");
				
			}
		});
		ButtonGroup bgS = new ButtonGroup();
		bgS.add(jrS1);
		
		
		jrS1.setBounds(151, 236, 150, 27);
		panel.add(jrS1);
		
		JRadioButton jrS2 = new JRadioButton("NO");
		jrS2.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		jrS2.setBounds(306, 236, 150, 27);
		panel.add(jrS2);
		jrS2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				SmokingLabel.setText(arg0.getStateChange()==1?"NO":"YES");
				
			}
		});
		bgS.add(jrS2);
		
		JLabel labelPhone = new JLabel("Phone : ");
		labelPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		labelPhone.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		labelPhone.setBounds(29, 191, 120, 24);
		panel.add(labelPhone);
		
		JTextField phoneTextField = new JTextField();
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(151, 190, 305, 25);
		panel.add(phoneTextField);
		
		JLabel lblType = new JLabel("Type : ");
		lblType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblType.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		lblType.setBounds(29, 281, 120, 24);
		panel.add(lblType);
		
		JComboBox<Integer> typeComboBox = new JComboBox<Integer>();
		typeComboBox.setBounds(151, 280, 149, 25);
		panel.add(typeComboBox);
		
		
		
		roomC.fillRoomTypeJCombo(typeComboBox);
		
		JButton showTypebtn = new JButton("Show All Type");
		showTypebtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				ShowType roomType = new ShowType();
				roomType.setVisible(true);
				roomType.setLocationRelativeTo(null);
				roomType.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			}
		});
		showTypebtn.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		showTypebtn.setBounds(307, 281, 149, 27);
		panel.add(showTypebtn);
		
		String[] starStrings =  new String[] { "☆☆★", "☆★★", "★★★"};
		DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(new String[] {"", "\u2606\u2606\u2605", "\u2606\u2605\u2605", "\u2605\u2605\u2605"});
		JComboBox<String> qualityComboBox = new JComboBox<>(comboModel);
		qualityComboBox.setBounds(151, 319, 305, 25);
		panel.add(qualityComboBox);
		
		
		JButton addbtn = new JButton("Add New Customer");
		addbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		addbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String roomNumber = numtextField.getText();
					int roomType = Integer.valueOf(typeComboBox.getSelectedItem().toString());
					String phone = phoneTextField.getText();
					String quality = qualityComboBox.getSelectedItem().toString();
					String smoking = SmokingLabel.getText();
					
					if(!roomNumber.equals(""))
					{
						if(RoomC.addInRoom(Integer.valueOf(roomNumber), roomType, phone, quality, smoking))
						{
							JOptionPane.showMessageDialog(rootPane, "New Room Added Successfully", "Add Room", JOptionPane.INFORMATION_MESSAGE);	
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane, "Room Number Error", "Add Room Error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
					else
					{
						if(RoomC.addRoom(roomType, phone, quality, smoking))
						{
							JOptionPane.showMessageDialog(rootPane, "New Room Added Successfully", "Add Room", JOptionPane.INFORMATION_MESSAGE);	
						}
						else
						{
							JOptionPane.showMessageDialog(rootPane, "Room didn't add", "Add Room Error", JOptionPane.ERROR_MESSAGE);
							
						}
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Room Number", "Room Number Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		addbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addbtn.setBounds(43, 397, 217, 40);
		panel.add(addbtn);
		
		JButton editbtn = new JButton("Edit");
		editbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		editbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int roomnumber = 0;
				int type = Integer.valueOf(typeComboBox.getSelectedItem().toString());
				String phone = phoneTextField.getText();
				String quality = qualityComboBox.getSelectedItem().toString();
				String smokingL = SmokingLabel.getText();
				String isReserved = ResLabel.getText();
				
				
				
				if(phone.trim().equals(""))
				{
					JOptionPane.showMessageDialog(rootPane, "Enter The Room Phone Num ", "Empty Fields", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					try
					{
						roomnumber = Integer.valueOf(numtextField.getText());
						if(RoomC.editRoom(roomnumber, type, phone, quality, smokingL, isReserved))
						{
							JOptionPane.showMessageDialog(rootPane, "Room Data Updated Successfully", "Edit Room Data", JOptionPane.INFORMATION_MESSAGE);
						}
						else
						{
							
							JOptionPane.showMessageDialog(rootPane, "Room Data didn't Updated", "Edit Room Data Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					catch(NumberFormatException ex)
					{
						JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Room number", "Room number Error", JOptionPane.ERROR_MESSAGE);
					}
					
					
				}
			}
		});
		editbtn.setBounds(263, 397, 76, 40);
		panel.add(editbtn);
		
		JButton removebtn = new JButton("Remove");
		removebtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		removebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					int roomnumber = Integer.valueOf(numtextField.getText());
					if(RoomC.removeRoom(roomnumber))
					{
						JOptionPane.showMessageDialog(rootPane, "Room Deleted Successfully", "Remove Room Data", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						
						JOptionPane.showMessageDialog(rootPane, "Room Data didn't Deleted", "Remove Room Data Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				catch(NumberFormatException ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.getMessage() + " -- Enter The Room number", "Room number Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		removebtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		removebtn.setBounds(340, 397, 116, 40);
		panel.add(removebtn);
		
		JButton clearbtn = new JButton("Clear Data");
		clearbtn.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		clearbtn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				numtextField.setText("");
				typeComboBox.setSelectedIndex(0);
				phoneTextField.setText("");
				qualityComboBox.setSelectedIndex(0);
				bgS.clearSelection();
				bg.clearSelection();
			}
		});
		clearbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		clearbtn.setBounds(43, 438, 413, 40);
		panel.add(clearbtn);
		
		Border border = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white);
		clearbtn.setBorder(border);
		
		roomC.fillRoomJTable(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int rIndex = table.getSelectedRow();
				
				numtextField.setText(model.getValueAt(rIndex, 0).toString());
				typeComboBox.setSelectedItem(model.getValueAt(rIndex, 1));
				phoneTextField.setText(model.getValueAt(rIndex, 2).toString());
				qualityComboBox.setSelectedItem(model.getValueAt(rIndex, 3));
				String smokingL = model.getValueAt(rIndex, 4).toString();
				if(smokingL.equals("YES"))
				{
					jrS1.setSelected(true);
				}
				else if(smokingL.equals("NO"))
				{
					jrS2.setSelected(true);
				}
				
				String reL = model.getValueAt(rIndex, 5).toString();
				if(reL.equals("YES"))
				{
					jrb2.setSelected(true);
				}
				else if(reL.equals("NO"))
				{
					jrb1.setSelected(true);
				}
			}
		});
		
		JButton refbtn = new JButton("Refresh");
		refbtn.setFont(new Font("微軟正黑體", Font.BOLD, 15));
		refbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				table.getTableHeader().setReorderingAllowed(false);
				table.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"number",  "type", "phone","quality", "smoking", "reserved"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
				table.getColumnModel().getColumn(0).setResizable(false);
				table.getColumnModel().getColumn(1).setResizable(false);
				table.getColumnModel().getColumn(2).setResizable(false);
				table.getColumnModel().getColumn(3).setResizable(false);
				table.getColumnModel().getColumn(4).setResizable(false);
				table.getColumnModel().getColumn(5).setResizable(false);
				roomC.fillRoomJTable(table);
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
					RoomC.resetAI();
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
