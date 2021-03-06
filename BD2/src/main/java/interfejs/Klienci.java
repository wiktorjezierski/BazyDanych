package interfejs;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BazyDanychProjekt.ApplicationFunction.KlienciAF;
import BazyDanychProjekt.BD2.KlienciEntity;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class Klienci extends JPanel {

	private JTable table;
	private DodajKlienta dodajKlientaDlg;
	private KlienciAF mKlient;
	private List<KlienciEntity> allCustomers;

	public Klienci() {
		mKlient = new KlienciAF();
		setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 620, 352);
		add(scrollPane);
		dodajKlientaDlg = new DodajKlienta();
		table = new JTable();
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Pesel", "Imi\u0119", "Nazwisko", "Nr Dowodu", "Numer telefonu", "Liczba Transakcji" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(69);
		table.getColumnModel().getColumn(3).setResizable(false);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dodajKlientaDlg.setLocationRelativeTo(null);
				dodajKlientaDlg.setVisible(true);
			}
		});
		btnDodaj.setBounds(541, 374, 89, 23);
		add(btnDodaj);

		JButton btnUsun = new JButton("Usuń");
		btnUsun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// funkcja ta będzie wysyłać do bazy danych zapytanie usuwające
				// rekord klienta zaznaczonego aktualnie w tabeli
				// nie wiem czy ID klientów w tabeli zgadzają się z ID klientów
				// w Hibernacie, ale myślę że to nie bedzie ogółem trudne do
				// zaimplementowania
				int selectedRow = table.getSelectedRow();
				boolean rm = mKlient.remove(selectedRow);
				
				if (rm == true){
					DefaultTableModel model = (DefaultTableModel)table.getModel();
					model.removeRow(selectedRow);
				} else {
					JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas usuwania pracownika.");
				}
			}
		});
		btnUsun.setBounds(10, 374, 89, 23);
		add(btnUsun);
		setContentTable();
	}

	private void setContentTable() {
		mKlient.setClients(mKlient.findAllCustomers());

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (KlienciEntity p : mKlient.getClients()) {
			model.addRow(new Object[] { p.getPesel(), p.getImie(), p.getNazwisko(), p.getNrDowodu(), p.getNrTelefonu(),
					p.getIloscTransakcji() });
		}
	}
}
