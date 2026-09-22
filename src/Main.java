// You should not have any more imports
import java.util.NoSuchElementException;

// Pick any 2 of the 3 problems, and complete for full credit (30 points each)
// You must get all cases correct to receive any credit
// for extra credit, you may complete the third problem for 15 points extra credit
// specify which one you want to count for extra credit, or it will be problem 1

public class Main {
    public static void main(String[] args) {
        String sep = "~".repeat(50);

        // how many solutions to print out regardless of whether they are correct or not
        // you probably want to leave this as 0...
        Tester.setNumSamples(0);

        // how many incorrect solutions to print out
        // anywhere 1 to 5 is pretty good
        Tester.setNumIncorrect(2);

        // Enables the progress bar
        Tester.enableProgressBar();

        // FIXME: Please specify which problems you want tested
        boolean testProblem1 = false;
        boolean testProblem2 = false;
        boolean testProblem3 = false;
        // FIXME: Please specify which problem you want to be counted as extra credit
        // If you make no selection then I will pick problem 1
        int extraCreditProblem = 0; // pick 1, 2, or 3

        System.out.println(sep);
        // Change the problems you are doing to true, and leave anything else as false
        if (testProblem1) { // problem 1
            Tester.problem1tests();
            System.out.println(sep);
        }
        if (testProblem2) { // problem 2
            Tester.problem2tests();
            System.out.println(sep);
        }
        if (testProblem3) { // problem 3
            Tester.problem3tests();
            System.out.println(sep);
        }

        if (!testProblem1 && !testProblem2 && !testProblem3) {
            System.out.println("You need to pick problems to test!");
        }
    }

    /**
     * Your goal is to find and return the second largest element in the provided linked list
     * You can not modify the linked list whatsoever,
     * meaning that the next and data should not be changed.
     * To enforce this, I've only provided getter methods for the Nodes.
     * <p>
     * You can safely assume that all inputs will have size at least 2,
     * and that the provided linked list is valid, and contains no cycles.
     * Therefore, no error checking is required.
     * <p>
     * n = size of linked list
     * Time : O(n)
     * Space: O(1)
     * <p>
     * Examples:
     * [21, 5, 73] -> 21
     * [3, 10, 4, 10, 5] -> 10
     * [2, 2, 2, 2, 2, 2, 2] -> 2
     * [86, 12, 34, 19, 45, 77, 10, 53, 29] -> 77
     * @param inputHead the head of the linked list
     * @return the second-largest element in the linked list
     */
    public static int problem1(LinkedListNode inputHead) {
        return -1;
    }

    /**
     * Compare two strings to see if they are equal.
     * However, you should additionally interpret '<' as a backspace
     * <p>
     * You can safely assume that all prefixes will have at least as many characters as backspaces
     * Therefore, no error checking is required.
     * <p>
     * n = length of input1 + length of input 2
     * Time : O(n)
     * Space: O(n) - See below
     * <p>
     * You should only use stacks and queues.
     * You may NOT use any other data structures.
     * <p>
     * HINT: To keep your code clean, feel free to write your own methods!
     * <p>
     * Examples:
     * "ab<c", "ad<c" -> true
     * "abc<<c", "ac<d<c" -> true
     * "a<b<c<", "doggo<<<<<" -> true
     * "a<bc", "c<ba" -> false
     * @param input1 The first input string
     * @param input2 The second input string
     * @return whether input1 == input2 after backspaces
     */
    public static boolean problem2(String input1, String input2) {
        return false;
    }

    /**
     * Note: In retrospect, I don't particularly like this question.
     * It is asking for one particular solution when others are good enough.
     * <p>
     * A palindrome is a string that is the same as its reverse.
     * For example: "racecar" reversed is still "racecar" so it's a palindrome
     * However, "hello" reversed is "olleh" so it is not a palindrome.
     * <p>
     * I'd like you to discover an efficient way to tell if a string is a palindrome,
     * better practically than reversing the entire string.
     * (although normally you probably wouldn't make a whole deque, this forces you to be efficient)
     * <p>
     * n = size of input
     * Time: O(n)
     * Space: O(1)
     * (You are free to use input however you'd like, but it should not grow beyond a size of n)
     * <p>
     * "racecar" -> true
     * "hello" -> false
     * "noon" -> true
     * "level" -> true
     * @param input the string stored in a deque of characters
     * @return whether the input is a palindrome
     */
    public static boolean problem3(Deque<Character> input) {
        return false;
    }
}