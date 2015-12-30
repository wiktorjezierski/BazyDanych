package interfejs;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WyborProducenta extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtNazwa;
	public String x = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WyborProducenta frame = new WyborProducenta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WyborProducenta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 424, 224);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, },
				new String[] { "ID", "Nazwa", "Miasto", "Telefon" }));
		scrollPane.setViewportView(table);

		txtNazwa = new JTextField();
		txtNazwa.setText("Nazwa");
		txtNazwa.setBounds(114, 7, 198, 20);
		contentPane.add(txtNazwa);
		txtNazwa.setColumns(10);

		JButton btnWybierz = new JButton("Wybierz");
		btnWybierz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				x = "zakonczono";
				dispose();
			}
		});
		btnWybierz.setBounds(335, 6, 89, 23);
		contentPane.add(btnWybierz);
	}
}
