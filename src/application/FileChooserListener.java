package application;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

public class FileChooserListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == JFileChooser.CANCEL_SELECTION)
			System.out.println("We got a cancel");

	}

}
