
/**
 * Test the coding in class PalindromeFinder.
 * Code not in the book.
 * 
 * @author cindy
 */
public class PalindromeFinderTestBasic {

    public static void main(String[] args) {
        System.out.print("C: a palindrome? ");
        //use class name PalindromeFinder because the called method is a static method.
        System.out.println(PalindromeFinder.isPalindrome("C"));

        System.out.print("Car: a palindrome? ");
        System.out.println(PalindromeFinder.isPalindrome("car"));

        System.out.print("kayak: a palindrome? ");
        System.out.println(PalindromeFinder.isPalindrome("kayak"));
    }
}
