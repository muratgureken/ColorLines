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
	boolean drawAllowed=true;
	private boolean isDrawable=false, centerPassed=false, previousBoxCenter=true, firstChoose=true;    
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
		Integer boxIndex;
		String index, index2;
		index = getContentPane().getComponentAt(e.getX(), e.getY()).getName();
		if(index.contains("GameLabel"))
		{
			index2 = index.substring(9);
			boxIndex = Integer.parseInt(index2);    
			if((boxIndex<25) && (boxIndex>=0))
			{
				if(bx[boxIndex].getisCenter())
				{
					isDrawable = true;
					currentColor = bx[boxIndex].getForeground();
					clearIfCenterPressed();
				}
			}             
		}
	}

	@Override
	public void mouseDragged(MouseEvent me) {
		//System.out.println("mouseDragged");
		Integer boxIndex;
		String index, index2;
		//System.out.println("control: draw:"+isDrawable+" cpassed:"+centerPassed);

		if(isDrawable)
		{
			index = getContentPane().getComponentAt(me.getX(), me.getY()).getName();
			if(index.contains("GameLabel"))
			{
				index2 = index.substring(9);
				boxIndex = Integer.parseInt(index2);    

				if(!previousBoxCenter && bx[boxIndex].getisCenter() && drawAllowed)
				{
					drawAllowed = false;
				}

				//System.out.println("previous:"+previousBoxCenter+" nowcenter:"+bx[boxIndex].getisCenter()+" draw:"+drawAllowed);
				//System.out.println("ne: "+getContentPane().getComponentAt(me.getX(), me.getY()).getName());
				/*boxIndex = ibc.IsInBorder(me.getX(), me.getY(), rowSize);
                    System.out.println("boxIndex:"+boxIndex+" mouse pos:x:"+me.getX()+" y:"+me.getY());*/
				if((boxIndex<25) && (boxIndex>=0) && drawAllowed)
				{
					if(bx[boxIndex].getisCenter())
					{
						//nasil olacak dusunelim.bir kez senter i gecince 
						centerPassed = true;
					}
					else
					{
						if(!bx[boxIndex].getisDrawn())
						{
							bx[boxIndex].setForeground(currentColor);
							bx[boxIndex].setText("O");
							previousBoxCenter = false;
							bx[boxIndex].setisDrawn(true);
						}
					}
				}
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
		isDrawable = false;
		centerPassed = false;
		centerPassed = false; 
		previousBoxCenter = true;
		drawAllowed=true;

		if(countDrawnBoxes())
		{
			System.err.println("Game Finished");
			if(level<19)
			{
				level++;
				reserBoxValues();
				applyCentersToBox();
			}
			else
			{
				System.err.println("All levels are finished succesfully");
			}
		}
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
			bx[i].setcolorIndex(-1);
			bx[i].setisCenter(false);
			bx[i].setisDrawn(false);   
			bx[i].setText("");
		}
	}

	public void clearIfCenterPressed()
	{
		for(int i=0;i<rowSize*rowSize;i++)
		{
			if((bx[i].getForeground()==currentColor)&&!(bx[i].getisCenter()))
			{
				bx[i].setText("");
				bx[i].setisDrawn(false);
				selectedBoxNumber--;
			}
		}
	}

	public boolean countDrawnBoxes()
	{
		boolean gameFinished=false;
		selectedBoxNumber = 0;

		for(int i=0;i<rowSize*rowSize;i++)
		{
			if(bx[i].getisDrawn())
			{
				selectedBoxNumber++;
			}
		}

		System.out.println("selected box no:"+selectedBoxNumber+" total:"+(rowSize*rowSize));

		if(selectedBoxNumber==(rowSize*rowSize))
		{
			gameFinished = true;
		}

		return gameFinished;
	}

	public void applyCentersToBox()
	{          
		if(rowSize==5)
		{
			centerNumber = gp.getBoundaries5x5(level-1,0); 
			for(int i=0;i<centerNumber;i++)
			{
				//System.out.println("levelno:"+(level-1)+" boxnumber:"+centerNumber+" boxindex:"+gp.getBoundaries5x5(level-1,1+2*i)+" "+gp.getBoundaries5x5(level-1,1+2*i+1)+
				//		" color:"+gp.getColors().get(i));
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setForeground(gp.getColors().get(i));
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setcolorIndex(i);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setisCenter(true);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setisDrawn(true);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setText("O");
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setFirstCenter(gp.getBoundaries5x5(level-1,1+2*i));
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setIndex(0);

				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setForeground(gp.getColors().get(i));
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setcolorIndex(i);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setisCenter(true);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setisDrawn(true);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setText("O");
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setFirstCenter(gp.getBoundaries5x5(level-1,1+2*i));
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setIndex(2*centerNumber);
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
				bx[gp.getBoundaries6x6(level-1,1+2*i)].setisDrawn(true);
				bx[gp.getBoundaries6x6(level-1,1+2*i)].setText("O");

				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setForeground(gp.getColors().get(i));
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setcolorIndex(i);
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setisCenter(true);
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setisDrawn(true);
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setText("O");
			}                
		}
	}
}
