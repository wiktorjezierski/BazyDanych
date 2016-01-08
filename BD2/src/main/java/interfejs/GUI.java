package interfejs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {

	JFrame frmWypoyczalniaSprztuSpotowego;
	Logowanie logowanieFrame;
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
		logowanieFrame = new Logowanie();
		frmWypoyczalniaSprztuSpotowego = new JFrame();
		frmWypoyczalniaSprztuSpotowego.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
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

		
		JPanel panSprzet = new Sprzet(this);
		tabbedPane.addTab("Sprzęt", null, panSprzet, null);
		panSprzet.setLayout(null);
		
		JPanel panZestawy = new Zestawy();
		tabbedPane.addTab("Zestawy", null, panZestawy, null);
		
		frmWypoyczalniaSprztuSpotowego.getContentPane().add(tabbedPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmWypoyczalniaSprztuSpotowego.setJMenuBar(menuBar);
		
		JMenu mnFsd = new JMenu("Plik");
		menuBar.add(mnFsd);
		
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
		
		JMenuItem mntmWyloguj = new JMenuItem("Wyloguj");
		mntmWyloguj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logowanieFrame.frmZaloguj.setLocationRelativeTo(null);
				logowanieFrame.frmZaloguj.setVisible(true);
				frmWypoyczalniaSprztuSpotowego.dispose();
			}
		});
		mnSesja.add(mntmWyloguj);
		
		JMenu mnPomoc = new JMenu("Pomoc");
		menuBar.add(mnPomoc);
		
		JMenuItem mntmPomoc = new JMenuItem("Pomoc");
		mntmPomoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aboutDialog.txtrZostaNapisanyNa.setText("W przypadku błędów i uwag \r\nco do funkcjonalności aplikacji\r\nproszę kontaktować się z Piotrem:\r\ntel.: 604 322 312");
				aboutDialog.setVisible(true);
			}
		});
		mnPomoc.add(mntmPomoc);
		
		JMenuItem mntmOProgramie = new JMenuItem("O programie");
		mntmOProgramie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutDialog.txtrZostaNapisanyNa.setText("Program został napisany na potrzeby projektu \r\nz przedmiotu Bazy Danych \r\nprzez Wiktora Jezierskiego i Piotra Ławniczaka");
				aboutDialog.setVisible(true);
			}
		});
		mnPomoc.add(mntmOProgramie);
	}
}
