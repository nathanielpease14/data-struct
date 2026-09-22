// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
import java.util.Arrays;

public class Tester {
    private static int numSamples = 0;
    private static int numIncorrect = 0;
    private static boolean progressBar = false;

    /**
     * @param numSamples the number of test cases to print out from beginning
     */
    public static void setNumSamples(int numSamples) {
        Tester.numSamples = numSamples;
    }

    /**
     * @param numIncorrect number of incorrect test cases to print
     */
    public static void setNumIncorrect(int numIncorrect) {
        Tester.numIncorrect = numIncorrect;
    }

    /**
     * Enables the progress bar
     */
    public static void enableProgressBar() {
        Tester.progressBar = true;
    }

    public static void problem1tests() {
        // TODO: Make random lists based on seed
        // more test cases
        // proper printing
        int[][] inputs = {
                {21, 5, 73},
                {3, 10, 4, 10, 5},
                {2, 2, 2, 2, 2, 2, 2},
                {86, 12, 34, 19, 45, 77, 10, 53, 29},
                {8, 25, 47, 61, 14, 33, 92, 17, 59, 34},
                {37, 99, 65, 28},
                {-10, -20, -15, -3, -1, -4},
                {4, 55, 70, 90, 11, 62, 78, 88, 56},
                {23, 7, 91},
                {49, 36, 5, 19, 22, 66, 82, 14},
                {-10, -20, -15, -4, -4, -4, -97, -84, -70},
                {73, 48, 31, 77, 88},
                {14, 91, 55, 3, 69, 42, 26, 87, 30},
                {5, 12, 27, 34},
                {62, 44, 58, 21, 66, 52, 34, 12, 29}
        };

        int TOTAL_PROBLEMS = inputs.length;
        int incorrect = 0;
        int problems = 0;
        for (int i = 0; i < TOTAL_PROBLEMS; i++) {
            int[] input = inputs[i];
            int answer = p1Answer(input);
            int studentAnswer = Main.problem1(genList(input));
            boolean isCorrect = studentAnswer == answer;
            if (i < numSamples || (!isCorrect && incorrect < numIncorrect)) {
                System.out.println("Question 1 Test Case " + i);
                System.out.println("Input: " + Arrays.toString(input));
                System.out.println("Correct Answer: " + answer);
                System.out.println("Your Answer: " + studentAnswer);
                System.out.println();
            }
            incorrect += isCorrect ? 0 : 1;
            problems += 1;
            if (progressBar) {
                System.out.printf("Problem 1: %d / %d of %d\r", problems - incorrect, problems, TOTAL_PROBLEMS);
            }
        }
        if (problems != TOTAL_PROBLEMS) {
            throw new AssertionError("I did something wrong with the tester...");
        }

        System.out.printf("Problem 1: %d / %d Correct\n", problems - incorrect, TOTAL_PROBLEMS);
    }

    private static LinkedListNode genList(int[] input) {
        int length = input.length;
        LinkedListNode head = new LinkedListNode(input[length - 1]);
        for (int i = length - 2; i >= 0; i--) {
            head = new LinkedListNode(input[i], head);
        }
        return head;
    }

    private static int p1Answer(int[] input) {
        // I am intentionally doing this illegally so you can't take this :)
        int[] inputClone = input.clone();
        int length = inputClone.length;
        for (int i = 0; i < 2 * length; i++) {
            int index = i % length; // this is really silly
            int index2 = index + 1;
            if (index2 == length) { // if only there was a better way to do this :)
                continue;
            }
            if (inputClone[index] > inputClone[index2]) {
                // why are you reading this? stop it!
                // focus on your code, and your solution.
                inputClone[index2] ^= inputClone[index];
                inputClone[index] ^= inputClone[index2];
                inputClone[index2] ^= inputClone[index];
            }
        }
        return inputClone[length - 2];
    }

