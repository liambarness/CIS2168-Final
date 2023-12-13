//IndexGenerator.java
//* Use a TreeSet to build an index for a file
//* It's a little different from the code in the book.

/*<listing chapter="6" number="8">*/

import java.util.TreeSet;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class to build an index.
 *  @author Koffman and Wolfgang
 **/
public class IndexGenerator {

    // Data Fields
    /** Tree for storing the index. */
    private TreeSet<String> index;
    /**
     * Pattern for extracting words from a line
     * A word is a string of one or more letters or numbers or ' characters
     */
    private static final Pattern wordPattern =
            Pattern.compile("[\\p{L}\\p{N}']+");

    // Methods
    public IndexGenerator() {
        index = new TreeSet<>();
    }

    /**
     * Reads each word in data file and stores it in search tree
     * along with its line number.
     * @post Lowercase form of each word with line
     *       number stored in index.
     * @param scan A Scanner object that contains the input text
     */
    public void buildIndex(Scanner scan) {
        int lineNum = 0; // Line number
        // Keep reading lines until done.
        while (scan.hasNextLine()) {
            lineNum++;
            // Extract each token and store it in index //Note- a token is a word here.
            String token;
            while ((token = scan.findInLine(wordPattern)) != null) {
                index.add(String.format("%s, %3d", token, lineNum));
            }
            scan.nextLine();
        }
    }

    /** Displays the index, one word per line. */
    public void showIndex() {
        // Use an iterator to access and display tree data.
        for (String next : index) {
            System.out.println(next);
        }
    }

    public static void main(String[] args) {
        Scanner scan = null;
        try {
            //create a Scanner associated with a file for which an index is to be built
            scan = new Scanner(new FileReader(new File("test_file_4_word_index.txt")));
        } catch (IOException ex) {
            System.err.println("Error opening the file");
            //print the error stack content
            ex.printStackTrace();
            //terminate the program with error code 1
            System.exit(1);
        }
        //create an object of the class IndexGenerator.
        IndexGenerator indexGenerator = new IndexGenerator();
        //build the index using the scanner scan
        indexGenerator.buildIndex(scan);
        //display the index one word per line
        indexGenerator.showIndex();
    }
}
/*</listing>*/
