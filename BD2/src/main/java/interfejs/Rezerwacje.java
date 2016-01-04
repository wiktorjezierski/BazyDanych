package interfejs;

import javax.swing.JButton;
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
		txtPeselKlienta.setBounds(10, 6, 124, 20);
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
		txtIdEgzemplarza.setBounds(144, 6, 127, 20);
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
		txtDataRozpoczcia.setBounds(281, 6, 124, 20);
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
		txtDataZwrotu.setBounds(415, 6, 124, 20);
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
				 
				dodajKlientaDlg.setTxtPeselKlienta(txtPeselKlienta);
				dodajKlientaDlg.setVisible(true);
				dodajKlientaDlg.setLocationRelativeTo(null);
			}
		});
		btnDodaj.setBounds(549, 5, 86, 23);
		add(btnDodaj);

		JButton btnNewButton_1 = new JButton("Cofnij rezerwację");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(492, 291, 143, 23);
		add(btnNewButton_1);

		JScrollPane scrollPaneRezerwacje = new JScrollPane();
		scrollPaneRezerwacje.setBounds(10, 34, 625, 246);
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
		tableRezerwacje.getColumnModel().getColumn(0).setPreferredWidth(88);
		tableRezerwacje.getColumnModel().getColumn(1).setPreferredWidth(37);
		tableRezerwacje.getColumnModel().getColumn(2).setPreferredWidth(80);

	}

}
