

import java.util.ArrayList;

/**
 * A simple store for Book objects.
 * <p>
 * Note that DataSetBook aggregates Books.  
 * Informally, a DataSetBook
 * can contain multiple Book objects.
 * This is DataSetBook's role in life--to contain multiple Books.
 * The given implementation of DataSetBook encapsulates an instance variable of
 * type ArrayList&lt;Book&gt; to assist in this mission.  
 * This implementation of DataSetBook "has-a(n)" ArrayList.
 * But this isn't the only way to implement DataSetBook.
 * </p>
 * <p>
 * In CSC-151, we studied a class StringSet.
 * StringSet's role in life is to store and analyze Strings.
 * In the Inheritance lesson in CSC-151, we 
 * refactored (i.e., reimplemented without 
 * changing its external behavior) StringSet. 
 * The earlier StringSet "has-an" ArrayList
 * to keep its String objects.  
 * We changed StringSet to inherit from ArrayList.
 * So StringSet no longer "has-an" ArrayList; it became
 * StringSet "is-an" ArrayList.
 * </p>
 * <p>
 * Inheritance should be one of the tools in your box for
 * class design and implementation.
 * </p>
 * 
 * 
 * @author student
 *
 */
public class DataSetMeasurable {
	
	private ArrayList<Measurable> data;

	/**
	 * Default constructor
	 */
	public DataSetMeasurable() {
		data = new ArrayList<>();
	}
	
	/**
	 * Add a Book to the store
	 * 
	 * @param objToAdd is the Book we're adding to the store
	 * 
	 * @return true if the element was added to the collection, false otherwise
	 */
	public boolean add(Measurable objToAdd) {
		return data.add(objToAdd);
	}
	
	/**
	 * The number of Books currently in the store
	 * 
	 * @return number of Book objects
	 */
	public int size() {
		return data.size();
	}
	
	/**
	 * Determine the Book with the fewest pages
	 * 
	 * @return null if the store is empty.  The book with the fewest pages
	 * otherwise.  If more than one book has the fewest number of pages,
	 * the first one is returned.
	 */
	public Measurable getMin() {
		if (data.isEmpty()) {
			return null;
		}
		Measurable mEle = data.get(0);
		for (int i = 1; i < data.size(); i++) {
			if (mEle.getMeasure() > (data.get(i).getMeasure())) {
				mEle = data.get(i);
			}
		}
		return mEle;
	}

	/**
	 * Determine the Book with the most pages
	 * 
	 * @return null if the store is empty.  The book with the most pages
	 * otherwise.  If more than one book has the most number of pages,
	 * the first one is returned.
	 */
	public Measurable getMax() {
		if (data.isEmpty()) {
			return null;
		}
		Measurable mEle = data.get(0);
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
	 * @return A String containing the number of books in the store, 
	 * the minimum book, the largest book, and 
	 * the contents of the entire store.
	 */
	@Override
	public String toString() {
		return "DataSetMeasurable [\n size()=" + size() + "\n getMin()=" + getMin() + " getMax()=" + getMax()
				+ " Data Set=\n" + data.toString() + "]";
	}



	

}
