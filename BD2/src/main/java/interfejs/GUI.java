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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{531, 0};
		gridBagLayout.rowHeights = new int[]{217, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(new Rectangle(600, 600));
		
		JPanel panPracownicy = new JPanel();
		tabbedPane.addTab("Pracownicy", null, panPracownicy, null);
		panPracownicy.setLayout(null);
		
		tablePracownicy = new JTable();
		tablePracownicy.setBounds(0, 8, 469, 160);
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
		btnNewButton.setBounds(469, 49, 57, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
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
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.anchor = GridBagConstraints.NORTH;
		gbc_tabbedPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		frame.getContentPane().add(tabbedPane, gbc_tabbedPane);
	}

}
