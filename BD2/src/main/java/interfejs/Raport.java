package interfejs;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.SprzetEntity;
import BazyDanychProjekt.BD2.WypozyczeniaArchiwumEntity;
import BazyDanychProjekt.BD2.WypozyczeniaEntity;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class Raport extends JPanel {

	boolean x = false; 
	private JPanel Y;
	private JPanel raport;
	private DataBaseController mController;
	
	/**
	 * Create the panel.
	 */
	public Raport() {
		setLayout(null);
		Y = this;
		mController = new DataBaseController();
		raport = null;
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 620, 25);
		add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Aktywność Klientów"}));
		comboBox.setBounds(0, 2, 519, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Pokaż");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> nazwiska = new ArrayList<>();
				ArrayList<Long> ilosci = new ArrayList<>();
				List<Object[]> test = (List<Object[]>)mController.executeQuery("select k.nazwisko, count(w.id) from WypozyczeniaEntity w, KlienciEntity k where w.klienci.pesel = k.pesel group by k.nazwisko");
				
				for (Object[] o : test) {
					nazwiska.add((String)o[0]);
					ilosci.add((Long)o[1]);
				}
				
				if(raport != null){
					remove(raport);
				}
				
				raport = createDemoPanel(nazwiska, ilosci, null);
				raport.setBounds(10, 38, 620, 460);
				add(raport);
				repaint();
				
			}
		});
		btnNewButton.setBounds(529, 1, 89, 23);
		panel.add(btnNewButton);
	}

	private static PieDataset createDataset(List String, List Long) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(int i=0; i<String.size();i++){
        	dataset.setValue((Comparable) (String.get(i)) + " " + Long.get(i).toString(), (Number) Long.get(i));
        }
        return dataset;  
    }
	
private static JFreeChart createChart(PieDataset dataset, String title) {
        
        JFreeChart chart = ChartFactory.createPieChart(
            title,  			// chart title
            dataset,            // data
            true,               // include legend
            true,
            false
        );

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setSectionOutlinesVisible(false);
        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        plot.setNoDataMessage("No data available");
        plot.setCircular(false);
        plot.setLabelGap(0.02);
        return chart;
        
    }

	public static JPanel createDemoPanel(List String, List Long, String title) {
		JFreeChart chart = createChart(createDataset(String, Long), title);
		return new ChartPanel(chart);
	}
}
