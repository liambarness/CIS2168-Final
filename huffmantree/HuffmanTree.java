/*<listing chapter="6" number="12">*/

package huffmantree;

import java.io.PrintStream;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Class to represent and build a huffman tree
 * 
 * @author Koffman and Wolfgang, revised by Cindy.
 */
public class HuffmanTree {
    
    //nested class
    /**
     * The class for the symbol data in a huffman tree node.
     * The access level of this class was changed to package-level.
     * Only classes in the same package should have access to this class.
     */
    static class HuffData {
        //Data fields
        /**
         * The weight or probability assigned to this HuffData.
         */
        private final double weight;
        /**
         * The alphabet symbol if this is a leaf.
         */
        private final char symbol;
        
        //constructor to create a HuffData for a pair: (weight, symbol)
        //The access level was changed to package-level.
        HuffData(double weight, char symbol) {
            this.weight = weight;
            this.symbol = symbol;
        }
        
        //getter for data field symbol.
        //The access level was changed to package-level.        
        char getSymbol(){
            return symbol;
        }
        
        //Override the toString() version in class Object.
        //Return a string that contains the symbol data in a specific format.
        @Override
        public String toString(){
                                //%c: a char; %f: a float-point number
            return String.format("'%c': %f", symbol, weight);
        }
    }
    //Data field in class HuffmanTree.
    /**
     * A reference to the completed Huffman Tree.
     */
    private BinaryTree<HuffData> huffTree;
    /*</listing*/

    /*<listing chapter="6" number ="13">*/
    /**
     * Build the Huffman Tree using the given alphabet and weights.
     * 
     * @post  huffTree contains a reference to the completed Huffman Tree.
     * @param symbolDataArray an array of HuffData objects.
     */    
    public void buildTree(HuffData[] symbolDataArray) {
        //create a priority queue of binary trees with the given Comparator.
        //Each binary tree stores HuffData objects.
        //The given Comparator compares two binary trees based on the tree root weights.
        Queue<BinaryTree<HuffData>> btPQueue = new PriorityQueue<>(
            //this lamda expression defines the actual Comparator<BinaryTree<HuffData>>).
            //The two given binary trees: leftBT and rightBT are compared
            //  based on how weights in their tree roots are compared as double numbers.
            (leftBT, rightBT) -> Double.compare(leftBT.getData().weight, 
                    rightBT.getData().weight));
        
        //create a 1-node binary tree for each symbol and 
        //   add this binary tree into the priority queue.
        for (HuffData symbolData : symbolDataArray) {
            btPQueue.offer(new BinaryTree<>(symbolData, null, null));
        }
        
        //begin building the huffman tree.
        while (btPQueue.size() > 1) { //priority queue contains at least 2 binary trees.
            //remove the two trees with the smallest weights in their tree roots.
            BinaryTree<HuffData> leftBT = btPQueue.poll();
            BinaryTree<HuffData> rightBT = btPQueue.poll(); 
            
            //sum up the two trees' weights.
            double weightSum = leftBT.getData().weight + rightBT.getData().weight;
            //create a HuffData object to be used as the future new binary tree's root data.
            HuffData newBTRootData = new HuffData(weightSum, '\u0000');
            //create a new binary tree using the new tree root data,
            //    the first removed BT as left subtree, 
            //    the second removed BT as right subtree.
            BinaryTree<HuffData> newBT = new BinaryTree<>(newBTRootData,leftBT, rightBT);  
            //add the new binary tree to the priority queue.
            btPQueue.offer(newBT);           
        }
        //the huffman tree construction is completed.
        //The priority queue should now contains only one item: the completed huffman tree.
        //make the data field huffTree reference the completed huffman tree in the priority queue.
        huffTree = btPQueue.peek();
    }
    /*</list>*/
  
