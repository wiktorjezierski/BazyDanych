package interfejs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import BazyDanychProjekt.ApplicationFunction.PracownicyAF;
import BazyDanychProjekt.BD2.PracownicyEntity;

public class Pracownicy extends JPanel {
	
	private JTable tablePracownicy;
	private PracownicyAF mPracownicy;
	
	/**
	 * Create the panel.
	 */
	public Pracownicy() {
		setLayout(null);
		mPracownicy = new PracownicyAF();
		
		JScrollPane scrollPanePracownicy = new JScrollPane();
		scrollPanePracownicy.setBounds(10, 9, 622, 273);
		add(scrollPanePracownicy);
		
		tablePracownicy = new JTable();
		tablePracownicy.setFillsViewportHeight(true);
		scrollPanePracownicy.setViewportView(tablePracownicy);
		tablePracownicy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePracownicy.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"PESEL", "Imi\u0119", "Nazwisko", "Data rozpocz\u0119cia pracy", "Zatrudniony"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablePracownicy.getColumnModel().getColumn(0).setPreferredWidth(53);
		tablePracownicy.getColumnModel().getColumn(3).setPreferredWidth(83);
		
		JButton btnNewButton = new JButton("Usuń");
		btnNewButton.setBounds(10, 293, 71, 23);		
		add(btnNewButton);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.addActionListener(btnAdd);
		btnDodaj_1.setBounds(543, 293, 89, 23);
		add(btnDodaj_1);
		
		ActionListener btnDelete = delete;
		btnNewButton.addActionListener(btnDelete);
		
		setContentTable(true);
		}
	
	
	ActionListener btnAdd = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	ActionListener delete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int selectedRow = tablePracownicy.getSelectedRow();
			boolean rm = mPracownicy.remove(selectedRow);

			if (rm == true) {
				setContentTable(false);
				JOptionPane.showMessageDialog(null, "Pomyślnie usunięto pracownika z bazy.");
			} else {
				JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas usuwania pracownika.");
			}
		}
	};
	
	private void setContentTable(boolean choice) {
		if (choice == true)
			mPracownicy.setEmployees(mPracownicy.findAllEmployees());
		
		//tablePracownicy.setModel(new DefaultTableModel(new Object[][] {},
			//	new String[] { "PESEL", "Imi\u0119", "Nazwisko", "Data rozpocz\u0119cia pracy", "Zatrudniony" }));
		DefaultTableModel model = (DefaultTableModel) tablePracownicy.getModel();

		for (PracownicyEntity p : mPracownicy.getEmployees()) {
			model.addRow(new Object[] { p.getPeselPrac(), p.getImie(), p.getNazwisko(), p.getDataStartu().toString(),
					p.getZwolniony() });
		}
	}
}