import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicatesInArray {

    private static final int[] inputArray = {1, 2, 3, 4, 5, 6, 6, 6, 6, 8, 9, 1, 7, 7};

    public static void main(String[] args) {

        findDuplicatesUsingHashSet(new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 8, 9, 1});
        findDuplicateElementsUsingJava8(inputArray);
        findDuplicatesUsingBruteForce(new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 8, 9, 1, 7, 7});
        findDuplicatesUsingSorting(new int[]{1, 2, 3, 4, 5, 6, 6, 6, 6, 8, 9, 1, 7, 7});
    }

    private static void findDuplicatesUsingHashSet(int[] inputArray) {
        Set<Integer> set = new HashSet<>();
        for (int element : inputArray) {
            if (!set.add(element)) {
                System.out.println("Duplicate Element: " + element);
            }
        }
    }

    private static void findDuplicateElementsUsingJava8(int[] inputArray) {
        Set<Integer> uniqueElements = new HashSet<>();
        Set<Integer> duplicateElements = Arrays.stream(inputArray)
                .filter(i -> !uniqueElements.add(i))
                .boxed()
                .collect(Collectors.toSet());
        System.out.println(duplicateElements);
    }

    private static void findDuplicatesUsingBruteForce(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] == inputArray[j]) {
                    System.out.println("Duplicate Element using BruteForce: " + inputArray[i]);
                }
            }
        }
    }

    private static void findDuplicatesUsingSorting(int[] inputArray) {
        Arrays.sort(inputArray);
        for (int i = 0; i < inputArray.length - 1; i++) {
            if (inputArray[i] == inputArray[i + 1]) {
                System.out.println("Duplicate Element using Sorting: " + inputArray[i]);
            }
        }
    }
}