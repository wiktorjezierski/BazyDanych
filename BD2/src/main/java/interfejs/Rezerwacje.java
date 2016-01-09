package interfejs;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import BazyDanychProjekt.BD2.KlienciEntity;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class Rezerwacje extends JPanel {

	private JTextField txtDataZwrotu;
	private JTextField txtPeselKlienta;
	private JTextField txtDataRozpoczcia;
	private JTextField txtIdEgzemplarza;
	private JTable tableRezerwacje;
	private DodajKlienta dodajKlientaDlg;

	/**
	 * Create the panel.
	 */
	public Rezerwacje() {
		setLayout(null);

		dodajKlientaDlg = new DodajKlienta();
		txtPeselKlienta = new JTextField();
		txtPeselKlienta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtPeselKlienta.getText().equals("PESEL Klienta"))
					txtPeselKlienta.setText(null);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtPeselKlienta.getText().equals(""))
					txtPeselKlienta.setText("PESEL Klienta");
			}
		});
		txtPeselKlienta.setBounds(10, 289, 124, 20);
		txtPeselKlienta.setText("PESEL Klienta");
		add(txtPeselKlienta);
		txtPeselKlienta.setColumns(10);

		txtIdEgzemplarza = new JTextField();
		txtIdEgzemplarza.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtIdEgzemplarza.getText().equals("ID Egzemplarza"))
					txtIdEgzemplarza.setText(null);
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtIdEgzemplarza.getText().equals(""))
					txtIdEgzemplarza.setText("ID Egzemplarza");
			}
		});
		txtIdEgzemplarza.setBounds(144, 289, 127, 20);
		txtIdEgzemplarza.setText("ID Egzemplarza");
		add(txtIdEgzemplarza);
		txtIdEgzemplarza.setColumns(10);

		txtDataRozpoczcia = new JTextField();
		txtDataRozpoczcia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (txtDataRozpoczcia.getText().equals("Data rozpoczęcia"))
					txtDataRozpoczcia.setText(null);
			}

			@Override
			public void focusLost(FocusEvent e) {

				if (txtDataRozpoczcia.getText().equals(""))
					txtDataRozpoczcia.setText("Data rozpoczęcia");
			}
		});
		txtDataRozpoczcia.setBounds(281, 289, 124, 20);
		txtDataRozpoczcia.setText("Data rozpoczęcia");
		add(txtDataRozpoczcia);
		txtDataRozpoczcia.setColumns(10);

		txtDataZwrotu = new JTextField();
		txtDataZwrotu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDataZwrotu.getText().equals("Data zwrotu"))
					txtDataZwrotu.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDataZwrotu.getText().equals(""))
					txtDataZwrotu.setText("Data zwrotu");
			}
		});
		txtDataZwrotu.setBounds(415, 289, 124, 20);
		txtDataZwrotu.setText("Data zwrotu");
		add(txtDataZwrotu);
		txtDataZwrotu.setColumns(10);

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// gdy zmknie się okno dialogowe i klient zostanie pomyślnie
				// zapisany w bazie danych,
				// zostanie wywołana dalsza procedura dodawania rezerwacji

				/*
				 if( ! KlienciEntity.exists(txtPeselKlienta.getText()))
				 dodajRezerwacje(txtPeselKlienta.getText(),
				  txtIdEgzemplarza.getText() txtDataRozpoczcia.getText(),
				  txtDataZwrotu.getText()); else
				 */
				 
				//dodajKlientaDlg.setTxtPeselKlienta(txtPeselKlienta);
				//dodajKlientaDlg.setVisible(true);
				//dodajKlientaDlg.setLocationRelativeTo(null);
				
				JOptionPane.showMessageDialog(null, "To jest wersja demonstracyjna, która nie przewiduje tej funkcjonalności.", "DEMO", 1);
			}
		});
		btnDodaj.setBounds(549, 288, 86, 23);
		add(btnDodaj);

		JScrollPane scrollPaneRezerwacje = new JScrollPane();
		scrollPaneRezerwacje.setBounds(10, 11, 625, 255);
		add(scrollPaneRezerwacje);

		tableRezerwacje = new JTable();
		tableRezerwacje.setFillsViewportHeight(true);
		scrollPaneRezerwacje.setViewportView(tableRezerwacje);
		tableRezerwacje
				.setModel(
						new DefaultTableModel(
			new Object[][] {
				{"Narty biegowe", "32", "22.01.2016", "28.01.2016", "Piotr", "\u0141awniczak"},
				{"Sanki", "8", "20.12.2016", "21.12.2016", "Wiktor", "Jezierski"},
				{"Snowboard", "1", "02.02.2017", "22.03.2017", "Wiktor", "Jezierski"},
				{"Deska do krojenia", "99", "22.01.2016", "28.01.2016", "Jacek", "Placek"},
				{"Sanki z turbodo\u0142adowaniem", "33", "09.01.2016", "03.12.2023", "Turbodymomen", "Rakietowy"},
				{"Urz\u0105dzenie do rzucania \u015Bnie\u017Cek", "42", "01.05.2004", "31.03.2016", "Marek", "Kondrat"},
				{"Taczka na zimowej oponie", "45", "04.05.2004", "21.04.2016", "Zbyszek", "Chytry"},
				{"Sanki", "9", "20.12.2016", "21.12.2016", "Wanda", "Coniechcia\u0142aniemca"},
			},
			new String[] {
				"Rodzaj sprz\u0119tu", "ID Egzemplarza", "Data rozpocz\u0119cia wypo\u017Cyczenia", "Data zwrotu", "Imi\u0119 pracownika", "Nazwisko pracownika"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableRezerwacje.getColumnModel().getColumn(0).setPreferredWidth(135);
		tableRezerwacje.getColumnModel().getColumn(1).setPreferredWidth(15);
		tableRezerwacje.getColumnModel().getColumn(1).setMinWidth(7);
		tableRezerwacje.getColumnModel().getColumn(2).setPreferredWidth(50);
		tableRezerwacje.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableRezerwacje.getColumnModel().getColumn(4).setPreferredWidth(70);
		tableRezerwacje.getColumnModel().getColumn(5).setPreferredWidth(81);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 276, 625, 2);
		add(separator);

	}
}
