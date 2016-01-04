package interfejs;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class Zestawy extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Zestawy() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 621, 294);
		add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Narty zjazdowe", "Google", "Kask", "20", "01.01.2016"},
				{"2", "Rower g\u00F3rski", "Buty zatrzaskowe", "Kask", "70", "30.06.2016"},
			},
			new String[] {
				"ID Zestawu", "Sprz\u0119t 1.", "Sprz\u0119t 2.", "Sprz\u0119t 3.", "Cena za dzie\u0144", "Aktualne do"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(39);
		table.getColumnModel().getColumn(1).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(90);
		table.getColumnModel().getColumn(4).setPreferredWidth(77);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(68);

	}

}
