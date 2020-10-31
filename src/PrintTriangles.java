import java.util.Scanner;   // import Scanner class to read inputs

// "public" is a visibility modifier 
// we will study more about visibility modifiers later
public class PrintTriangles {

  // "private" is a visibility modifier 
  // we will study more about visibility modifiers later
  // this method is "static" means this method belong to the class instead of an individual object
  // we will study the meaning of "static" in details later
  // This method prints out the menu to ask for user input
  private static void printMenu() {
    System.out.println("This program prints a shape with a certain size of your choice.");
    System.out.println("You have to select the shape from one of the following:");
    System.out.println("0 -- right-angled triangle with the right angle in the lower left");
    System.out.println("1 -- right-angled triangle with the right angle in the upper left");
    System.out.println("2 -- right-angled triangle with the right angle in the lower right");
    System.out.println("3 -- a diamond");

    System.out.println("After selecting the shape, you will be asked to input the size of the shape. For triangles, the size is the width and height of the triangle. This size must not be larger than 15. For diamonds, the size tells the number of * on the longest row. The size must be an odd number not larger than 15.\n");
  }


  // This method prints out the right-angled triangle 
  // with the right angle in the lower left
  private static void printLLT(int size) {
    for (int i = 0; i < size; i++) {
      for (int j = 0; j <= i; j++)
	     System.out.print("*");
     System.out.println();
    }
  }
  
  private static void printULT(int size) {
	  for (int i = 0; i <size ; i++) {
		  for (int j = 0; j < size-i; j++) 
			  System.out.print("*");
	  System.out.println();
	  }
  }
  
  private static void printLRT(int size) {
	  for (int i = 0; i < size; i++) {
		  for (int j = 0; j < size-i-1; j++)
			  System.out.print(" ");
		  for (int k = 0; k <= i; k++)
			  System.out.print("*");
		  System.out.println();
	  }
  }
  
  private static void printDIA(int size) {
	  for (int i1 = 0; i1 < (size-1)/2+1; i1++) {
		  for (int j1 = 0; j1 < (size-1)/2-i1; j1++)
			  System.out.print(" ");
		  for (int k1 = 0; k1 <= 2*i1; k1++)
			  System.out.print("*");
	  System.out.println();
	  }
	  for (int i2 = 0; i2 < (size-1)/2; i2++) {
		  for (int j2 = 0; j2 <= i2; j2++)
			  System.out.print(" ");
		  for (int k2 = 0; k2 <= 2*((size-1)/2-i2-1); k2++)
			  System.out.print("*");
	  System.out.println();
	  }
  }

  // main method is the starting point of a program
  // "String[] args" carries the arguments passed to the method
  // We will study them in details later
  public static void main(String[] args) {
    int choice, size;
    Scanner scan = new Scanner(System.in);

    printMenu();
    
    choice = -1;
    //While loop here to keep show the followings if choice is not a correct number
    while (choice < 0 || choice > 3){
      System.out.print("Enter the choice of your shape:");
      choice = scan.nextInt();
    }
    //Triangle or Diamond -> different size requirements
    //While loop again if size is not a correct number
    
    if (choice == 3) {
    	size = 4;
    	while ((size % 2 == 0) || size > 15) {
    		System.out.print("Enter the size of your shape:");
    	    size = scan.nextInt();
    	}
    }
    else {
    	size = 16;
    	while (size > 15) {
    		System.out.print("Enter the size of your shape:");
    	    size = scan.nextInt();
    	}
    }

    
    switch (choice) {
      case 0: printLLT(size); break;
      case 1: printULT(size); break;
      case 2: printLRT(size); break;
      case 3: printDIA(size); break;
    }
  }
}
