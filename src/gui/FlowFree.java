package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import database.GameParameters;
import database.LabelCenters;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FlowFree extends JFrame implements MouseMotionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8640151106747724889L;
	private JPanel leftPanel = new JPanel(null);
	int boxSize=50;
	//private JPanel rightPanel = new JPanel(null);
	//JLabel dropLabel;
	JLabel[] kutular = new JLabel[25];

	public FlowFree() {
		//this.setLayout(new GridLayout(1, 2));
		LabelCenters lc = new LabelCenters(boxSize);
		GameParameters gp = new GameParameters();

		//leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		for(int i=0; i<kutular.length; i++)
		{
			kutular[i] = new JLabel();
			//array[i].setFont(new Font("Tahoma", Font.PLAIN, 10));
			System.out.println("Label-"+i+" posx:"+lc.getCenter6().get(2*i)+" posy:"+lc.getCenter6().get(2*i+1));

			kutular[i].setBounds(lc.getCenter5().get(2*i), lc.getCenter5().get(2*i+1), boxSize, boxSize);
			kutular[i].setBorder(BorderFactory.createLineBorder(Color.red));

			kutular[i].setVisible(true);
			kutular[i].addMouseListener(this);
			kutular[i].addMouseMotionListener(this);
			kutular[i].setHorizontalAlignment(SwingConstants.CENTER);
			//kutular[i].setBackground(Color.YELLOW);
			kutular[i].setFont(new Font("Tahoma", Font.BOLD, 50));
			kutular[i].setText("O");
			getContentPane().add(kutular[i], BorderLayout.CENTER);
		}
		//rightPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		//this.add(leftPanel);
		//this.add(rightPanel);
		leftPanel.addMouseListener(this);
		leftPanel.addMouseMotionListener(this);

		//rightPanel.setLayout(new GridLayout(1, 1));
		//rightPanel.add(area);

		/*dropLabel = new JLabel("drop");
		dropLabel.setTransferHandler(new TransferHandler("text"));*/

	}
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
		/*Dimension labelSize = dropLabel.getPreferredSize();
		dropLabel.setSize(labelSize);
		int x = e.getX() - labelSize.width / 2;
		int y = e.getY() - labelSize.height / 2;
		dropLabel.setLocation(x, y);
		leftPanel.add(dropLabel);

		repaint();*/

	}

	@Override
	public void mouseDragged(MouseEvent me) {
		//System.out.println("mouseDragged");
		System.out.println("mouse pos:x:"+me.getX()+" y:"+me.getY());
		if(me.getX()>50&&(me.getY()>0))
		{
			System.out.println("kosul saglandi");
			kutular[3].setForeground(Color.cyan);
			//kutular[3].setBackground(Color.cyan);
			kutular[3].setText("O");
		}
		//dropLabel.getTransferHandler().exportAsDrag(dropLabel, me,
		//	TransferHandler.COPY);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouseClicked");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}
