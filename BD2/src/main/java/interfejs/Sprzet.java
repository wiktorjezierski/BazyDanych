package interfejs;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import BazyDanychProjekt.ApplicationFunction.SprzetAF;
import BazyDanychProjekt.BD2.ProducentEntity;
import BazyDanychProjekt.BD2.SprzetEntity;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
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
	
	
	private boolean dodawanieSprz(){
		DodajSprzet dodajSprzetDialog = new DodajSprzet(frame);
		dodajSprzetDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dodajSprzetDialog.setVisible(true);
		
		return dodajSprzetDialog.isEntryAdded();
	}
	
	
	SprzetAF mSprzet;
	private JTable table;
	private ProducentEntity pr;
	
	private JFrame frame;
	private JButton btnDodajSprzet;
	/**
	 * Create the panel.
	 */
	public Sprzet(JFrame fr) {
		frame = fr;
		setLayout(null);
		mSprzet = new SprzetAF();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 622, 275);
		add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
		
		btnDodajSprzet = new JButton("Dodaj Sprzęt");
		btnDodajSprzet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dodawanieSprz())
					setContentTable();
			}
		});
		btnDodajSprzet.setBounds(514, 297, 118, 23);
		add(btnDodajSprzet);
		
		setContentTable();
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






