package interfejs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BazyDanychProjekt.BD2.SprzetEntity;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class SprzetAktualizacja extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textNazwa;
	private JTextField textMarka;
	private JTextField textKategoria;
	private JTextField textDataZakupu;
	private JButton okButton;
	private JFrame frame;
	private SprzetEntity mSprzet;
	boolean ready = false;
	

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		try {
//			SprzetAktualizacja dialog = new SprzetAktualizacja();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public SprzetAktualizacja(JFrame fr) {
		setModal(true);
		frame = fr;
		setTitle("Aktualizacja Sprzętu");
		setBounds(100, 100, 267, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNazwa = new JLabel("Nazwa");
		lblNazwa.setBounds(10, 37, 46, 14);
		contentPanel.add(lblNazwa);
		
		JLabel lblMarka = new JLabel("Marka");
		lblMarka.setBounds(10, 64, 46, 14);
		contentPanel.add(lblMarka);
		
		JLabel lblKategoria = new JLabel("Kategoria");
		lblKategoria.setBounds(10, 89, 46, 14);
		contentPanel.add(lblKategoria);
		
		JLabel lblDataZakupu = new JLabel("Data zakupu");
		lblDataZakupu.setBounds(10, 114, 68, 14);
		contentPanel.add(lblDataZakupu);
		
		textNazwa = new JTextField();
		textNazwa.setBounds(102, 34, 86, 20);
		contentPanel.add(textNazwa);
		textNazwa.setColumns(10);
		
		textMarka = new JTextField();
		textMarka.setBounds(102, 61, 86, 20);
		contentPanel.add(textMarka);
		textMarka.setColumns(10);
		
		textKategoria = new JTextField();
		textKategoria.setBounds(102, 86, 86, 20);
		contentPanel.add(textKategoria);
		textKategoria.setColumns(10);
		
		textDataZakupu = new JTextField();
		textDataZakupu.setBounds(102, 111, 86, 20);
		contentPanel.add(textDataZakupu);
		textDataZakupu.setColumns(10);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		{
			okButton = new JButton("OK");
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String testDate = textDataZakupu.getText();
					DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					try {
						mSprzet.setDataZakupu(formatter.parse(testDate));
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					
					mSprzet.setNazwa(textNazwa.getText());
					mSprzet.setMarka(textMarka.getText());
					mSprzet.setKategoria(textKategoria.getText());
					ready = true;
					setVisible(false);
//					dispose();
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
					ready = false;
//					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);
		}
	}
	
	private void setDefaultValue(){
		textNazwa.setText(mSprzet.getNazwa());
		textMarka.setText(mSprzet.getMarka());
		textKategoria.setText(mSprzet.getKategoria());
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		textDataZakupu.setText(formatter.format(mSprzet.getDataZakupu()));
	}

	public SprzetEntity getSprzet() {
		return mSprzet;
	}

	public void setSprzet(SprzetEntity mSprzet) {
		this.mSprzet = mSprzet;
		setDefaultValue();
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
	
}
