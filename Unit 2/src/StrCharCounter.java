import java.util.ArrayList;

/**
 * This class keeps a set of unique strings, and lets the user 
 * ask the total length of all Strings in the store.
 * 
 * @author parks
 *
 */
public class StrCharCounter {

	private ArrayList<String> store = new ArrayList<>();
	private int size = 0;

	public boolean add(String sToAdd) {
		
		if (!store.contains(sToAdd)) {
			size++;
			return store.add(sToAdd);
		}
			
		else
			return false;
	}

	public int calcTotalLength() {
		int cnt = 0;
		for (int i = 0; i < size; i++) {
			cnt += store.get(i).length();
		}
		return cnt;
	}
}
