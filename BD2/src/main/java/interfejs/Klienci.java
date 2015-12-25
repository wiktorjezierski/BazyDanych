package interfejs;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Klienci extends JPanel {

	private JTable table;
	private DodajKlienta dodajKlientaDlg;
	
	public Klienci() {

		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 620, 271);
		add(scrollPane);
		
		table = new JTable();
		dodajKlientaDlg = new DodajKlienta();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
				{null, null, null, null, null},
			},
			new String[] {
				"Pesel", "Imi\u0119", "Nazwisko", "Nr Dowodu", "Liczba Transakcji"
			}
		));
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajKlientaDlg.setVisible(true);
			}
		});
		btnDodaj.setBounds(541, 293, 89, 23);
		add(btnDodaj);
		
		JButton btnUsun = new JButton("Usuń");
		btnUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//funkcja ta będzie wysyłać do bazy danych zapytanie usuwające rekord klienta zaznaczonego aktualnie w tabeli
			//nie wiem czy ID klientów w tabeli zgadzają się z ID klientów w Hibernacie, ale myślę że to nie bedzie ogółem trudne do zaimplementowania
			}
		});
		btnUsun.setBounds(10, 293, 89, 23);
		add(btnUsun);
		
	}
}
