import static java.lang.Math.max;

/**
 * Created by amit.k.mannur on 3/26/2018.
 */

public class MaximumSubArray {

    public static void main(String[] args) {
        int a[] = {1, 10, 3, -40, 18};
        System.out.println(solveUsingDp(a, a.length));
        System.out.println(maxSum(a, a.length));
        System.out.println(minSum(a, a.length));
    }

    private static int solveUsingDp(int a[], int n) {
        int dp[] = new int[n];
        dp[0] = a[0];
        int big = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = max(dp[i - 1] + a[i], a[i]);
            if (dp[i] > big) {
                big = dp[i];
            }
        }
        return big;
    }

    private static int maxSum(int a[], int n) {
        int maxSum = a[0], sum = 0;
        for (int anA : a) {
            sum = max(sum + anA, anA);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    private static int minSum(int a[], int min) {
        int maxSum = 0, sum = 0;
        for (int anA : a) {
            sum = Math.min(sum + anA, anA);
            if (sum < 50) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
