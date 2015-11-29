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

	private JFrame frmWypoyczalniaSprztuSpotowego;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmWypoyczalniaSprztuSpotowego.setVisible(true);
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
		frmWypoyczalniaSprztuSpotowego = new JFrame();
		frmWypoyczalniaSprztuSpotowego.setTitle("Wypożyczalnia sprzętu spotowego (0.1)");
		frmWypoyczalniaSprztuSpotowego.setBounds(100, 100, 659, 417);
		frmWypoyczalniaSprztuSpotowego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(new Rectangle(0, 0, 647, 385));
		
		JPanel panPracownicy = new Pracownicy();
		tabbedPane.addTab("Pracownicy", null, panPracownicy, null);

		JPanel panRezerwacje = new Rezerwacje();
		tabbedPane.addTab("Rezerwacje", null, panRezerwacje, null);
		
		JPanel panKlienci = new Klienci();
		tabbedPane.addTab("Klienci", null, panKlienci, null);

		
		JPanel panSprzet = new Sprzet();
		tabbedPane.addTab("Sprzęt", null, panSprzet, null);
		
		JPanel panZestawy = new Zestawy();
		tabbedPane.addTab("Zestawy", null, panZestawy, null);
		
		frmWypoyczalniaSprztuSpotowego.getContentPane().add(tabbedPane);
	}
}
