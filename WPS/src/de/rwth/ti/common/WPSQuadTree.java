package de.rwth.ti.common;

import de.rwth.ti.db.MeasurePoint;

public class WPSQuadTree {

//	private float xMax;
//	private float yMax;
	private WPSQuadKnot root = null;

	public WPSQuadTree(float x, float y) {
//		xMax = x;
//		yMax = y;
		root = new WPSQuadKnot(0, x, 0, y);
	}

	public void addPoint(MeasurePoint mp) {
		WPSQuadKnot next = root;
		while (next != null) {
			next = next.addMPoint(mp);
		}
	}

	public MeasurePoint getMPoint(float x, float y) {
		WPSQuadKnot next = root;
		WPSQuadKnot actual = null;
		while (next != null) {
			actual = next;
			next = next.getKnot(x, y);
		}
		return actual.getValue();
	}

	public void remove(MeasurePoint deleteMP) {
		WPSQuadKnot next = root;
		WPSQuadKnot actual = null;
		while(next != null){
			actual = next;
			next = next.getKnot((float)deleteMP.getPosx(), (float)deleteMP.getPosy());
		}
		actual.setValue(null);
	}
}
