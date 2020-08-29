/* Paul Nguyen
 * Unit 01 Lab - Inheritance
 */

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

public class DataSetBook extends ArrayList<Book> {  

	public DataSetBook() {
		
	}
	
	public boolean add(Book objToAdd) {
		return super.add(objToAdd);
	}

	public int size() {
		return super.size();
	}

	public Book getMin() {
		if (super.isEmpty()) {
			return null;
		}
		Book mEle = super.get(0);
		for (int i = 1; i < super.size(); i++) {
			if (mEle.getPages() > (super.get(i).getPages())) {
				mEle = super.get(i);
			}
		}
		return mEle;
	}

	public Book getMax() {
		if (super.isEmpty()) {
			return null;
		}
		Book mEle = super.get(0);
		for (int i = 1; i < super.size(); i++) {
			if (mEle.getPages() < (super.get(i).getPages())) {
				mEle = super.get(i);
			}
		}
		return mEle;
	}

	@Override
	public String toString() {
		return "DataSetBook [\n size()=" + size() + "\n getMin()=" + getMin() + " getMax()=" + getMax()
				+ " Books=\n" + super.toString() + "]";
	}



	

}
