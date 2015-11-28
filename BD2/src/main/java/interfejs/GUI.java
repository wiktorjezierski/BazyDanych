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
import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class GUI {

	private JFrame frame;
	private JTable tablePracownicy;
	private JTextField txtDataZwrotu;
	private JTextField txtPeselKlienta;
	private JTextField txtDataRozpoczcia;
	private JTextField txtIdEgzemplarza;
	private JTable tableRezerwacje;
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
		frame.setBounds(100, 100, 559, 299);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(new Rectangle(0, 0, 531, 242));
		
		JPanel panPracownicy = new JPanel();
		tabbedPane.addTab("Pracownicy", null, panPracownicy, null);
		panPracownicy.setLayout(null);
		
		JScrollPane scrollPanePracownicy = new JScrollPane();
		scrollPanePracownicy.setBounds(30, 9, 469, 160);
		panPracownicy.add(scrollPanePracownicy);
		
		tablePracownicy = new JTable();
		scrollPanePracownicy.setViewportView(tablePracownicy);
		tablePracownicy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePracownicy.setModel(new DefaultTableModel(
			new Object[][] {
				{"94022214550", "Piotr", "\u0141awniczak", "22.11.2015", "true"},
				{"93012132442", "Wiktor", "Jezierski", "27.11.2015", "true"},
				{"77083044329", "Rozb\u00F3jnik", "Alibaba", "11.02.2004", "false"},
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
		
		JButton btnNewButton = new JButton("Usuń");
		btnNewButton.setBounds(30, 180, 71, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().setLayout(null);
		panPracownicy.add(btnNewButton);
		
		JButton btnDodaj_1 = new JButton("Dodaj");
		btnDodaj_1.setBounds(410, 180, 89, 23);
		panPracownicy.add(btnDodaj_1);
		
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
		
		JButton btnNewButton_1 = new JButton("Cofnij rezerwację");
		btnNewButton_1.setBounds(349, 183, 143, 23);
		panRezerwacje.add(btnNewButton_1);
		
		JScrollPane scrollPaneRezerwacje = new JScrollPane();
		scrollPaneRezerwacje.setBounds(22, 34, 470, 138);
		panRezerwacje.add(scrollPaneRezerwacje);
		
		tableRezerwacje = new JTable();
		scrollPaneRezerwacje.setViewportView(tableRezerwacje);
		tableRezerwacje.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Narty biegowe", "32", "22.01.2016", "28.01.2016", "Piotr", "\u0141awniczak"},
				{"2", "Sanki", "8", "20.12.2016", "21.12.2016", "Wiktor", "Jezierski"},
				{"3", "Snowboard", "1", "02.02.2017", "22.03.2017", "Wiktor", "Jezierski"},
				{"", null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Rodzaj sprz\u0119tu", "ID Egzemplarza", "Data rozpocz\u0119cia wypo\u017Cyczenia", "Data zwrotu", "Imi\u0119 pracownika", "Nazwisko pracownika"
			}
		));
		
		JPanel panKlienci = new JPanel();
		tabbedPane.addTab("Klienci", null, panKlienci, null);
		panKlienci.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 5, 452, 154);
		panKlienci.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
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
				"Pesel", "Imi\u0119", "Nazwisko", "NR Dowodu", "Liczba Transakcji"
			}
		));
		
		JPanel panSprzet = new JPanel();
		tabbedPane.addTab("Sprzęt", null, panSprzet, null);
		
		JPanel panZestawy = new JPanel();
		tabbedPane.addTab("Zestawy", null, panZestawy, null);
		frame.getContentPane().add(tabbedPane);
	}
}