    //This method is not in the textbook.
    public static void main(String[] args) {
        //create an arry of 5 HuffData objects for 5 characters.
        HuffData[] symbolDataArray = new HuffData[5];
        //add the character and frequency information to the array.
        symbolDataArray[0] = new HuffData(64, 'a');
        symbolDataArray[1] = new HuffData(13, 'b');     
        symbolDataArray[2] = new HuffData(22, 'c');        
        symbolDataArray[3] = new HuffData(32, 'd');        
        symbolDataArray[4] = new HuffData(103, 'e');           
        //create an object of HuffmanTree class.
        HuffmanTree myHuffmanTree = new HuffmanTree();
        //call buildTree(..) to build a Huffman Tree based on the characters and frequencies
        //    in the given array: symbolDataArray.
        myHuffmanTree.buildTree(symbolDataArray);
        //call toString() in BinaryTree<E> class to print out the contents of
        //    the Huffman Tree (the data field huffTree in the object: myHuffmanTree).
        System.out.println(myHuffmanTree.huffTree);
        
        //create a PrintStream and associate it with standard output device: monitor
        PrintStream out = new PrintStream(System.out);
        //call the method printCode(..) to print the Huffman Code of entire alphabet to the monitor.
        myHuffmanTree.printCode(out);
        
        //the Huffman code for the message "cab" based on the built huffman tree above.
        String codeMessage = "1111101110";
        //call decode(...) to get the original message.
        String message = myHuffmanTree.decode(codeMessage);
        System.out.println(message);
        
    }
    
    //public wrapper for the private counterpart: printCode below.    
    public void printCode(PrintStream out) {
        printCode(out, "", huffTree);        
    }    
    
    /*<listing chapter="6" number ="14">*/    
    /**
     * Outputs the resulting code using recursion.
     * This is the private recursive counterpart.
     * This method preorder-traverses the Huffman Tree
     *   and outputs each character's huffman code to the PrintStream.
     * 
     * @param out A PrintStream to write the output to
     * @param code the code up to this node (i.e. the code generated so far)
     * @param currentTree the subtree rooted at this node in the entire huffman tree.
     * 
     * Precondition: tree is not null.
     */
    private void printCode(PrintStream out, String code,
            BinaryTree<HuffData> currentTree) {
        //visit root
        //  get the symbol data at the root of the subtree: parameter: currentTree.
        HuffData theData = currentTree.getData();
        if (theData.symbol != '\u0000') {//base case: reaching a 1-node leaf
            //the currentTree root is a leaf for a character in the alphabet.
            if (theData.symbol == ' ') { //the character is space character
                //special handling of the space character.
                //use word space for the space character. 
                out.println("space: " + code);
            } else {
                out.println(theData.symbol + ": " + code);
            }
        } else {
            //add to code a "0" for the left branch, and 
            //   recursively process the left subtree of the currentTree
            printCode(out, code + "0", currentTree.getLeftSubtree());
            //add to code a "1" for the left branch, and 
            //   recursively process the right subtree of the currentTree           
            printCode(out, code + "1", currentTree.getRightSubtree());
        }        

    }
    /*</list>*/    

    /*<listing chapter="6" number="15">*/
    /**
     * Method to decode a message as a string of digit characters
     * '0' and '1'.
     *
     * @param codedMessage The input message as a String of zeros and ones.
     * @return The decoded message as a String
     */    
    public String decode(String codedMessage) {
        StringBuilder result = new StringBuilder();
        //start from the root of the entire Huffman Tree.
        var currentTree = huffTree;
        for (int i = 0; i < codedMessage.length(); i++) {
            //process each bit as a character '1' or '0'
            if (codedMessage.charAt(i) == '1') { 
                //current bit is '1'
                //go to the right branch: update currentTree to the right subtree.
                currentTree = currentTree.getRightSubtree();
            } else {
                //current bit is '0'
                //go to the left branch: update currentTree to the left subtree.                
                currentTree = currentTree.getLeftSubtree();
            }
            if (currentTree.isLeaf()) {
                //currentTree is a 1-node leaf for a character in the alphabet.
                //get the data for the character before encoding.
                HuffData theData = currentTree.getData();
                //add the decoded character to the result
                result.append(theData.symbol);
                //restart from the root of the entire Huffman Tree for the next bit.
                currentTree = huffTree;
            }
        }
        return result.toString();
    }
    /*</list>*/      
    
}

/*---Program Output

' ': 234.000000
  'e': 103.000000
    null
    null
  ' ': 131.000000
    'a': 64.000000
      null
      null
    ' ': 67.000000
      'd': 32.000000
        null
        null
      ' ': 35.000000
        'b': 13.000000
          null
          null
        'c': 22.000000
          null
          null

e: 0
a: 10
d: 110
b: 1110
c: 1111
cab
*/
