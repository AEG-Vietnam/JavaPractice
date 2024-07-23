// Import some Classes that help with File manipulation
import java.io.File;            // For File handling!
import java.io.FileWriter;      // File Writing.
import java.io.FileReader;      // File Reading...
import java.io.BufferedReader;  // Read the file line by line with this.. 
                                // that way we don't have to worry about all the weird way files are written. 
                                // (Always let someone else do the hard part)

import java.io.IOException;     // IO Exceptions! Signals that an Input/Output exception of some sort has occurred. 
                                // This class is the general class of exceptions produced by failed or interrupted I/O operations.
                                // Remember: 
                                // An exception (or exceptional event) is just a problem that arises during the execution of a program.
                                // Could be caused by any number of things including:
                                //            User Error:           A user has entered an invalid data.
                                //            Programmer Error:     Tried an out of bounds index in an array! 
                                //                                  (e.g. int [] nums = {0,1,2,3}; nums[20] will throw an exception!)
                                // or even a  
                                //            Machine Error:        Internet disconnected in the middle of communications.
                                //                                  Computer ran out of Memory!

//Extra Java utilities
import java.util.List;          // Gives us the List class!
import java.util.ArrayList;     // Allows us to dynamically create Arrays.

class Main {

  public static void main(String[] args) {
    // Create a String Array from our foods in foods.txt
    String[] foods = fileToArray("foods.txt");

    exampleFunction(wordsWithout(foods,5));
    exampleFunction(foods); // Prints all of the Foods in foods.txt

    test1(foods);
    test2(foods);
    test3(foods);

    /*  Comment Block so the Console doesn't get clogged
    // Some Simple Tests for our methods 
    test1(foods); // Tests wordsCount()
    test2(foods); // Tests wordsFront()
    test3(foods); // Tests wordsWithout()
    */ 
  }

  // Simple example that prints all of the strings in an Array
  public static void exampleFunction(String[] foods) {
    for (String food : foods) {
      System.out.println(food);
    }
  }
    
  //**************************************************************************************************************************************
  //  Solve the following 3 problems
  //  
  //  The methods are already named and initialized.
  //  Feel free to change the names of the funciton inputs,
  //  but maintain their type and order.
  //**************************************************************************************************************************************


  // Problem 1:
  // Given an array of strings, return the count
  // of the number of strings with the given length.
  public static int wordsCount(String[] words, int len) {
    int count = 0;
    for(String word : words){
      if(word.length() == len) count++;
    }
    return count;
  }

  // Problem 2:
  // Given an array of strings, return a new array
  // containing the first N strings.
  // N will be in the range 1..length.
  public static String[] wordsFront(String[] words, int n) {
    String [] frontWords = new String[n];
    for(int i = 0; i < n; i++){
      frontWords[i] = words[i];
    }
    return frontWords;
  }

  // Problem 3:
  // Given an array of strings, return a new Array
  // where all the strings of the given length are omitted.
  public static String[] wordsWithout(String[] words, int len) {
    String [] wordsWithout = new String[words.length-wordsCount(words, len)];
    int i = 0;
    for(String word : words){
      if(word.length() != len){
        wordsWithout[i]= word;
        i++;
      }    
    }
    return wordsWithout;
  }

  // Extras:
  // Start/End with Letter
  // All foods with *x* letter *y*'s


  //**************************************************************************************************************************************
  //  End of Problems
  //
  //  Our File Functions and Tests are below
  //**************************************************************************************************************************************



  // Problem Graeme
  // Compare the two Strings
  // Return true if they are equal, else false
  public static boolean compareMyString(String[] listA, String[] listB) {
    try {
      if (listA.length != listB.length) {
        System.out.println("listA.length: " + listA.length);
        System.out.println("listB.length: " + listB.length);
        return false;
      }
      for(int i =0; i<listA.length; i++) {
        if (!listA[i].equals(listB[i])) {
          System.out.println("listA[" + i + "]: " + listA[i]);
          System.out.println("listB[" + i + "]: " + listB[i]);
          return false;
        }
      }
      return true;
    } catch (NullPointerException e){
      return false;
    }
  }



  // Graeme's Lousy File Functions
  public static void newFile(String filename) {
    try {
      File myFile = new File(filename);
      if (myFile.createNewFile()) {
        System.out.println("New file created: " + myFile.getName());
      } else {
        System.out.println(filename + " already exists!");
      }
    } catch (IOException exception) {
      System.out.println("IO Exception Occured!");
      exception.printStackTrace();
    }
  }

  public static void writeToFile(String filename, String word) {
    try {
      FileWriter myWriter = new FileWriter(filename, true);
      myWriter.write(word);
      myWriter.close();
    } catch (IOException exception) {
      System.out.println("IO Exception Occured!");
      exception.printStackTrace();
    }
  }

  public static String[] fileToArray(String filename) {
    try {
      BufferedReader myReader = new BufferedReader(new FileReader(filename));
      List<String> lines = new ArrayList<String>();
      String line = null;
      while ((line = myReader.readLine()) != null) {
        lines.add(line);
      }
      myReader.close();
      return lines.toArray(new String[lines.size()]);
    } catch (IOException exception) {
      System.out.println("IO Exception Occured!");
      exception.printStackTrace();
      return null;
    }

  }

