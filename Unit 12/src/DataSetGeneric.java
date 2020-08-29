


import java.util.ArrayList;
import java.util.List;



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
	
	public List<E>sort(List<E> list){
		if (list.size() <= 1) 
			return list;
		
		List<E> firstHalf = new ArrayList<E>();
		for (int i = 0; i < list.size() / 2; i++) {
			firstHalf.add(list.get(i));
		}
		List<E> mergeFirst = sort(firstHalf);
		
		List<E> secondHalf = new ArrayList<E>();
		for(int i = list.size() / 2; i < list.size(); i++) {
			secondHalf.add(list.get(i));
		}
		List<E> mergeSecond = sort(secondHalf);
		
		return merge(mergeFirst, mergeSecond);
		
	}
	
	private List<E> merge(List<E> list1, List<E> list2) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		
		List<E> mList = new ArrayList<>();

		while (current1 < list1.size() && current2 < list2.size()) {
			if (list1.get(current1).getMeasure() < list2.get(current2).getMeasure())
				mList.add(list1.get(current1++));
			else
				mList.add(list2.get(current2++));
		}

		while (current1 < list1.size())
			mList.add(list1.get(current1++));

		while (current2 < list2.size())
			mList.add(list2.get(current2++));
		
		return mList;
	}
	
	@Override
	public String toString() {
		return "DataSetGeneric [\n size()=" + size() + "\n getMin()=" + getMin() + " getMax()=" + getMax()
				+ " Elements=\n" + super.toString() + "]";
	}



	

}
