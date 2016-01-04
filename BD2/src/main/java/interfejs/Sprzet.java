package interfejs;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BazyDanychProjekt.ApplicationFunction.SprzetAF;
import BazyDanychProjekt.BD2.PracownicyEntity;
import BazyDanychProjekt.BD2.ProducentEntity;
import BazyDanychProjekt.BD2.SprzetEntity;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sprzet extends JPanel {
	
	SprzetAF mSprzet;
	private JTable table;
	private JTextField txtNazwa;
	private JTextField txtMarka;
	private JTextField txtKategoria;
	private JTextField txtDataZakupu;
	private JTextField txtSztuki;
	private ProducentEntity pr;
	private JButton btnProducent;
	
	private JFrame frame;
	/**
	 * Create the panel.
	 */
	public Sprzet(JFrame fr) {
		frame = fr;
		setLayout(null);
		mSprzet = new SprzetAF();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 622, 266);
		add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Nazwa", "Marka", "Kategoria", "Data zakupu"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
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
		txtMarka.setBounds(106, 11, 69, 20);
		add(txtMarka);
		txtMarka.setColumns(10);
		
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
		txtKategoria.setBounds(315, 11, 77, 20);
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
		txtDataZakupu.setBounds(402, 11, 78, 20);
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
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SprzetEntity sp = new SprzetEntity();

				String testDate = txtDataZakupu.getText();
				DateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
				try {
					sp.setDataZakupu(formatter.parse(testDate));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				sp.setKategoria(txtKategoria.getText());
				sp.setMarka(txtMarka.getText());
				sp.setNazwa(txtNazwa.getText());
				sp.setIlosc(Integer.parseInt(txtSztuki.getText()));
				sp.setDostepnych(Integer.parseInt(txtSztuki.getText()));

//				ProducentEntity pr = mSprzet.wybierzProducenta();
				if (pr != null) {
					sp.setProducent(pr);

					boolean test = mSprzet.dodaj(sp);
					if (test) {
						JOptionPane.showMessageDialog(null, "Dodano");
						wyczysc();
					} else {
						JOptionPane.showMessageDialog(scrollPane, "Wystąpił błąd podczas zapisu, spróbuj później", "Błąd!",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(scrollPane, "Błędny numer producenta.", "Błąd!",
							JOptionPane.ERROR_MESSAGE);
				}
				setContentTable();
			}
		});
		btnDodaj.setBounds(543, 10, 89, 23);
		add(btnDodaj);
		
		btnProducent = new JButton("Producent");
		btnProducent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr = mSprzet.wybierzProducenta(frame);
				btnProducent.setText(pr.getNazwa());
			}
		});
		btnProducent.setBounds(185, 10, 120, 23);
		add(btnProducent);
		
		setContentTable();
	}
	
	private void wyczysc(){
		txtDataZakupu.setText("Data zakupu");
		txtKategoria.setText("Kategoria");
		txtMarka.setText("Marka");
		txtNazwa.setText("Nazwa");
		btnProducent.setText("Producent");
		txtSztuki.setText("Sztuk");
	}
	
	private void setContentTable() {
		//table.setModel(new DefaultTableModel(new Object[][] {},
		//		new String[] { "Nazwa", "Marka", "Kategoria", "Data zakupu"}));
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		for (SprzetEntity p : mSprzet.findAllDevice()) {
			model.addRow(new Object[] {p.getNazwa(), p.getMarka(), p.getKategoria(), p.getDataZakupu() });
		}
	}
	
}






