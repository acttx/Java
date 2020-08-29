package edu.waketech.csc251.collection;


import java.util.ArrayList;

import edu.waketech.csc251.tools.Screener;

public class DataSetGeneric <E extends Measurable> extends ArrayList<E> {
	
	//Constructor
	public DataSetGeneric() {
		
	}
	
	//Adding objects
	public boolean add(E objToAdd) {
		return super.add(objToAdd);
	}
	
	//returns size of DSG
	public int size() {
		return super.size();
	}

	//return smallest object 
	public E getMin() {
		if (isEmpty()) {
			return null;
		}
		E mEle = (E) get(0);
		for (int i = 1; i < size(); i++) {
			if (mEle.getMeasure() > (get(i).getMeasure())) {
				mEle = (E) get(i);
			}
		}
		return mEle;
	}
	
	//return the largest object 
	public E getMax() {
		if (isEmpty()) {
			return null;
		}
		E mEle = (E) get(0);
		for (int i = 1; i < size(); i++) {
			if (mEle.getMeasure() < (get(i).getMeasure())) {
				mEle = (E) get(i);
			}
		}
		return mEle;
	}

	//returns list of all elements in DSG
	public ArrayList<E> getList(){
		ArrayList<E> list = new ArrayList<E>();
		for(int i = 0; i < size(); i++) {
			list.add(super.get(i));
		}
		
		return list;
		
	}
	
	public ArrayList<E> getList(Screener<E> elementScreener){
		ArrayList<E> scrList = new ArrayList<E>();
		for (int i = 0; i < size(); i++) {
			if (elementScreener.test(super.get(i)) == true) {
				scrList.add(super.get(i));
			}
		}
		return scrList;
	}
	
	@Override
	public String toString() {
		return "DataSetGeneric [\n size()=" + size() + "\n getMin()=" + getMin() + " getMax()=" + getMax()
				+ " Elements=\n" + super.toString() + "]";
	}



	

}
