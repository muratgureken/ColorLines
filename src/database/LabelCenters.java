package database;

import java.util.LinkedList;

public class LabelCenters {
	private LinkedList<Integer> center5;
	private LinkedList<Integer> center6;

	public LinkedList<Integer> getCenter5() {
		return center5;
	}

	public void setCenter5(LinkedList<Integer> center5) {
		this.center5 = center5;
	}

	public LinkedList<Integer> getCenter6() {
		return center6;
	}

	public void setCenter6(LinkedList<Integer> center6) {
		this.center6 = center6;
	}

	public LabelCenters(int labelSize) {
		center5 = new LinkedList<Integer>();
		center6 = new LinkedList<Integer>();
		
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<5;j++)
			{
				center5.add(20+labelSize+j*labelSize);
				center5.add(30+labelSize+i*labelSize);
			}
		}
		for(int i=0;i<6;i++)
		{
			for(int j=0;j<6;j++)
			{
				center6.add(20+labelSize/2+j*labelSize);
				center6.add(30+labelSize/2+i*labelSize);
			}
		}
	}
}
