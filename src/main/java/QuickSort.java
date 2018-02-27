import java.util.Arrays;

/**
 * Created by amit.k.mannur on 9/1/2017.
 */

public class QuickSort {
    private int[] numbers;
    private int number;
    private char[] chars;
public static void main(String... a){
    QuickSort quickSort=new QuickSort();
    int oi[]={1,2,3,8,5,97,45,6,7,2,1};
    String s="aamiimt";
    char c[]=s.toCharArray();
    quickSort.sort(c);
    quickSort.sort(oi);
    System.out.println(String.valueOf(c));
    for(int i:oi){
        System.out.println(i);
    }
}
    public void sort(int[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.numbers = values;
        number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (pivot < numbers[j]) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public void sort(char[] values) {
        // check for empty or null array
        if (values == null || values.length == 0) {
            return;
        }
        this.chars = values;
        number = values.length;
        quicksortchar(0, number - 1);
    }

    private void quicksortchar(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = chars[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (chars[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (chars[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchangeChar(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksortchar(low, j);
        if (i < high)
            quicksortchar(i, high);
    }

    private void exchangeChar(int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}