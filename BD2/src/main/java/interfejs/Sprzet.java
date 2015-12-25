package interfejs;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Sprzet extends JPanel {
	private JTable table;
	private JTextField txtNazwa;
	private JTextField txtMarka;
	private JTextField txtNazwaProd;
	private JTextField txtKategoria;
	private JTextField txtDataZakupu;
	private JTextField txtSztuki;

	/**
	 * Create the panel.
	 */
	public Sprzet() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 622, 285);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nazwa", "Marka", "Nazwa producenta", "Kategoria", "Data zakupu", "Sztuk dostepnych/wszystkich"
			}
		));
		scrollPane.setViewportView(table);
		
		txtNazwa = new JTextField();
		txtNazwa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNazwa.getText().equals("Nazwa"))
					txtNazwa.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNazwa.getText().equals(""))
					txtNazwa.setText("Nazwa");
			}
		});
		txtNazwa.setText("Nazwa");
		txtNazwa.setBounds(10, 11, 86, 20);
		add(txtNazwa);
		txtNazwa.setColumns(10);
		
		txtMarka = new JTextField();
		txtMarka.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtMarka.getText().equals("Marka"))
					txtMarka.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtMarka.getText().equals(""))
					txtMarka.setText("Marka");
			}
		});
		txtMarka.setText("Marka");
		txtMarka.setBounds(106, 11, 86, 20);
		add(txtMarka);
		txtMarka.setColumns(10);
		
		txtNazwaProd = new JTextField();
		txtNazwaProd.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNazwaProd.getText().equals("Nazwa produktu"))
					txtNazwaProd.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNazwaProd.getText().equals(""))
					txtNazwaProd.setText("Nazwa produktu");
			}
		});
		txtNazwaProd.setText("Nazwa produktu");
		txtNazwaProd.setBounds(202, 11, 96, 20);
		add(txtNazwaProd);
		txtNazwaProd.setColumns(10);
		
		txtKategoria = new JTextField();
		txtKategoria.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtKategoria.getText().equals("Kategoria"))
					txtKategoria.setText(null);					
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtKategoria.getText().equals(""))
					txtKategoria.setText("Kategoria");		
			}
		});
		txtKategoria.setText("Kategoria");
		txtKategoria.setBounds(308, 11, 86, 20);
		add(txtKategoria);
		txtKategoria.setColumns(10);
		
		txtDataZakupu = new JTextField();
		txtDataZakupu.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDataZakupu.getText().equals("Data zakupu"))
					txtDataZakupu.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDataZakupu.getText().equals(""))
					txtDataZakupu.setText("Data zakupu");
			}
		});
		txtDataZakupu.setText("Data zakupu");
		txtDataZakupu.setBounds(404, 11, 76, 20);
		add(txtDataZakupu);
		txtDataZakupu.setColumns(10);
		
		txtSztuki = new JTextField();
		txtSztuki.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtSztuki.getText().equals("Sztuk"))		
					txtSztuki.setText(null);
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtSztuki.getText().equals(""))
					txtSztuki.setText("Sztuk");
			}
		});
		txtSztuki.setText("Sztuk");
		txtSztuki.setBounds(490, 11, 44, 20);
		add(txtSztuki);
		txtSztuki.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(543, 10, 89, 23);
		add(btnDodaj);

	}
}
