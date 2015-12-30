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

public class WybierzProducentaDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField txtMiasto;
	private DataBaseController mController;
	public ProducentEntity mProducent;
	private List<ProducentEntity> lista;

	/**
	 * Create the dialog.
	 */
	public WybierzProducentaDialog(JFrame frame) {
		mController = new DataBaseController();
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			table = new JTable();
			table.setBounds(67, 10, 300, 208);
			table.setModel(
					new DefaultTableModel(
							new Object[][] { { null, null, null, null }, { null, null, null, null },
									{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
									{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
									{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
									{ null, null, null, null }, { null, null, null, null } },
							new String[] { "ID", "Nazwa", "Miasto", "Telefon" }));
			contentPanel.add(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				txtMiasto = new JTextField();
				txtMiasto.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent arg0) {
						setContent();
					}
				});
				txtMiasto.addFocusListener(new FocusAdapter() {
					@Override
					public void focusGained(FocusEvent arg0) {
						if (txtMiasto.getText().equals("Nazwa")) {
							txtMiasto.setText("");
						}
					}

					@Override
					public void focusLost(FocusEvent e) {
						if (txtMiasto.getText().equals("")) {
							txtMiasto.setText("Nazwa");
						}
					}
				});
				txtMiasto.setText("Nazwa");
				buttonPane.add(txtMiasto);
				txtMiasto.setColumns(10);
			}
			{
				JButton okButton = new JButton("OK");
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
