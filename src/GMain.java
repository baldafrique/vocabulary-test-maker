import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class GMain implements ActionListener, WindowListener {
	Frame mainFrame;
	Button input;
	Button test;
	
	public GMain() {
		mainFrame = new Frame("Vocabulary Test");
		input = new Button("Input");
		input.addActionListener(this);
		test = new Button("Test");
		test.addActionListener(this);
		
		mainFrame.setLayout(new FlowLayout());
		mainFrame.add(input);
		mainFrame.add(test);
		
		Image image = mainFrame.getToolkit().getImage("icon.png");
		mainFrame.setIconImage(image);
		mainFrame.setSize(300, 100);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		mainFrame.addWindowListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == input) {
				new GInput();
			}
			else {
				new GTest();
			}
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		
		mainFrame.setVisible(false);
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
	
	public static void main(String[] args) {
		new GMain();
	}

}
