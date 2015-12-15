package interfejs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class OProgramie extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public OProgramie() {
		setTitle("O programie");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JTextArea txtrZostaNapisanyNa = new JTextArea();
		txtrZostaNapisanyNa.setBackground(Color.BLACK);
		txtrZostaNapisanyNa.setWrapStyleWord(true);
		txtrZostaNapisanyNa.setFont(new Font("Segoe UI", Font.ITALIC, 19));
		txtrZostaNapisanyNa.setEnabled(false);
		txtrZostaNapisanyNa.setEditable(false);
		txtrZostaNapisanyNa.setText("Program został napisany na potrzeby projektu \r\nz przedmiotu Bazy Danych \r\nprzez Wiktora Jezierskiego i Piotra Ławniczaka");
		txtrZostaNapisanyNa.setBounds(10, 11, 414, 206);
		contentPanel.add(txtrZostaNapisanyNa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(new Color(255, 255, 255));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
