/**
 * Created by amit.k.mannur on 4/15/2018.
 */

public class FindElementWhichDividesArrayIn2 {


    // Finds an element in an array such that
    // left and right side sums are equal
    static int findElement(int arr[], int n)
    {
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--)
            suffixSum[i] = suffixSum[i + 1] + arr[i];

        for (int i = 1; i < n - 1; i++)
            if (prefixSum[i] == suffixSum[i])
                return arr[i];

        return -1;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = {2, 3, 4, 1, 4, 5 };
        int n = arr.length;
        System.out.println(findElement(arr, n));
    }

}
