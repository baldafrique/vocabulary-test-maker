import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GInput implements ActionListener {
	Frame inputFrame;
	TextField textField;
	Button button;
	File file;
	FileWriter fileWriter;
	BufferedWriter bufferedWriter;
	
	public GInput() throws IOException {
		file = new File("data");
		fileWriter = new FileWriter(file, true);
		bufferedWriter = new BufferedWriter(fileWriter);
		
		inputFrame = new Frame("Vocabulary Test");
		textField = new TextField(20);
		textField.addActionListener(this);
		button = new Button("finish input");
		button.addActionListener(this);
		
		Image image = inputFrame.getToolkit().getImage("icon.png");
		inputFrame.setIconImage(image);
		
		inputFrame.setLayout(new FlowLayout());
		inputFrame.add(textField);
		inputFrame.add(button);
		inputFrame.setSize(300, 100);
		inputFrame.setLocationRelativeTo(null);
		inputFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == button) {
				bufferedWriter.close();
				new GMain();
				inputFrame.setVisible(false);
			}
			else {
				bufferedWriter.write(textField.getText() + "\n");
				textField.setText("");
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