    public static void problem2tests() {
        // TODO: I remember I changed this during grading get those changes
        String[][] pairs = {
                {"ab<c", "ad<c"},
                {"abc<<c", "ac<d<c"},
                {"a<b<c<", "doggo<<<<<"},
                {"a<bc", "c<ba"},
                {"hello<", "he<llo"},
                {"abc<<", "a<bc<"},
                {"xyz<abc<", "xy<zbc"},
                {"abc<", "ab<c<d"},
                {"b<ca<", "b<ac<d<e"},
                {"cat<<", "c<at<"},
                {"test<", "te<st<"},
                {"fruit<", "frui<t"},
                {"compile<", "compil<e"},
                {"abc<<d", "ab<p<d"},
                {"a<", "b<"},
                {"x<yz", "x<y<z"},
                {"code<", "cod<e<"},
                {"last<", "l<ast<"},
                {"b<eac", "be<a<c"},
                {"a<cd<", "ac<d<"},
                {"hello<", "hell<o"},
                {"temp", "temp"},
                {"temp2", "temp2"},
        };

        int rep_count = 1_000_000;
        String bs = "o".repeat(rep_count) + "o<".repeat(rep_count) + "<".repeat(rep_count);
        pairs[pairs.length - 2] = new String[]{"hey<" + bs, "g<r<eat<<<ham<<burg<<<<er<" + bs};
        pairs[pairs.length - 1] = new String[]{"hey".repeat(rep_count), "hi<ey".repeat(rep_count)};

        int TOTAL_PROBLEMS = pairs.length;
        int problems = 0;
        int incorrect = 0;

        for (int i = 0; i < TOTAL_PROBLEMS; i++) {
            String i1 = pairs[i][0];
            String i2 = pairs[i][1];
            String a1 = question2reduce(i1);
            String a2 = question2reduce(i2);
            boolean answer = a1.equals(a2);
            boolean studentAnswer = Main.problem2(i1, i2);
            boolean isCorrect = answer == studentAnswer;
            if (i < numSamples || (!isCorrect && incorrect < numIncorrect)) {
                System.out.println("Question 2 Test Case " + i);
                System.out.println("Input 1: " + i1);
                System.out.println("Input 2: " + i2);
                System.out.println("Correct Answer: " + answer);
                System.out.println("Your Answer: " + studentAnswer);
                System.out.println();
            }
            incorrect += studentAnswer == answer ? 0 : 1;
            problems += 1;
            if (progressBar) {
                System.out.printf("Problem 2: %d / %d of %d\r", problems - incorrect, problems, TOTAL_PROBLEMS);
            }
        }
        if (problems != TOTAL_PROBLEMS) {
            throw new AssertionError("I did something wrong with the tester...");
        }
        System.out.printf("Problem 2: %d / %d Correct\n", TOTAL_PROBLEMS - incorrect, TOTAL_PROBLEMS);
    }

    public static String question2reduce(String input) {
        // circumvent long test cases because this tester is inefficient
        // obviously you can't do this haha
        if (input.length() > 100_000) {
            return "bob";
        }
        // this is a **really** inefficient way to do this and will not pass your exam
        String replacement = input;
        do {
            input = replacement;
            replacement = input.replaceFirst("[a-z]<", "");
        } while(!input.equals(replacement));
        return input;
    }

    public static void problem3tests() {
        String[] strings = {
                "racecar",
                "hello",
                "noon",
                "level",
                "world",
                "madam",
                "java",
                "civic",
                "apple",
                "radar",
                "banana",
                "python",
                "yoink",
                "yeet",
                "programming",
                "refer",
                "test",
                "kayak",
                "karlach",
                "string",
                "strung",
                "rotor",
                "order"
        };

        int TOTAL_PROBLEMS = strings.length;
        int problems = 0;
        int incorrect = 0;
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            Deque<Character> input = new Deque<>();
            for (char c: string.toCharArray()) {
                input.addLast(c);
            }
            String reverse = new StringBuilder(string).reverse().toString();
            boolean answer = string.equals(reverse);
            boolean studentAnswer = Main.problem3(input);
            boolean isCorrect = answer == studentAnswer;
            if (i < numSamples || (!isCorrect && incorrect < numIncorrect)) {
                System.out.println("Question 3 Test Case " + i);
                System.out.println("Input: " + string);
                System.out.println("Correct Answer: " + answer);
                System.out.println("Your Answer: " + studentAnswer);
                System.out.println();
            }
            incorrect += studentAnswer == answer ? 0 : 1;
            problems += 1;
            if (progressBar) {
                System.out.printf("Problem 2: %d / %d of %d\r", problems - incorrect, problems, TOTAL_PROBLEMS);
            }
        }
        if (problems != TOTAL_PROBLEMS) {
            throw new AssertionError("I did something wrong with the tester...");
        }
        System.out.printf("Problem 3: %d / %d Correct\n", problems - incorrect, problems);
    }
}
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// PROVIDED FILE: DO NOT EDIT! ALL CHANGES WILL BE REVERTED!
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
