package interfejs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class Pracownicy extends JPanel {
	
	private JTable tablePracownicy;
	/**
	 * Create the panel.
	 */
	public Pracownicy() {
		setLayout(null);
		
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
		btnNewButton.setBounds(10, 293, 71, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		add(btnNewButton);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.setBounds(543, 293, 89, 23);
		add(btnDodaj_1);
		
	}

}
