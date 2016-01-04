package interfejs;

import java.util.ArrayList;
import java.util.List;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.PracownicyEntity;
import BazyDanychProjekt.BD2.ProducentEntity;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class WybierzProducentaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtMiasto;
	private DataBaseController mController;
	public ProducentEntity mProducent;
	private List<ProducentEntity> lista;
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public WybierzProducentaDialog(JFrame frame) {
		setTitle("Wybierz Producenta");
		mController = new DataBaseController();
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 10, 414, 208);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setModel(
						new DefaultTableModel(
					new Object[][] {
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
					},
					new String[] {
						"ID", "Nazwa", "Miasto", "Telefon"
					}
				));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 217, 414, 33);
			contentPanel.add(buttonPane);
			{
				txtMiasto = new JTextField();
				txtMiasto.setBounds(224, 6, 126, 20);
				txtMiasto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						setContent();
					}
				});
				txtMiasto.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if (txtMiasto.getText().equals("Szukaj po nazwie...")) {
							txtMiasto.setText("");
						}
					}

					@Override
					public void focusLost(FocusEvent e) {
						if (txtMiasto.getText().equals("")) {
							txtMiasto.setText("Szukaj po nazwie...");
						}
					}
				});
				buttonPane.setLayout(null);
				txtMiasto.setText("Szukaj po nazwie...");
				buttonPane.add(txtMiasto);
				txtMiasto.setColumns(10);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setBounds(361, 5, 53, 23);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						int selectedRow = table.getSelectedRow();
						int id = (int) model.getValueAt(selectedRow, 0);

						for (ProducentEntity producentEntity : lista) {
							if (producentEntity.getId() == id) {
								mProducent = producentEntity;
								break;
							}
						}
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	private void setContent() {
		if (txtMiasto.getText().equals("")) {
			lista = mController.findAll(ProducentEntity.class);
		} else {
			lista = mController.executeNamedQueryForLike(ProducentEntity.class, "dialog", txtMiasto.getText());
		}

		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Numer", "Nazwa", "Adres", "Telefon" }));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (ProducentEntity p : lista) {
			model.addRow(new Object[] { p.getId(), p.getNazwa(), p.getAdres(), p.getTelefon() });
		}
	}

}
