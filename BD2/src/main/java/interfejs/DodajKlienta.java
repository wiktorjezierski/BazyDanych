package interfejs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DodajKlienta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPeselKlienta;
	private JTextField txtImie;
	private JTextField txtNaziwsko;
	private JTextField txtNrDowodu;
	private JTextField txtTelefon;


	public void setTxtPeselKlienta(JTextField txtPeselKlienta) {
		this.txtPeselKlienta.setText(txtPeselKlienta.getText());
	}
	
	public DodajKlienta() {
		setTitle("Dodawanie Klienta");
		setBounds(100, 100, 323, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtPeselKlienta = new JTextField();
			txtPeselKlienta.setBounds(127, 11, 162, 20);
			contentPanel.add(txtPeselKlienta);
			txtPeselKlienta.setColumns(10);
		}
		
		JLabel lblPeselKlienta = new JLabel("Pesel Klienta:");
		lblPeselKlienta.setBounds(10, 14, 77, 14);
		contentPanel.add(lblPeselKlienta);
		
		JLabel lblNewLabel = new JLabel("Imię:");
		lblNewLabel.setBounds(10, 39, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNazwisko = new JLabel("Nazwisko:");
		lblNazwisko.setBounds(10, 64, 60, 14);
		contentPanel.add(lblNazwisko);
		
		JLabel lblNewLabel_1 = new JLabel("Numer dowodu:");
		lblNewLabel_1.setBounds(10, 89, 103, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Numer telefonu:");
		lblNewLabel_2.setBounds(10, 114, 103, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblUwagi = new JLabel("Uwagi:");
		lblUwagi.setBounds(10, 139, 60, 14);
		contentPanel.add(lblUwagi);
		
		txtImie = new JTextField();
		txtImie.setBounds(127, 36, 162, 20);
		contentPanel.add(txtImie);
		txtImie.setColumns(10);
		
		txtNaziwsko = new JTextField();
		txtNaziwsko.setBounds(127, 61, 162, 20);
		contentPanel.add(txtNaziwsko);
		txtNaziwsko.setColumns(10);
		
		txtNrDowodu = new JTextField();
		txtNrDowodu.setBounds(127, 86, 162, 20);
		contentPanel.add(txtNrDowodu);
		txtNrDowodu.setColumns(10);
		
		txtTelefon = new JTextField();
		txtTelefon.setBounds(127, 111, 162, 20);
		contentPanel.add(txtTelefon);
		txtTelefon.setColumns(10);
		
		JTextPane txtUwagi = new JTextPane();
		txtUwagi.setBounds(127, 139, 162, 78);
		contentPanel.add(txtUwagi);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String pesel = txtPeselKlienta.getText();
						String imie = txtImie.getText();
						String nazwisko = txtNaziwsko.getText();
						String nrDowodu = txtNrDowodu.getText();
						String telefon = txtTelefon.getText();
						String uwagi = txtUwagi.getText();
						
						//mKlienci.dodaj(new Klient(pesel, imie, nazwisko, nrDowodu, telefon, uwagi));
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}