/*Program header: SequentialSearchFile.java
 * 
 * Program description: This program searches a file for a given entry.
 * It checks for one, two, or even no command-line parameters.
 * And contains a method to open file and search the contents.
 * 
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SequentialSearchFile {
	public static void main(String args[])
	{
		// String to contain filename
		String fileName = "";
		// String to contain search item;
		String searchItem;
		Scanner s = new Scanner (System.in);
		
			// If there is one command-line parameter
			if (args.length == 1 )
			{
				fileName = args[0]; // assume that it is the filename
				System.out.print("Please enter search item: ");
				searchItem = s.nextLine();
			}
			// If there are two command-line parameters
			else if (args.length == 2)
			{
				fileName = args[0]; // take them as the filename
				searchItem = args[1]; // and as the search item
			}
			else {
				System.out.print("Please enter file name: ");// no command line parameters?
			    fileName = s.nextLine();					 // prompt user for both
			    System.out.print("Please enter search item: "); 
			    searchItem = s.nextLine();
			}
			searchItem = searchItem.trim(); // trim any extra spaces from search item
			
			System.out.println("Searching file" + fileName + "...");
			System.out.println("Item " + searchItem + " was " +
								(sequentialSearch(fileName, searchItem) ?"" : "NOT ") + "found!");
	}
	
	// method opens file and searches the contents
	public static boolean sequentialSearch (String fileName, String searchItem) {			
		boolean result = false;								  // default response is not found
		try {
			Scanner f = new Scanner(new File(fileName));      // get a connection to the file
			String fileItem;
			while(f.hasNext())
				{
					fileItem = f.nextLine();			      // check each entry against the search item
					if(searchItem.equalsIgnoreCase(fileName)) 
					{
						result = true;						 // if found, set result to true
						break;								 // and break out of the while loop
					}
				}
			}
		catch(FileNotFoundException e) {					// if the file wasn't there,
			System.out.println(e.toString());				// show the exception text
			System.exit(0);									// and exit
		}
		return result;										// return the result
	}
}
