/* Paul Nguyen
 * Unit 01 Lab - Inheritance
 */

public class DataSetBookTester {
	public static void main(String[] args) {
		
		Book b1 = new Book("Mcgregor", "Java Mistakes I have Made", 1000);
		System.out.println(b1);
		Book b2 = new Book("Jones", "Everything Java", 50000);
		System.out.println(b2);
		Book b3 = new Book("Gosling", "Java Shortcuts", 5);
		System.out.println(b3);
		
		DataSetBook library = new DataSetBook();
		library.add(b1);
		library.add(b2);
		library.add(b3);
		
		System.out.println("Books in Library : " +library.size());
		System.out.println("Books with Most Pages : " +library.getMax());
		System.out.println("Books with Least Pages : " +library.getMin());
		
	}

}
