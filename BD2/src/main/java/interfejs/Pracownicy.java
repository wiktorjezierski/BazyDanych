package interfejs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

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
		scrollPanePracownicy.setViewportView(tablePracownicy);
		tablePracownicy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePracownicy.setModel(new DefaultTableModel(
			new Object[][] {
				{"94022214550", "Piotr", "\u0141awniczak", "22.11.2015", "true"},
				{"93012132442", "Wiktor", "Jezierski", "27.11.2015", "true"},
				{"77083044329", "Rozb\u00F3jnik", "Alibaba", "11.02.2004", "false"},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"PESEL", "Imi\u0119", "Nazwisko", "Data rozpocz\u0119cia pracy", "Zatrudniony"
			}
		));
		
		JButton btnNewButton = new JButton("Usuń");
		btnNewButton.addActionListener(btnDelete);
		btnNewButton.setBounds(10, 293, 71, 23);		
		add(btnNewButton);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.addActionListener(btnAdd);
		btnDodaj_1.setBounds(543, 293, 89, 23);
		add(btnDodaj_1);
		
		setContentTable();
	}
	
	ActionListener btnDelete = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	ActionListener btnAdd = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	
	private void setContentTable() {
		try {
			List<PracownicyEntity> employees = mPracownicy.findAllEmployees();
			employees.remove(0);
			TableModel model = tablePracownicy.getModel();
			PracownicyEntity p;
			
			for (int i = 0; i < employees.size(); i++) {
				p = employees.get(i);
				model.setValueAt(p.getPeselPrac(), i, 0);
				model.setValueAt(p.getImie(), i, 1);
				model.setValueAt(p.getNazwisko(), i, 2);
				model.setValueAt(p.getDataStartu().toString(), i, 3);

				if (p.getZwolniony() != null)
					model.setValueAt(p.getZwolniony().toString(), i, 4);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}