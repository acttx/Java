
public class DataSetTester {
	public static void main(String[] args) {
		DataSetMeasurable ds = new DataSetMeasurable();
		Book b1 = new Book("J.K Rowling", "Harry Potter and the Goblet of Fire", 600);
		Book b2 = new Book("Dr Seuss", "Green Eggs and Ham", 62);
		Car c1 = new Car("Super Car", 240);
		Car c2 = new Car("SUV", 120);
		  
		ds.add(b1);
		ds.add(b2);
		ds.add(c1);
		ds.add(c2);
		
		System.out.println(ds);
	}
}
	

