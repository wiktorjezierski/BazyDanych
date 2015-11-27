package interfejs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;

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
		frame.setBounds(100, 100, 559, 262);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setSize(400, 600);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		
		JPanel panPracownicy = new JPanel();
		tabbedPane.addTab("Pracownicy", null, panPracownicy, null);
		
		tablePracownicy = new JTable();
		tablePracownicy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePracownicy.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"PESEL", "Imi\u0119", "Nazwisko", "Data rozpocz\u0119cia pracy", "Zatrudniony"
			}
		));
		panPracownicy.add(tablePracownicy);
		
		JButton btnNewButton = new JButton("Usuń");
		panPracownicy.add(btnNewButton);
		
		JPanel panRezerwacje = new JPanel();
		tabbedPane.addTab("Rezerwacje", null, panRezerwacje, null);
		
		txtPeselKlienta = new JTextField();
		txtPeselKlienta.setText("PESEL Klienta");
		panRezerwacje.add(txtPeselKlienta);
		txtPeselKlienta.setColumns(10);
		
		txtIdEgzemplarza = new JTextField();
		txtIdEgzemplarza.setText("ID Egzemplarza");
		panRezerwacje.add(txtIdEgzemplarza);
		txtIdEgzemplarza.setColumns(10);
		
		txtDataRozpoczcia = new JTextField();
		txtDataRozpoczcia.setText("Data rozpoczęcia");
		panRezerwacje.add(txtDataRozpoczcia);
		txtDataRozpoczcia.setColumns(10);
		
		txtDataZwrotu = new JTextField();
		txtDataZwrotu.setText("Data zwrotu");
		panRezerwacje.add(txtDataZwrotu);
		txtDataZwrotu.setColumns(10);
		
		JButton btnDodaj = new JButton("Dodaj");
		panRezerwacje.add(btnDodaj);
		
		table = new JTable();
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
	}

}
