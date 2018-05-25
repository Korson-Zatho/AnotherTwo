package application;

import java.awt.Color;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * View-Controller for the person table.
 * 
 * @author Marco Jakob
 */
public class EventHandlingController implements Initializable {

	@FXML
	private Button myButton;

	/**
	 * The constructor (is called before the initialize()-method).
	 */
	public EventHandlingController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

	}

	@FXML
	private javafx.scene.control.Button LoadButton;

	@FXML
	private void handleButtonAction(ActionEvent event) {
		// Button was clicked, do something...
		File myIMG = getImageFileFromUser();
	}

	@FXML
	private javafx.scene.control.Button closeButton;

	@FXML
	private void handleExitButtonAction(ActionEvent event) {
		// Button was clicked, do something: end it all
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@SuppressWarnings("deprecation")
	public File getImageFileFromUser() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("jpg", "png"));
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		fileChooser.setBackground(new Color(100, 100, 100));
		fileChooser.addActionListener(new FileChooserListener());
		JFrame parent = new JFrame("this is a test");
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parent.setVisible(true);

		int result = fileChooser.showOpenDialog(parent);
		parent.show();

		if (result == JFileChooser.APPROVE_OPTION) {
			File res = fileChooser.getSelectedFile();
			parent.dispose();
			return res;
		} else
			parent.dispose();
		return null;
	}

	public static void endthis() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}