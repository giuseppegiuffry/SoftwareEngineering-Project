package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxGiocatoriListener implements ActionListener {
	
	private GiocoDellOcaFrame GdOFrame;
	
	public ComboBoxGiocatoriListener(GiocoDellOcaFrame GdOFrame) {
		this.GdOFrame = GdOFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 2; i < (Integer)GdOFrame.comboBoxGiocatori.getSelectedItem(); i++) {
			GdOFrame.textBoxGiocatori[i].setEnabled(true);
			GdOFrame.labelGiocatori[i].setForeground(Color.BLACK);
        }
		
		for(int i = (Integer)GdOFrame.comboBoxGiocatori.getSelectedItem(); i < GdOFrame.textBoxGiocatori.length; i++) {
			GdOFrame.textBoxGiocatori[i].setEnabled(false);
			GdOFrame.labelGiocatori[i].setForeground(Color.LIGHT_GRAY);
        }
		
	}

}
