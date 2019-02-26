/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author MGureken
 */
public class Boxes extends JLabel{
    private boolean isCenter;
    private Integer colorIndex;
    private boolean isDrawn;
    private Integer firstCenter;
    private Integer index;
    
    public Boxes() {
    }
    
    public boolean isCenter() {
		return isCenter;
	}

	public void setCenter(boolean isCenter) {
		this.isCenter = isCenter;
	}

	public Integer getColorIndex() {
		return colorIndex;
	}

	public void setColorIndex(Integer colorIndex) {
		this.colorIndex = colorIndex;
	}

	public boolean isDrawn() {
		return isDrawn;
	}

	public void setDrawn(boolean isDrawn) {
		this.isDrawn = isDrawn;
	}



	public Integer getFirstCenter() {
		return firstCenter;
	}



	public void setFirstCenter(Integer firstCenter) {
		this.firstCenter = firstCenter;
	}



	public Integer getIndex() {
		return index;
	}



	public void setIndex(Integer index) {
		this.index = index;
	}



	public boolean getisCenter() {
        return isCenter;
    }

    public void setisCenter(boolean isCenter) {
	this.isCenter = isCenter;
    }
        
    public Integer getcolorIndex() {
	return colorIndex;
    }

    public void setcolorIndex(Integer colorIndex) {
	this.colorIndex = colorIndex;
    }
        
    public boolean getisDrawn() {
	return isDrawn;
    }

    public void setisDrawn(boolean isDrawn) {
	this.isDrawn = isDrawn;
    }
}
