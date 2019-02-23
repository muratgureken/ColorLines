import javax.swing.JFrame;

import gui.FlowFree;
import gui.MouseEventController;

public class Runner {

	public static void main(String[] args) {
        FlowFree frame = new FlowFree();
        frame.setVisible(true);
        frame.setSize(600, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
