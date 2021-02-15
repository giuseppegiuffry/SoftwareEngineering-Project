package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BottoneEsciListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int scelta = JOptionPane.showConfirmDialog(null, "Sei sicuro di voler uscire?", "Conferma", JOptionPane.YES_NO_OPTION);
        if(scelta == JOptionPane.YES_OPTION)
            System.exit(0);
	}

}
