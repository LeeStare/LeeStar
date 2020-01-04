package manage;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Mytablemodel extends AbstractTableModel {
	static String[] columns = { "ID", "name", "phone", "address", "credit card" };
	static Object[][] action = {};
	public static DefaultTableModel getdtm() {
		
		DefaultTableModel dtm = new DefaultTableModel();
		Vector<String> vcolumn = new Vector<String>();
		Vector<Vector> vrow = new Vector<Vector>();
		Vector<Object> temp;

		// 取得欄的Vector,這樣跑下去剛好取得一個禮拜的欄位
		for (String jumpcol : columns)
			vcolumn.add(jumpcol);

		// 這個是取得列的Vector,之前是用二維陣列,現在改成Vector內存著Vector
		// 意思類似這樣{{Vector},{Vector},....},Vector可以是任何的物件
		for (int i = 0; i < action.length; i++) {
			temp = new Vector<Object>();
			for (int j = 0; j < action[i].length; j++) {
				temp.add(action[i][j]);
			}
			vrow.add(temp);
		}

		dtm.setDataVector(vrow, vcolumn);
		return dtm;

	}
	public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
	@Override
	public int getColumnCount() {
		// TODO 自動產生的方法 Stub
		return columns.length;
	}
	@Override
	public int getRowCount() {
		// TODO 自動產生的方法 Stub
		return action.length;
	}
	
	public String getColumnName(int col) {
        return columns[col];
    }
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO 自動產生的方法 Stub
		return action[rowIndex][columnIndex];
	}
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	public void setValueAt(Object value, int row, int col) {
        action[row][col] = value;
        fireTableCellUpdated(row, col);
    }
}