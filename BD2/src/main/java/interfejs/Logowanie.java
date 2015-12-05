package interfejs;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import BazyDanychProjekt.ApplicationFunction.LogowanieAF;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Logowanie {
	GUI window = new GUI();
	private JFrame frmZaloguj;
	private LogowanieAF logowanko;
	private JPasswordField passwordField;
	private JButton btnZaloguj;
	private JTextPane textPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logowanie window = new Logowanie();
					window.frmZaloguj.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	KeyAdapter keyAdapter = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == 9){
				passwordField.requestFocus();
			}
			frmZaloguj.getRootPane().setDefaultButton(btnZaloguj);	
		}
	};
	
	/**
	 * Create the application.
	 */
	public Logowanie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmZaloguj = new JFrame();
		frmZaloguj.setTitle("Zaloguj się do systemu");
		frmZaloguj.setBounds(100, 100, 357, 195);
		frmZaloguj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmZaloguj.getContentPane().setLayout(null);
		
		logowanko = new LogowanieAF();
		
		textPane = new JTextPane();
		textPane.setBounds(105, 11, 124, 30);
		frmZaloguj.getContentPane().add(textPane);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(105, 56, 124, 30);
		frmZaloguj.getContentPane().add(passwordField);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(66, 11, 39, 30);
		frmZaloguj.getContentPane().add(lblLogin);
		
		JLabel lblHaso = new JLabel("Hasło:");
		lblHaso.setBounds(66, 56, 46, 30);
		frmZaloguj.getContentPane().add(lblHaso);
		
		btnZaloguj = new JButton("Zaloguj");
		btnZaloguj.addActionListener(zaloguj);
		btnZaloguj.setBounds(105, 97, 124, 42);
		frmZaloguj.getContentPane().add(btnZaloguj);
		
		textPane.addKeyListener(keyAdapter);
	}
	
	ActionListener zaloguj = new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			boolean logowanie = logowanko.zaloguj(textPane.getText().trim(), passwordField.getText());
			if (logowanie){
				frmZaloguj.setVisible(false);
				window.frmWypoyczalniaSprztuSpotowego.setVisible(true);
			}
				
		}
	};
}