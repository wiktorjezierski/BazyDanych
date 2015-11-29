package interfejs;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Zestawy extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public Zestawy() {
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Narty zjazdowe", "Google", "Kask", "20", "01.01.2016"},
				{"2", "Rower g\u00F3rski", "Buty zatrzaskowe", "Kask", "70", "30.06.2016"},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID Zestawu", "Sprz\u0119t 1.", "Sprz\u0119t 2.", "Sprz\u0119t 3.", "Cena za dzie\u0144", "Aktualne do"
			}
		));
		add(table);

	}

}
