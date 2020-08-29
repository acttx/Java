import java.util.ArrayList;

public class RerootTreeTest {
	public static void main(String[] args) {
		RerootTree<String> tree = new RerootTree<>();
		tree.insert("George");
		tree.insert("Michael");
		tree.insert("Tom");
		tree.insert("Adam");
		tree.insert("Jones");
		tree.insert("Peter"); 
		tree.insert("Daniel");

		System.out.println("\n-----------------Primary-------------------------");
	    System.out.println("Inorder (sorted): ");
	    tree.inorder();
		    
	    System.out.println("\nCurrent Root: " + tree.getRoot().element);
	    
		// Search for an element
		System.out.print("Is Peter in the tree? " + tree.search("Peter"));
	    
	    System.out.println("\nA path from the root to Peter is: ");
	    ArrayList<RerootTree.TreeNode<String>> path = tree.path("Peter");
	    for (int i = 0; path != null && i < path.size(); i++)
	      System.out.print(path.get(i).element + " ");	
	    System.out.println("");
	    
		//Verify that the root element has changed.
		//Verify that the elements of the tree are the same.	    
		System.out.println("\n-----------------New Root-------------------------");
	    tree.establishNewRoot("Paul"); //New root is now Paul
	    
	    //Verify that the sorted order of the elements is not affected by the call to establishNewRoot
	    System.out.println("Inorder (sorted): ");
	    tree.inorder();
	    
		System.out.println("\nNew Root: " + tree.getRoot().element);
		
		// Search for an element
		System.out.print("Is Peter in the tree? " + tree.search("Peter"));
		
		//Verify the structure of the tree is changed.
		System.out.println("\nA path from the NEW root to Peter is: ");
	    ArrayList<RerootTree.TreeNode<String>> newPath = tree.path("Peter");
	    for (int i = 0; newPath != null && i < newPath.size(); i++)
	      System.out.print(newPath.get(i).element + " ");
	    System.out.println();
	    
	    //Verify if Element is not already a member of the tree, if so it does nothing.
	    System.out.println("\n-----------------Verify Element in Tree-------------------------");
	    tree.establishNewRoot("Paul"); //Will show message
	    tree.establishNewRoot("jack"); //Will not show message	
	}
}
