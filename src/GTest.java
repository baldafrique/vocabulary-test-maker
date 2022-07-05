import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GTest extends CMain implements ActionListener {
	Frame testFrame;
	Label label;
	TextField textField;
	ArrayList<String> arrayList;
	String word;
	String meaning;
	Random random;
	int index;
	
	public GTest() throws IOException {
		arrayList = read();
		random = new Random();
		
		testFrame = new Frame("Vocabulary Test");
		testFrame.setLayout(new BorderLayout());
		label = new Label();
		label.setAlignment(Label.CENTER);
		textField = new TextField();
		textField.addActionListener(this);
		
		readLine();
		
		testFrame.add(label, BorderLayout.NORTH);
		testFrame.add(textField, BorderLayout.SOUTH);
		
		Image image = testFrame.getToolkit().getImage("icon.png");
		testFrame.setIconImage(image);
				
		testFrame.setSize(300, 100);
		testFrame.setLocationRelativeTo(null);
		testFrame.setVisible(true);
	}
	
	public void readLine() {
		if (arrayList.size() != 0) {
			index = random.nextInt(arrayList.size());
			String data = arrayList.get(index);
			word = data.split(" ")[0];
			meaning = data.split(" ")[1];
			label.setText(word);
		}
		else {
			System.exit(0);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (textField.getText().equals(meaning)) {
			arrayList.remove(index);
			readLine();
		}
		else if (textField.getText().equals("skip")) {
			System.out.println(word + " " + meaning);
			arrayList.remove(index);
			readLine();
		}
		
		textField.setText("");
	}

}
