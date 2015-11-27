package interfejs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.Rectangle;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frame;
	private JTable tablePracownicy;
	private JTextField txtDataZwrotu;
	private JTextField txtPeselKlienta;
	private JTextField txtDataRozpoczcia;
	private JTextField txtIdEgzemplarza;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 559, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(new Rectangle(0, 0, 531, 242));
		
		JPanel panPracownicy = new JPanel();
		tabbedPane.addTab("Pracownicy", null, panPracownicy, null);
		panPracownicy.setLayout(null);
		
		tablePracownicy = new JTable();
		tablePracownicy.setBounds(30, 9, 469, 160);
		tablePracownicy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePracownicy.setModel(new DefaultTableModel(
			new Object[][] {
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
		panPracownicy.add(tablePracownicy);
		
		JButton btnNewButton = new JButton("Usuń");
		btnNewButton.setBounds(428, 180, 71, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().setLayout(null);
		panPracownicy.add(btnNewButton);
		
		JPanel panRezerwacje = new JPanel();
		tabbedPane.addTab("Rezerwacje", null, panRezerwacje, null);
		panRezerwacje.setLayout(null);
		
		txtPeselKlienta = new JTextField();
		txtPeselKlienta.setBounds(22, 6, 86, 20);
		txtPeselKlienta.setText("PESEL Klienta");
		panRezerwacje.add(txtPeselKlienta);
		txtPeselKlienta.setColumns(10);
		
		txtIdEgzemplarza = new JTextField();
		txtIdEgzemplarza.setBounds(118, 6, 86, 20);
		txtIdEgzemplarza.setText("ID Egzemplarza");
		panRezerwacje.add(txtIdEgzemplarza);
		txtIdEgzemplarza.setColumns(10);
		
		txtDataRozpoczcia = new JTextField();
		txtDataRozpoczcia.setBounds(214, 6, 86, 20);
		txtDataRozpoczcia.setText("Data rozpoczęcia");
		panRezerwacje.add(txtDataRozpoczcia);
		txtDataRozpoczcia.setColumns(10);
		
		txtDataZwrotu = new JTextField();
		txtDataZwrotu.setBounds(310, 6, 86, 20);
		txtDataZwrotu.setText("Data zwrotu");
		panRezerwacje.add(txtDataZwrotu);
		txtDataZwrotu.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setBounds(406, 5, 86, 23);
		panRezerwacje.add(btnDodaj);
		
		table = new JTable();
		table.setBounds(22, 34, 470, 148);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		panRezerwacje.add(table);
		
		JPanel panKlienci = new JPanel();
		tabbedPane.addTab("Klienci", null, panKlienci, null);
		
		JPanel panSprzet = new JPanel();
		tabbedPane.addTab("Sprzęt", null, panSprzet, null);
		
		JPanel panZestawy = new JPanel();
		tabbedPane.addTab("Zestawy", null, panZestawy, null);
		frame.getContentPane().add(tabbedPane);
	}

}
