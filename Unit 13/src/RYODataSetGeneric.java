import java.util.ArrayList;
import java.util.List;

public class RYODataSetGeneric<E extends Measurable> extends ArrayList<E> {
	
	public E getMin() {
		if (this.isEmpty()) return null;
		E rv = get(0);
		for (E ele: this) {
			if (ele.getMeasure() < rv.getMeasure()) rv = ele;
		}
		return rv;
	}	
	
	public E getMax() {
		if (this.isEmpty()) return null;
		E rv = get(0);
		for (E ele: this) {
			if (ele.getMeasure() > rv.getMeasure()) rv = ele;
		}
		return rv;
	}
	
	public List<E> sort() {
		List<E> list = new ArrayList<>(this);
		return sort(list);
	}
	
	public List<E> sort(List<E> list) {
		// base case:  list of 1 is sorted
		if (list.size() <= 1) return list;
		// Merge sort the first half
		List<E> firstHalf = new ArrayList<E>();
		for (int i = 0; i < list.size() / 2; i++) {
			firstHalf.add(list.get(i));
		}
		List<E> mergeFirst = sort(firstHalf);

		// Merge sort the second half
		int secondHalfLength = list.size() - list.size() / 2;
		List<E> secondHalf = new ArrayList<>();
		for (int i = secondHalfLength; i < list.size(); i++) {
			secondHalf.add(list.get(i));
		}
		List<E> mergeSecond = sort(secondHalf);

		// Merge firstHalf with secondHalf into list
		return merge(mergeFirst, mergeSecond);
	}

	/** Merge two sorted lists */
	private List<E> merge(List<E> list1, List<E> list2) {
		int current1 = 0; // Current index in list1
		int current2 = 0; // Current index in list2
		
		List<E> retList = new ArrayList<>();

		while (current1 < list1.size() && current2 < list2.size()) {
			if (list1.get(current1).getMeasure() < list2.get(current2).getMeasure())
				retList.add(list1.get(current1++));
			else
				retList.add(list2.get(current2++));
		}

		while (current1 < list1.size())
			retList.add(list1.get(current1++));

		while (current2 < list2.size())
			retList.add(list2.get(current2++));
		
		return retList;
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
				+ " Elements=\n" + super.toString() + "]";
	}
}

