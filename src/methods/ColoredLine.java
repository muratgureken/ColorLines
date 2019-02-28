/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.LinkedList;

/**
 *
 * @author mgureken
 */
public class ColoredLine {
	private LinkedList<Integer> colorArray; 

	public ColoredLine() {
		colorArray = new LinkedList<Integer>();
	}


	public LinkedList<Integer> getcolorArray() {
		return colorArray;
	}

	public void setcolorArray(Integer value) {
		colorArray.add(value);
	}
}
