import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class TableMateriel extends AbstractTableModel {//implements TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 597372397938827337L;
	
	
	
	private Stock stock;
	private final String[] titre = { "Type de materiel", "Numero de serie", "Date d'achat", "Date de prêt"};	
	
/*
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableMateriel model = (TableMateriel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);

    }
  */  
	public TableMateriel(Stock db) {
		stock  = db;
		this.fireTableDataChanged();//facultatif

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return titre.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return titre[columnIndex];
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return stock.sizeInventaire();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
		//type
		return stock.getLigne(rowIndex).getClass().toString();
		case 1:
		//type
		return Integer.toString(stock.getLigne(rowIndex).serialNumber);
		case 2:
		//type
		return stock.getLigne(rowIndex).dateAchat.toString();
		case 3:
		//type
			if(stock.getLigne(rowIndex).datePret !=null) {return stock.getLigne(rowIndex).datePret.toString();			}
			return null;
		default:
			throw new IllegalArgumentException();
		}
		}


	
	/*
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
			case 0:
				return String.class;
	
			case 1:
				return int.class;
	
			case 2:
				return Date.class;
	
			case 3:
				return Date.class;
			default:
				return Object.class;
		}
	}
	*/
	
	}

	


	

