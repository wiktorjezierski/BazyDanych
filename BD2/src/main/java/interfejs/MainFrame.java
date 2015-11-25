package interfejs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.ListSelectionModel;

public class MainFrame {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel tabPracownicy = new JPanel();
		tabbedPane.addTab("Pracownicy", null, tabPracownicy, "zarządzaj pracownikami");
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"94022214550", "Piotr", "\u0141awniczak", "22.11.2015", "false"},
				{null, null, null, null, null},
			},
			new String[] {
				"PESEL", "Imi\u0119", "Nazwisko", "Rozpocz\u0119cie pracy", "Zwolniony"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(99);
		table.setColumnSelectionAllowed(true);
		tabPracownicy.add(table);
		
		JPanel tabKlienci = new JPanel();
		FlowLayout fl_tabKlienci = (FlowLayout) tabKlienci.getLayout();
		tabbedPane.addTab("Klienci", null, tabKlienci, "zarządzaj klientami");
		
		JPanel tabRezerwacje = new JPanel();
		tabbedPane.addTab("Rezerwacje", null, tabRezerwacje, null);
		
		JPanel tabFaktury = new JPanel();
		tabbedPane.addTab("Faktury", null, tabFaktury, null);
		
		JPanel tabSprzet = new JPanel();
		tabbedPane.addTab("Sprzęt", null, tabSprzet, null);
	}

}
