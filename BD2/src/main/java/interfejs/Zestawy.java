package interfejs;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BazyDanychProjekt.ApplicationFunction.ZestawyAF;
import BazyDanychProjekt.BD2.KlienciEntity;
import BazyDanychProjekt.BD2.ZestawyEntity;

import javax.swing.JScrollPane;

public class Zestawy extends JPanel {
	private JTable table;

	private ZestawyAF mZestaw;
	private List<ZestawyEntity> allKits;
	/**
	 * Create the panel.
	 */
	public Zestawy() {
		mZestaw = new ZestawyAF();
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 621, 294);
		add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Narty zjazdowe", "Google", "20", "01.01.2016"},
				{"2", "Rower g\u00F3rski", "Buty zatrzaskowe", "70", "30.06.2016"},
			},
			new String[] {
				"ID Zestawu", "Sprz\u0119t 1.", "Sprz\u0119t 2.", "Cena za dzie\u0144", "Aktualne do"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(74);
		table.getColumnModel().getColumn(1).setPreferredWidth(136);
		table.getColumnModel().getColumn(2).setPreferredWidth(152);
		table.getColumnModel().getColumn(3).setPreferredWidth(77);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(68);

		setContentTable();
	}
	private void setContentTable() {
		allKits = mZestaw.findAllKits();

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (ZestawyEntity p : allKits) {
			model.addRow(new Object[] { p.getId(), p.getNazwaSprzet1(), p.getNazwaSprzet2(), p.getDataEnd(), p.getCena() });
		}
	}
}
