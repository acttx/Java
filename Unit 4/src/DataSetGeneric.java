

import java.util.ArrayList;


/**
 * A simple store for Book objects.
 * 
 * @author student
 *
 */
public class DataSetGeneric <T extends Measurable> {
	
	private ArrayList<T> data;

	/**
	 * Default constructor
	 */
	public DataSetGeneric() {
		data = new ArrayList<>();
	}
	
	/**
	 * Add a DSG to the store
	 * 
	 * @param objToAdd Book to add
	 */
	public void add(T objToAdd) {
		data.add(objToAdd);
	}
	
	/**
	 * The number of elements currently in the store
	 * 
	 * @return number of objects
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Determine the smallest measure
	 * 
	 * @return null if the store is empty. Smallest measure otherwise. 
	 * If more than one has the smallest measure, the first one is returned.
	 * 
	 */
	public T getMin() {
		if (data.isEmpty()) {
			return null;
		}
		T mEle = data.get(0);
		for (int i = 1; i < data.size(); i++) {
			if (mEle.getMeasure() > (data.get(i).getMeasure())) {
				mEle = data.get(i);
			}
		}
		return mEle;
	}

	/**
	 * Determine the highest measure
	 * 
	 * @return null if the store is empty. Biggest measure otherwise.
	 * If more than one book has the biggest measure, the first on is returned.
	 *
	 */
	public T getMax() {
		if (data.isEmpty()) {
			return null;
		}
		T mEle = data.get(0);
		for (int i = 1; i < data.size(); i++) {
			if (mEle.getMeasure() < (data.get(i).getMeasure())) {
				mEle = data.get(i);
			}
		}
		return mEle;
	}

	/**
	 * A String representation of the store.
	 * 
	 * @return A String containing the number of elements in the store, 
	 * the smallest measure, the largest measure, and 
	 * the contents of the entire store.
	 */
	@Override
	public String toString() {
		return "DataSetBook [\n size()=" + size() + "\n getMin()=" + getMin() + " getMax()=" + getMax()
				+ " Elements=\n" + data.toString() + "]";
	}



	

}
