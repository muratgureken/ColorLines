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
import javax.swing.JLabel;
import methods.ColoredLine;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlowFree extends JFrame implements MouseMotionListener,MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8640151106747724889L;
	//private JPanel leftPanel = new JPanel(null);
	int boxSize=80, maxColorNumber=6,fontSize=60;
	//private JPanel rightPanel = new JPanel(null);
	//JLabel dropLabel;
	Boxes[] bx = new Boxes[25];
	private Integer level=1, drawableBoxNumber=0, centerNumber=0, selectedBoxNumber=0, rowSize=5, maxLevel=19;
	private Integer miliseconds, seconds, minutes, timeCriteria=1, previousBoxIndex, centerBoxIndex;
	private Color currentColor;
	boolean drawAllowed=true;
	private boolean isDrawable=false, centerPassed=false, previousBoxCenter=true, firstChoose=false, gameOver=false;    
	LabelCenters lc;
	GameParameters gp;
	JLabel lblTime;
	ColoredLine[] colorLines = new ColoredLine[maxColorNumber];       
	private JComboBox cmbBoxSize;
	private JLabel lblChooseBoxSize;
	private JLabel lblTimeLimit;
	JLabel lbTitle;
	JComboBox cmbTime;
	JButton btnStartGame;
	private JLabel lblLevel;
	String[] images = new String[6];
	
	public FlowFree() {
		//this.setLayout(new GridLayout(1, 1));
		lc = new LabelCenters(boxSize);
		gp = new GameParameters();
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.black);

		for(int i=0;i<maxColorNumber;i++)
		{
			colorLines[i] = new ColoredLine();
		}

		/*DEFINE IMAGES*/
		images[0] = "/images/blue.png";
		images[1] = "/images/red.png";
		images[2] = "/images/yellow.png";
		images[3] = "/images/green.png";
		images[4] = "/images/cyan.png";
		images[5] = "/images/orange.png";

		lblTime = new JLabel("");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTime.setBounds(484, 11, 114, 35);
		getContentPane().add(lblTime);
		
		lbTitle = new JLabel("FLOW FREE");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.PLAIN, 60));
		lbTitle.setForeground(Color.RED);
		lbTitle.setBounds(102, 153, 402, 90);
		getContentPane().add(lbTitle);
		
		cmbBoxSize = new JComboBox();
		cmbBoxSize.setModel(new DefaultComboBoxModel(new String[] {"5x5", "6x6"}));
		cmbBoxSize.setToolTipText("");
		cmbBoxSize.setBounds(121, 335, 114, 20);
		getContentPane().add(cmbBoxSize);
		
		cmbTime = new JComboBox();
		cmbTime.setModel(new DefaultComboBoxModel(new String[] {"30 seconds", "1 minuntes", "2 minutes", "5 minutes"}));
		cmbTime.setToolTipText("30 seconds\r\n1 minute\r\n2 minutes");
		cmbTime.setBounds(388, 333, 114, 20);
		getContentPane().add(cmbTime);
		
		lblChooseBoxSize = new JLabel("Pattern Size");
		lblChooseBoxSize.setForeground(Color.BLUE);
		lblChooseBoxSize.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChooseBoxSize.setBounds(121, 307, 114, 14);
		getContentPane().add(lblChooseBoxSize);
		
		lblTimeLimit = new JLabel("Time Limit");
		lblTimeLimit.setForeground(Color.YELLOW);
		lblTimeLimit.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTimeLimit.setBounds(388, 307, 114, 14);
		getContentPane().add(lblTimeLimit);
		
		btnStartGame = new JButton("Start");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if((cmbBoxSize.getSelectedIndex()==0)||cmbBoxSize.getSelectedIndex()==1)
				{
					if(cmbTime.getSelectedIndex()==0)
					{
						minutes = 0;
						seconds = 30;
						miliseconds = 0;			
					}
					else if(cmbTime.getSelectedIndex()==1)
					{
						minutes = 0;
						seconds = 60;
						miliseconds = 0;			
					}
					else if(cmbTime.getSelectedIndex()==1)
					{
						minutes = 1;
						seconds = 60;
						miliseconds = 0;			
					}
					else
					{
						minutes = 4;
						seconds = 60;
						miliseconds = 0;			
					}
					firstChoose = true;
					lblLevel.setText("LEVEL "+level);
					
					lbTitle.setVisible(false);
					lblChooseBoxSize.setVisible(false);
					lblTimeLimit.setVisible(false);
					cmbBoxSize.setVisible(false);
					cmbTime.setVisible(false);
					btnStartGame.setVisible(false);
					
					getContentPane().remove(lbTitle);
					getContentPane().remove(lblChooseBoxSize);
					getContentPane().remove(lblTimeLimit);
					getContentPane().remove(cmbBoxSize);
					getContentPane().remove(cmbTime);
					getContentPane().remove(btnStartGame);					
					
					for(int i=0; i<bx.length; i++)
					{
						bx[i] = new Boxes();
						bx[i].setName("GameLabel"+i);
						bx[i].setBounds(lc.getCenter5().get(2*i), lc.getCenter5().get(2*i+1), boxSize, boxSize);
						bx[i].setBorder(BorderFactory.createLineBorder(Color.white));
						bx[i].setVisible(true);
						bx[i].setHorizontalAlignment(SwingConstants.CENTER);
						bx[i].setFont(new Font("Tahoma", Font.BOLD, fontSize));
						bx[i].setcolorIndex(0);
						bx[i].setisCenter(false);
						bx[i].setisDrawn(false);
						getContentPane().add(bx[i], BorderLayout.CENTER);
					}

					applyCentersToBox();
					gameOver = false;
				}
			}
		});
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStartGame.setForeground(Color.WHITE);
		btnStartGame.setBackground(new Color(0, 128, 0));
		btnStartGame.setBounds(244, 399, 136, 35);
		getContentPane().add(btnStartGame);
		
		lblLevel = new JLabel("");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLevel.setBounds(244, 28, 159, 35);
		getContentPane().add(lblLevel);
		getContentPane().addMouseListener(this);
		getContentPane().addMouseMotionListener(this);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
		Integer colorIndexLocal;
		
		Thread gameTimer = new Thread()
		{
			public void run()
			{								
				for(;;)
				{
					if(firstChoose)
					{
						try {
							sleep(1);
							if(miliseconds<=0)
							{
								miliseconds = 999;
								seconds--;
							}
							if(seconds==0)
							{
								seconds = 59;
								minutes--;
							}

							//System.out.println("min:"+minutes+" sec:"+seconds+" msec:"+miliseconds);
							lblTime.setText(Integer.toString(minutes)+":"+Integer.toString(seconds)+":"+Integer.toString(miliseconds));
							miliseconds--;

						} catch (InterruptedException e2) {

						}

						if(minutes<0)
						{
							firstChoose = false;
							lblTime.setText("00:00:000");
							gameOver = true;
							System.err.println("Time is over");

							lblTime.setText("");
							lblLevel.setText("GAME OVER");

							try {
								sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							reserBoxValues();

							lblLevel.setText("");

							for(int i=0; i<bx.length; i++)
							{
								bx[i].setVisible(false);
								//getContentPane().remove(bx[i]);
							}
							
							lbTitle.setVisible(true);
							lblChooseBoxSize.setVisible(true);
							lblTimeLimit.setVisible(true);
							cmbBoxSize.setVisible(true);
							cmbTime.setVisible(true);
							btnStartGame.setVisible(true);
							
							getContentPane().add(lbTitle);
							getContentPane().add(lblChooseBoxSize);
							getContentPane().add(lblTimeLimit);
							getContentPane().add(cmbBoxSize);
							getContentPane().add(cmbTime);
							getContentPane().add(btnStartGame);	
							level = 1;
						}
					}
					else
					{
						break;
					}
				}
			}

		};
		gameTimer.start();
		Integer boxIndex;
		String index, index2;
		index = getContentPane().getComponentAt(e.getX(), e.getY()).getName();

		System.out.println("component index: "+index);
		if(gameOver)
		{
			System.err.println("Time is over");
		}
		else
		{
			if(index.contains("GameLabel"))
			{
				index2 = index.substring(9);
				boxIndex = Integer.parseInt(index2);    
				if((boxIndex<25) && (boxIndex>=0))
				{
					if(bx[boxIndex].getisCenter())
					{
						previousBoxIndex = boxIndex;	
						centerBoxIndex = bx[boxIndex].getIndex();
						//System.out.println("bx index:"+boxIndex+" link index:"+bx[boxIndex].getIndex());
						isDrawable = true;
						currentColor = bx[boxIndex].getForeground();
						clearIfCenterPressed();
					}
					else
					{
						if(bx[boxIndex].getisDrawn())
						{
							colorIndexLocal = bx[boxIndex].getIndex();
							/*clear the box, drawn after this box*/
							clearRestofColorLines(colorIndexLocal, boxIndex);
							currentColor = bx[boxIndex].getForeground();
							isDrawable = true;							
						}
					}
				}             
			}
		}
	}

	
	
	public void clearRestofColorLines(int colorIndex, int boxIndex)
	{
		int pressedBoxIndex, boxIndex2;
		
		pressedBoxIndex = colorLines[colorIndex].getcolorArray().indexOf(boxIndex);
				
		for(int i=(pressedBoxIndex+1);i<colorLines[colorIndex].getcolorArray().size();i++)
		{
			boxIndex2 = colorLines[colorIndex].getcolorArray().get(i);
			
			bx[boxIndex2].setForeground(Color.black);
			bx[boxIndex2].setcolorIndex(-1);
			bx[boxIndex2].setisCenter(false);
			bx[boxIndex2].setisDrawn(false);   
			bx[boxIndex2].setText("");
			bx[boxIndex2].setIndex(-1);
			
			System.out.println("Cleared box:"+boxIndex2);
		}			
		
		for(int i=(pressedBoxIndex+1);i<colorLines[colorIndex].getcolorArray().size();i++)
		{		
			colorLines[colorIndex].getcolorArray().remove(pressedBoxIndex+1);
		}

	}
	
	@Override
	public void mouseDragged(MouseEvent me) {
		//System.out.println("mouseDragged");
		Integer boxIndex;
		String index, index2;
		//System.out.println("control: draw:"+isDrawable+" cpassed:"+centerPassed);
		if(gameOver)
		{
			System.err.println("Time is over");
		}
		else
		{
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
								if(boxChanged(boxIndex))
								{       
									previousBoxIndex = boxIndex;
									System.out.println("linked list indis:"+centerBoxIndex);
									colorLines[centerBoxIndex].setcolorArray(boxIndex);
								}
								bx[boxIndex].setForeground(currentColor);
								bx[boxIndex].setText("*");
								previousBoxCenter = false;
								bx[boxIndex].setisDrawn(true);
								bx[boxIndex].setIndex(centerBoxIndex);
							}
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

		if(gameOver)
		{
			System.err.println("Time is over");
		}
		else
		{
			if(countDrawnBoxes())
			{
				System.err.println("Game Finished");
				if(level<19)
				{
					level++;
					reserBoxValues();
					applyCentersToBox();
					lblLevel.setText("LEVEL "+level);
					firstChoose = true;
				}
				else
				{
					System.err.println("All levels are finished succesfully");
				}
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
			bx[i].setIndex(-1);
			bx[i].setIcon(null);
		}

		for(int i=0;i<maxColorNumber;i++)
		{
			colorLines[i].getcolorArray().clear();
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

	public boolean boxChanged(int boxIndex)
	{
		boolean boxChanged=false;
		if(previousBoxIndex!=boxIndex)
		{
			boxChanged = true;
		}

		return boxChanged;
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
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setText("");
				System.out.println("image:  "+images[i]);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setFirstCenter(gp.getBoundaries5x5(level-1,1+2*i));
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setIndex(i);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setIcon(new ImageIcon(getClass().getResource(images[i])));
				
				//System.out.println("init bx index:"+gp.getBoundaries5x5(level-1,1+2*i)+" link index:"+bx[gp.getBoundaries5x5(level-1,1+2*i)].getIndex());

				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setForeground(gp.getColors().get(i));
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setcolorIndex(i);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setisCenter(true);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setisDrawn(true);
				System.out.println("image1:  "+images[i]);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setText("");
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setFirstCenter(gp.getBoundaries5x5(level-1,1+2*i));
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setIndex(i);
				System.out.println("image2:  "+images[i]);
				bx[gp.getBoundaries5x5(level-1,1+2*i+1)].setIcon(new ImageIcon(getClass().getResource(images[i])));
				System.out.println("image3:  "+images[i]);
				//System.out.println("init bx index:"+gp.getBoundaries5x5(level-1,1+2*i)+" link index:"+bx[gp.getBoundaries5x5(level-1,1+2*i)].getIndex());

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
				bx[gp.getBoundaries6x6(level-1,1+2*i)].setText("");
				bx[gp.getBoundaries6x6(level-1,1+2*i)].setIndex(i);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setIcon(new ImageIcon(getClass().getResource(images[i])));

				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setForeground(gp.getColors().get(i));
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setcolorIndex(i);
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setisCenter(true);
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setisDrawn(true);
				bx[gp.getBoundaries6x6(level-1,1+2*i+1)].setText("");
				bx[gp.getBoundaries6x6(level-1,1+2*i)].setIndex(i);
				bx[gp.getBoundaries5x5(level-1,1+2*i)].setIcon(new ImageIcon(getClass().getResource(images[i])));

			}                
		}
	}
}
