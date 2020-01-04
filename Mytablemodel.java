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

		// ���o�檺Vector,�o�˶]�U�h��n���o�@��§�������
		for (String jumpcol : columns)
			vcolumn.add(jumpcol);

		// �o�ӬO���o�C��Vector,���e�O�ΤG���}�C,�{�b�令Vector���s��Vector
		// �N�������o��{{Vector},{Vector},....},Vector�i�H�O���󪺪���
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
		// TODO �۰ʲ��ͪ���k Stub
		return columns.length;
	}
	@Override
	public int getRowCount() {
		// TODO �۰ʲ��ͪ���k Stub
		return action.length;
	}
	
	public String getColumnName(int col) {
        return columns[col];
    }
	
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO �۰ʲ��ͪ���k Stub
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