package interfejs;

import java.awt.BorderLayout;
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
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

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
		frmWypoyczalniaSprztuSpotowego.getContentPane().setLayout(new BorderLayout(10, 10));
		frmWypoyczalniaSprztuSpotowego.setTitle("Wypożyczalnia sprzętu spotowego (0.1)");
		frmWypoyczalniaSprztuSpotowego.setBounds(100, 100, 659, 417);
		frmWypoyczalniaSprztuSpotowego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OProgramie aboutDialog = new OProgramie();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		//tabbedPane.setVisible(false);
		tabbedPane.setBounds(new Rectangle(0, 0, 647, 385));
		
		JPanel panPracownicy = new Pracownicy();
		tabbedPane.addTab("Pracownicy", null, panPracownicy, null);

		JPanel panRezerwacje = new Rezerwacje();
		tabbedPane.addTab("Rezerwacje", null, panRezerwacje, null);
		
		JPanel panKlienci = new Klienci();
		tabbedPane.addTab("Klienci", null, panKlienci, null);

		
		JPanel panSprzet = new Sprzet();
		tabbedPane.addTab("Sprzęt", null, panSprzet, null);
		panSprzet.setLayout(null);
		
		JPanel panZestawy = new Zestawy();
		tabbedPane.addTab("Zestawy", null, panZestawy, null);
		
		frmWypoyczalniaSprztuSpotowego.getContentPane().add(tabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmWypoyczalniaSprztuSpotowego.setJMenuBar(menuBar);
		
		JMenu mnFsd = new JMenu("Plik");
		menuBar.add(mnFsd);
		
		JMenuItem mntmOtwrz = new JMenuItem("Otwórz");
		mnFsd.add(mntmOtwrz);
		
		JMenuItem mntmWyjcie = new JMenuItem("Wyjście");
		mntmWyjcie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mnFsd.add(mntmWyjcie);
		
		JMenu mnEdycja = new JMenu("Edycja");
		menuBar.add(mnEdycja);
		
		JMenuItem mntmWytnij = new JMenuItem("Wytnij");
		mnEdycja.add(mntmWytnij);
		
		JMenuItem mntmKopiuj = new JMenuItem("Kopiuj");
		mnEdycja.add(mntmKopiuj);
		
		JMenuItem mntmWklej = new JMenuItem("Wklej");
		mnEdycja.add(mntmWklej);
		
		JMenu mnSesja = new JMenu("Sesja");
		menuBar.add(mnSesja);
		
		JMenuItem mntmZaloguj = new JMenuItem("Zaloguj");
		mnSesja.add(mntmZaloguj);
		
		JMenuItem mntmWyloguj = new JMenuItem("Wyloguj");
		mnSesja.add(mntmWyloguj);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmPomoc = new JMenuItem("Pomoc");
		mnPomoc.add(mntmPomoc);
		
		JMenuItem mntmOProgramie = new JMenuItem("O programie");
		mntmOProgramie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				aboutDialog.setVisible(true);
			}
		});
		mnPomoc.add(mntmOProgramie);
	}
}
