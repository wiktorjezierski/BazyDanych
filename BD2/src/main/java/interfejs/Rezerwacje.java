package interfejs;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Rezerwacje extends JPanel {

	private JTextField txtDataZwrotu;
	private JTextField txtPeselKlienta;
	private JTextField txtDataRozpoczcia;
	private JTextField txtIdEgzemplarza;
	private JTable tableRezerwacje;
	/**
	 * Create the panel.
	 */
	public Rezerwacje() {
		setLayout(null);
		
		txtPeselKlienta = new JTextField();
		txtPeselKlienta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtPeselKlienta.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtPeselKlienta.getText() == null)	//dlaczego nie łapie tego ifa???
					txtPeselKlienta.setText("PESEL Klienta");
			}
		});
		txtPeselKlienta.setBounds(10, 6, 124, 20);
		txtPeselKlienta.setText("PESEL Klienta");
		add(txtPeselKlienta);
		txtPeselKlienta.setColumns(10);
		
		txtIdEgzemplarza = new JTextField();
		txtIdEgzemplarza.setBounds(144, 6, 127, 20);
		txtIdEgzemplarza.setText("ID Egzemplarza");
		add(txtIdEgzemplarza);
		txtIdEgzemplarza.setColumns(10);
		
		txtDataRozpoczcia = new JTextField();
		txtDataRozpoczcia.setBounds(281, 6, 111, 20);
		txtDataRozpoczcia.setText("Data rozpoczęcia");
		add(txtDataRozpoczcia);
		txtDataRozpoczcia.setColumns(10);
		
		txtDataZwrotu = new JTextField();
		txtDataZwrotu.setBounds(402, 6, 111, 20);
		txtDataZwrotu.setText("Data zwrotu");
		add(txtDataZwrotu);
		txtDataZwrotu.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(534, 5, 86, 23);
		add(btnDodaj);
		
		JButton btnNewButton_1 = new JButton("Cofnij rezerwację");
		btnNewButton_1.setBounds(477, 307, 143, 23);
		add(btnNewButton_1);
		
		JScrollPane scrollPaneRezerwacje = new JScrollPane();
		scrollPaneRezerwacje.setBounds(10, 34, 610, 262);
		add(scrollPaneRezerwacje);
		
		tableRezerwacje = new JTable();
		scrollPaneRezerwacje.setViewportView(tableRezerwacje);
		tableRezerwacje.setModel(new DefaultTableModel(
			new Object[][] {
				{"Narty biegowe", "32", "22.01.2016", "28.01.2016", "Piotr", "\u0141awniczak"},
				{"Sanki", "8", "20.12.2016", "21.12.2016", "Wiktor", "Jezierski"},
				{"Snowboard", "1", "02.02.2017", "22.03.2017", "Wiktor", "Jezierski"},
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
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Rodzaj sprz\u0119tu", "ID Egzemplarza", "Data rozpocz\u0119cia wypo\u017Cyczenia", "Data zwrotu", "Imi\u0119 pracownika", "Nazwisko pracownika"
			}
		));
		
	}

}
