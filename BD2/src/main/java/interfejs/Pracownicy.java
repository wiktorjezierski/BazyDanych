package interfejs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

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
	List<PracownicyEntity> employees;
	
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
			},
			new String[] {
				"PESEL", "Imi\u0119", "Nazwisko", "Data rozpocz\u0119cia pracy", "Zatrudniony"
			}
		));
		
		JButton btnNewButton = new JButton("Usuń");
		btnNewButton.setBounds(10, 293, 71, 23);		
		add(btnNewButton);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.addActionListener(btnAdd);
		btnDodaj_1.setBounds(543, 293, 89, 23);
		add(btnDodaj_1);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel model = (DefaultTableModel) tablePracownicy.getModel();
				int selectedRow = tablePracownicy.getSelectedRow();
				Object S = model.getValueAt(selectedRow, 1);
				JOptionPane.showMessageDialog(null, S);
				
			}
		});
		btnNewButton_1.setBounds(112, 293, 89, 23);
		add(btnNewButton_1);
		
		ActionListener btnDelete = delete;
		btnNewButton.addActionListener(btnDelete);
		
		setContentTable();
		}
	
	
	ActionListener btnAdd = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
	ActionListener delete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int selectedRow = tablePracownicy.getSelectedRow();
			PracownicyEntity prac = employees.get(selectedRow);
			boolean rm = mPracownicy.remove(prac);

			if (rm == true) {
				setContentTable();
				JOptionPane.showMessageDialog(null, "usunieto");
				employees.clear();
			} else {
				JOptionPane.showMessageDialog(null, "Nie usunieto");
			}
		}
	};
	
	private void setContentTable() {
		employees = mPracownicy.findAllEmployees();
		employees.remove(0);
		tablePracownicy.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "PESEL", "Imi\u0119", "Nazwisko", "Data rozpocz\u0119cia pracy", "Zatrudniony" }));
		DefaultTableModel model = (DefaultTableModel) tablePracownicy.getModel();

		for (PracownicyEntity p : employees) {
			model.addRow(new Object[] { p.getPeselPrac(), p.getImie(), p.getNazwisko(), p.getDataStartu().toString(),
					p.getZwolniony() });
		}
	}
}