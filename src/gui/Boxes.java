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

    public Boxes() {
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
