import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReturnPermutation2 {

    public static void main(String[] args) {
        // Input string
        String input = "abc";
        char[] inputArray = input.toCharArray();

        // Generate permutations with each character as a starting point
        String[] permutations = generatePermutations(inputArray, 0);

        // Print the result
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    // Modified function to generate permutations and return as an array
    private static String[] generatePermutations(char[] s, int startIndex) {
        List<String> result = new ArrayList<>();
        // If we have reached the end of the string, add the permutation to the result3
        if (startIndex == s.length - 1) {
            result.add(new String(s));
        } else {
            // Iterate through the characters, swapping them with the current fixed character
            for (int i = startIndex; i < s.length; i++) {
                // Swap the characters
                swap(s, startIndex, i);
                // Recursively generate permutations for the remaining characters and add to the result
                result.addAll(Arrays.asList(generatePermutations(s, startIndex + 1)));
                // Backtrack by restoring the original state (undo the swap)
                swap(s, startIndex, i);
            }
        }

        // Convert the list to an array
        return result.toArray(new String[0]);
    }

    // Helper method to swap characters in the array
    private static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
}
