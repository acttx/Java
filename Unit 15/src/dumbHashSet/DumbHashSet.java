package dumbHashSet;

public class DumbHashSet extends java.lang.Object {
	@SuppressWarnings("unchecked")
	private MyArrayList<String>[] buckets = new MyArrayList[27];

	public DumbHashSet() {
		
	}

	public boolean add(java.lang.String s) {
		if(s == null) {
			throw new IllegalArgumentException(s + "cannot be null.");
		}else {
			int index = hash(s);
			if(buckets[index] == null) {
				MyArrayList<String> bucket = new MyArrayList<String>();
				buckets[index] = bucket;
			}
			buckets[index].add(s);
			return true;
		}
	}
	
	public boolean contains(java.lang.String s) {
		if(s == null) {
			throw new IllegalArgumentException(s + "cannot be null.");
		}
		return false;
	}
	
	public boolean remove(java.lang.String s) {
		if(s == null) {
			throw new IllegalArgumentException(s + "not found.");
		}else {
			this.remove(s);
		}
		return true;
	}
	
	public int size() {
		return size();
	}
	
	public java.util.Iterator<java.lang.String> iterator() {
		return new dhsIterator();
	}
	
	private class dhsIterator implements java.util.Iterator<java.lang.String> {
		private MyList<String> myList = new MyArrayList<String>();
		private int current = 0; //Point to the current element in list
		
		
		@Override
		//Next element for traversing
		public boolean hasNext() {
			return current < myList.size();
		}
		
		@Override
		//Get current element and move cursor to he next
		public String next() {
			return myList.get(current++);
		}
	}
	
	public int hash(String s) {
		int last = 26;
		int first = s.toLowerCase().charAt(0) - 'a';
		if(first < last && first >= 0) {
			return first;
		}else {
			return last;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < buckets.length; i++) {
			if(buckets[i] != null) {
				builder.append("\n");
				builder.append("[Bucket " + i + "]:");
				builder.append("\n");
			}
			MyArrayList<String> list = buckets[i];
			if(buckets[i] != null) {
				for(String s : list) {
					builder.append("\n");
					builder.append(s + " " + "\n");
				}
			}
		}
		return builder.toString();
	}	
}
