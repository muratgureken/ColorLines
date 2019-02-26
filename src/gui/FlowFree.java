package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import database.GameParameters;
import database.LabelCenters;
import java.awt.BorderLayout;
import java.awt.Font;
import java.util.LinkedList;
import javax.swing.SwingConstants;

public class FlowFree extends JFrame implements MouseMotionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8640151106747724889L;
	//private JPanel leftPanel = new JPanel(null);
	int boxSize=50;
	//private JPanel rightPanel = new JPanel(null);
	//JLabel dropLabel;
        Boxes[] bx = new Boxes[25];
        private Integer level=1, drawableBoxNumber=0, centerNumber=0, selectedBoxNumber=0, rowSize=5, maxLevel=19;
        private LinkedList<Integer>[] colorLines;
        private Color currentColor;
        private boolean isDrawable=false;    
        LabelCenters lc;
        GameParameters gp;
                
	public FlowFree() {
		//this.setLayout(new GridLayout(1, 1));
		lc = new LabelCenters(boxSize);
		gp = new GameParameters();
		getContentPane().setLayout(null);

                getContentPane().addMouseListener(this);
                getContentPane().addMouseMotionListener(this);
                for(int i=0; i<bx.length; i++)
                {
                    bx[i] = new Boxes();
                    bx[i].setName("GameLabel"+i);
                    bx[i].setBounds(lc.getCenter5().get(2*i), lc.getCenter5().get(2*i+1), boxSize, boxSize);
                    bx[i].setBorder(BorderFactory.createLineBorder(Color.red));
                   // bx[i].set(false);
                    bx[i].setVisible(true);
                    /*bx[i].addMouseListener(this);
                    bx[i].addMouseMotionListener(this);*/
                    bx[i].setHorizontalAlignment(SwingConstants.CENTER);
                    bx[i].setFont(new Font("Tahoma", Font.BOLD, 50));
                    bx[i].setcolorIndex(0);
                    bx[i].setisCenter(false);
                    bx[i].setisDrawn(false);
                    getContentPane().add(bx[i], BorderLayout.CENTER);
                }
                
                applyCentersToBox();
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
                Integer boxIndex;
                String index, index2;
                index = getContentPane().getComponentAt(me.getX(), me.getY()).getName();
                if(index.contains("GameLabel"))
                {
                    index2 = index.substring(9);
                    boxIndex = Integer.parseInt(index2);    
                                
                    System.out.println("ne: "+getContentPane().getComponentAt(me.getX(), me.getY()).getName());
                    /*boxIndex = ibc.IsInBorder(me.getX(), me.getY(), rowSize);
                    System.out.println("boxIndex:"+boxIndex+" mouse pos:x:"+me.getX()+" y:"+me.getY());*/
                    if((boxIndex<25) && (boxIndex>=0))
                    {
                        //bx[3].setBackground(Color.cyan);
                        bx[boxIndex].setText("O");
                    }
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
        
        public void reserBoxValues()
        {
            for(int i=0;i<(rowSize*rowSize);i++)
            {
                bx[i].setForeground(Color.black);
                bx[gp.getBoundaries5x5(level-1,1+2*i)].setcolorIndex(-1);
                bx[i].setisCenter(false);
                bx[i].setisDrawn(false);   
                bx[i].setText("");
            }
        }
        
        public void applyCentersToBox()
        {          
            if(rowSize==5)
            {
                centerNumber = gp.getBoundaries5x5(level-1,0); 
                for(int i=0;i<centerNumber;i++)
                {
                    //System.out.println("levelno:"+(level-1)+" boxnumber:"+centerNumber+" index:"+(1+2*i)+" "+(1+2*i+1));
                    bx[gp.getBoundaries5x5(level-1,1+2*i)].setForeground(gp.getColors().get(i));
                    bx[gp.getBoundaries5x5(level-1,1+2*i)].setcolorIndex(i);
                    bx[gp.getBoundaries5x5(level-1,1+2*i)].setisCenter(true);
                    bx[gp.getBoundaries5x5(level-1,1+2*i)].setisDrawn(false);
                    bx[gp.getBoundaries5x5(level-1,1+2*i)].setText("O");
                    
                    bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setForeground(gp.getColors().get(i));
                    bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setcolorIndex(i);
                    bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setisCenter(true);
                    bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setisDrawn(false);
                    bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setText("O");
                }
            }
            else
            {
                centerNumber = gp.getBoundaries6x6(level-1,0); 
                for(int i=0;i<centerNumber;i++)
                {
                    bx[gp.getBoundaries6x6(level-1,1+2*i)].setForeground(gp.getColors().get(i));
                    bx[gp.getBoundaries6x6(level-1,1+2*i)].setcolorIndex(i);
                    bx[gp.getBoundaries6x6(level-1,1+2*i)].setisCenter(true);
                    bx[gp.getBoundaries6x6(level-1,1+2*i)].setisDrawn(false);
                    bx[gp.getBoundaries6x6(level-1,1+2*i)].setText("O");
                    
                    bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setForeground(gp.getColors().get(i));
                    bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setcolorIndex(i);
                    bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setisCenter(true);
                    bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setisDrawn(false);
                    bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setText("O");
                }                
            }
        }
}
