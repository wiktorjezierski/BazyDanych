package interfejs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BazyDanychProjekt.ApplicationFunction.SprzetAF;
import BazyDanychProjekt.BD2.ProducentEntity;
import BazyDanychProjekt.BD2.SprzetEntity;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class DodajSprzet extends JDialog {

	SprzetAF mSprzet;
	private JFrame frame;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNazwa;
	private JTextField txtMarka;
	private JTextField txtKategoria;
	private JTextField txtData;
	private JTextField txtSztuk;
	private ProducentEntity pr;
	private JButton btnWybierzProducenta;
	private boolean entry_added;

	private void resetujFormularz(){
		txtNazwa.setText(null);
		txtMarka.setText(null);
		txtKategoria.setText(null);
		txtSztuk.setText(null);
		txtData.setText(null);
		btnWybierzProducenta.setText("Wybierz Producenta");
	}

	public boolean isEntryAdded(){
		return entry_added;
	}
	
	public DodajSprzet(JFrame fr) {
		frame = fr;
		mSprzet = new SprzetAF();
		entry_added = false;
		setModal(true);
		setTitle("Dodawanie Sprzętu");
		setBounds(100, 100, 344, 370);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNazwa = new JLabel("Nazwa*");
		lblNazwa.setBounds(29, 48, 83, 14);
		contentPanel.add(lblNazwa);
		
		JLabel lblMarka = new JLabel("Marka*");
		lblMarka.setBounds(29, 73, 65, 14);
		contentPanel.add(lblMarka);
		
		JLabel lblProducent = new JLabel("Producent*");
		lblProducent.setBounds(29, 98, 83, 14);
		contentPanel.add(lblProducent);
		
		JLabel lblKategoria = new JLabel("Kategoria*");
		lblKategoria.setBounds(29, 123, 83, 14);
		contentPanel.add(lblKategoria);
		
		JLabel lblDataZakupu = new JLabel("Data zakupu*");
		lblDataZakupu.setBounds(29, 148, 83, 14);
		contentPanel.add(lblDataZakupu);
		
		JLabel lblLiczbaSztuk = new JLabel("Liczba sztuk*");
		lblLiczbaSztuk.setBounds(29, 173, 83, 14);
		contentPanel.add(lblLiczbaSztuk);
		
		txtNazwa = new JTextField();
		txtNazwa.setBounds(135, 45, 183, 20);
		contentPanel.add(txtNazwa);
		txtNazwa.setColumns(10);
		
		txtMarka = new JTextField();
		txtMarka.setBounds(135, 70, 183, 20);
		contentPanel.add(txtMarka);
		txtMarka.setColumns(10);
		
		txtKategoria = new JTextField();
		txtKategoria.setBounds(135, 120, 183, 20);
		contentPanel.add(txtKategoria);
		txtKategoria.setColumns(10);
		
		txtData = new JTextField();
		txtData.setBounds(135, 145, 183, 20);
		contentPanel.add(txtData);
		txtData.setColumns(10);
		
		txtSztuk = new JTextField();
		txtSztuk.setBounds(135, 170, 183, 20);
		contentPanel.add(txtSztuk);
		txtSztuk.setColumns(10);
		
		btnWybierzProducenta = new JButton("Wybierz Producenta");
		btnWybierzProducenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pr = mSprzet.wybierzProducenta(frame);
				btnWybierzProducenta.setText(pr.getNazwa());
			}
		});
		btnWybierzProducenta.setBounds(135, 94, 183, 23);
		contentPanel.add(btnWybierzProducenta);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						entry_added = false;
						
						SprzetEntity sp = new SprzetEntity();

						String testDate = txtData.getText();
						DateFormat formatter = new SimpleDateFormat("yyyy-MM-d");
						try {
							sp.setDataZakupu(formatter.parse(testDate));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						String kategoria = new String(txtKategoria.getText());
						String marka = new String(txtMarka.getText());
						String nazwa = new String(txtNazwa.getText());
						String ilosc = new String(txtSztuk.getText());
						
						if (kategoria.equals("") || marka.equals("") || nazwa.equals("") || ilosc.equals(""))
							JOptionPane.showMessageDialog(null, "Nie podano wszystkich obowiązkowych pól.");
						else {
							sp.setKategoria(kategoria);
							sp.setMarka(marka);
							sp.setNazwa(nazwa);
							sp.setIlosc(Integer.parseInt(ilosc));
							sp.setDostepnych(Integer.parseInt(ilosc));
						
							if (pr != null) {
								sp.setProducent(pr);
								boolean test = mSprzet.dodaj(sp);
								if (test) {
									JOptionPane.showMessageDialog(null, "Dodano");
									entry_added = true;
									resetujFormularz();
									
							} 
							else
								JOptionPane.showMessageDialog(null, "Wystąpił błąd podczas zapisu, spróbuj później", "Błąd!", JOptionPane.ERROR_MESSAGE);
							
						}
						else
							JOptionPane.showMessageDialog(null, "Błędny numer producenta.", "Błąd!", JOptionPane.ERROR_MESSAGE);
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Anuluj");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						entry_added = true;
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
