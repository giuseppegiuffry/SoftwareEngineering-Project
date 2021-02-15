package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import domain.Tabellone;

public class GiocoDellOcaFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JPanel backgroundPanel = new JPanel();
	public JComboBox<Integer> comboBoxGiocatori = new JComboBox<>();
	public JTextField[] textBoxGiocatori;
	public JLabel[] labelGiocatori;
	private JButton bottoneGioca = new JButton("Gioca");
	public JButton bottoneEsci = new JButton("Esci");
	private static int numMaxGiocatori = 6;
	public int numeroGiocatori;
	public JPanel tabellonePanel = new JPanel();
	public Tabellone tabellone;
	
	public GiocoDellOcaFrame() {
		setTitle("Simulazione Gioco dell'Oca");
		setSize(400, (110 + 55 * numMaxGiocatori));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		backgroundPanel.setBackground(Color.white);
		backgroundPanel.setLayout(new GridBagLayout());
		
		// combobox per il numero di giocatori
		for(int i = 2; i < numMaxGiocatori + 1; i++)
			comboBoxGiocatori.addItem(i);
		comboBoxGiocatori.setForeground(Color.blue);
		comboBoxGiocatori.setPreferredSize(new Dimension(50, 20));
		comboBoxGiocatori.addActionListener(new ComboBoxGiocatoriListener(this));
				
		// label e textbox per i nomi dei giocatori
		textBoxGiocatori = new JTextField[numMaxGiocatori];
		labelGiocatori = new JLabel[numMaxGiocatori];
		for(int i = 0; i < textBoxGiocatori.length; i++) {
			labelGiocatori[i] = new JLabel("Giocatore " + (i + 1) + " : ");
			textBoxGiocatori[i] = new JTextField("");
			textBoxGiocatori[i].setFont(new Font("Arial", Font.BOLD, 12));
			textBoxGiocatori[i].setPreferredSize(new Dimension(80, 20));
			if(i > 1) {
				textBoxGiocatori[i].setEnabled(false);
				labelGiocatori[i].setForeground(Color.LIGHT_GRAY);
			}
		}
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		
		backgroundPanel.add(new JLabel("Numero di giocatori :"), gbc);
		gbc.gridx = 3;
		gbc.gridwidth = 1;
		backgroundPanel.add(comboBoxGiocatori, gbc);
		
		gbc.gridx = 0;
		gbc.gridy++;
		backgroundPanel.add(new JLabel(" "), gbc);
		gbc.gridy++;
		backgroundPanel.add(new JLabel(" "), gbc);
		
		gbc.gridy += 1;
		gbc.gridwidth = 2;
		for(int i = 1; i < numMaxGiocatori + 1; i++) {
			gbc.gridx = 0;
			backgroundPanel.add(labelGiocatori[i-1], gbc);
			gbc.gridx = 2;
			backgroundPanel.add(textBoxGiocatori[i-1], gbc);
			gbc.gridy++;
			backgroundPanel.add(new JLabel(" "), gbc);
			gbc.gridy++;
		}
		
		gbc.gridx = 0;
		gbc.gridy++;
		backgroundPanel.add(new JLabel(" "), gbc);
		gbc.gridy++;
		backgroundPanel.add(new JLabel(" "), gbc);
		gbc.gridy++;
		backgroundPanel.add(bottoneGioca, gbc);
		gbc.gridx = 3;
		backgroundPanel.add(bottoneEsci, gbc);
		
		bottoneEsci.addActionListener(new BottoneEsciListener());
		
		setContentPane(backgroundPanel);
		setVisible(true);
		
	}

	

}
