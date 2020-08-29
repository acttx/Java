
public class DataSetGenericTester {

  public static void main(String[] args) {
	  DataSetGeneric books = new DataSetGeneric<>();
	  DataSetGeneric car = new DataSetGeneric<>();
	  
	  Book b1 = new Book("J.K Rowling", "Harry Potter and the Goblet of Fire", 600);
	  Car c1 = new Car("Super Car", 240);
	  books.add(b1);
	  car.add(c1);
	  
	  System.out.println(books);
	  System.out.println(car);
	  
	  
	  
  }
}