  // Graeme's Even Lousier Tests
  public static void test1(String[] foods) {
    boolean testA, testB, testC, testD, testE;
    testA = (2 == wordsCount(foods, 5));
    testB = (3 == wordsCount(foods, 6));
    testC = (1 == wordsCount(foods, 4));
    testD = (0 == wordsCount(foods, 10));
    testE = (0 == wordsCount(foods, -1));

    if (testA & testB & testC & testD & testE) {
      System.out.println("\nwordsCount() Passed All Tests!");
    } else {
      System.out.println("\nwordsCount() :");
      System.out.println("You failed the following Tests:");
      if (!testA)
        System.out.println("Test A:\n\twordsCount(foods, 5) = 2");
      if (!testB)
        System.out.println("Test B:\n\twordsCount(foods, 6) = 3");
      if (!testC)
        System.out.println("Test C:\n\twordsCount(foods, 4) = 1");
      if (!testD)
        System.out.println("Test D:\n\twordsCount(foods, 10) = 0");
      if (!testE)
        System.out.println("Test E:\n\twordsCount(foods, -1) = 0");
    }
  }

  public static void test2(String[] foods) {
    boolean testA, testB, testC, testD, testE;

    String[] stringA = { "apple", "banana", "chocolate", "donuts", "eggrolls", "fajita", "granola", "hot dogs",
        "ice cream", "jerky", "kiwi" };
    String[] stringB = { "apple", "banana", "chocolate", "donuts", "eggrolls", "fajita", "granola", "hot dogs" };
    String[] stringC = { "apple", "banana", "chocolate", "donuts" };
    String[] stringD = { "apple", "banana" };
    String[] stringE = { "apple" };

    testA = compareMyString(stringA, wordsFront(foods, 11));
    testB = compareMyString(stringB, wordsFront(foods, 8));
    testC = compareMyString(stringC, wordsFront(foods, 4));
    testD = compareMyString(stringD, wordsFront(foods, 2));
    testE = compareMyString(stringE, wordsFront(foods, 1));

    if (testA & testB & testC & testD & testE) {
      System.out.println("\nwordsFront() Passed All Tests!");
    } else {
      System.out.println("\nwordsFront() :");
      System.out.println("You failed the following Tests:");
      if (!testA) {
        System.out.println("Test A:\n\twordsFront(foods, 11) = [");
        for (String food : stringA) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testB) {
        System.out.println("Test B:\n\twordsFront(foods, 8) = [");
        for (String food : stringB) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testC) {
        System.out.println("Test C:\n\twordsFront(foods, 4) = [");
        for (String food : stringC) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testD) {
        System.out.println("Test D:\n\twordsFront(foods, 2) = [");
        for (String food : stringD) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testE) {
        System.out.println("Test E:\n\twordsFront(foods, 1) = [");
        for (String food : stringE) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
    }
  }

  public static void test3(String[] foods) {
    boolean testA, testB, testC, testD, testE;

    String[] stringA = { "banana", "chocolate", "donuts", "eggrolls", "fajita", "granola", "hot dogs", "ice cream",
        "kiwi" };
    String[] stringB = { "apple", "chocolate", "eggrolls", "granola", "hot dogs", "ice cream", "jerky", "kiwi" };
    String[] stringC = { "apple", "banana", "donuts", "eggrolls", "fajita", "granola", "hot dogs", "jerky", "kiwi" };
    String[] stringD = { "apple", "banana", "chocolate", "donuts", "eggrolls", "fajita", "granola", "hot dogs",
        "ice cream", "jerky", "kiwi" };
    String[] stringE = { "apple", "banana", "chocolate", "donuts", "eggrolls", "fajita", "granola", "hot dogs",
        "ice cream", "jerky", "kiwi" };

    testA = compareMyString(stringA, wordsWithout(foods, 5));
    testB = compareMyString(stringB, wordsWithout(foods, 6));
    testC = compareMyString(stringC, wordsWithout(foods, 9));
    testD = compareMyString(stringD, wordsWithout(foods, 12));
    testE = compareMyString(stringE, wordsWithout(foods, -1));

    if (testA & testB & testC & testD & testE) {
      System.out.println("\nwordsWithout() Passed All Tests!");
    } else {
      System.out.println("\nwordsWithout() :");
      System.out.println("You failed the following Tests:");
      if (!testA) {
        System.out.println("Test A:\n\nwordsWithout(foods, 5) = [");
        for (String food : stringA) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testB) {
        System.out.println("Test B:\n\nwordsWithout(foods, 6) = [");
        for (String food : stringB) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testC) {
        System.out.println("Test C:\n\nwordsWithout(foods, 9) = [");
        for (String food : stringC) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testD) {
        System.out.println("Test D:\n\nwordsWithout(foods, 12) = [");
        for (String food : stringD) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
      if (!testE) {
        System.out.println("Test E:\n\nwordsWithout(foods, -1) = [");
        for (String food : stringE) {
          System.out.println("\t" + food);
        }
        System.out.println("\t]");
      }
    }
  }

}