package dp;

import java.util.ArrayList;
import java.util.List;

public class CoinChanging {

    static int i = 0;
    static int ia=0;
    static int ib=0;
    static int ic=0;

    public static void main(String args[]) {
        CoinChanging cc = new CoinChanging();
        int total = 5;
        int coins[] = {2, 3, 6};
        System.out.println(cc.numberOfSolutions(total, coins));
        System.out.println(cc.numberOfSolutionsOnSpace(total, coins));
        cc.printCoinChangingSolution(total, coins);
        System.out.println(i);
        System.out.println(ia+": "+ib+" :"+ic);
    }

    private int numberOfSolutions(int total, int coins[]) {
        int temp[][] = new int[coins.length + 1][total + 1];
        for (int i = 0; i <= coins.length; i++) {
            temp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                ia++;
                if (coins[i - 1] > j) {
                    temp[i][j] = temp[i - 1][j];
                } else {
                    temp[i][j] = temp[i][j - coins[i - 1]] + temp[i - 1][j];
                }
            }
        }
        return temp[coins.length][total];
    }

    /**
     * Space efficient DP solution
     */
    private int numberOfSolutionsOnSpace(int total, int arr[]) {

        int temp[] = new int[total + 1];

        temp[0] = 1;
        for (int anArr : arr) {
            for (int j = 1; j <= total; j++) {
                ib++;
                if (j >= anArr) {
                    temp[j] = temp[j] + temp[j - anArr];
                }
            }
        }
        return temp[total];
    }

    /**
     * This method actually prints all the combination. It takes exponential time.
     */
    private void printCoinChangingSolution(int total, int coins[]) {
        List<Integer> result = new ArrayList<>();
        printActualSolution(result, total, coins, 0);
    }

    private void printActualSolution(List<Integer> result, int total, int coins[], int pos) {

        if (total == 0) {
            i++;
            ic++;
            for (int r : result) {
                System.out.print(r + " ");
            }
            System.out.print("\n");
        }
        for (int i = pos; i < coins.length; i++) {
            if (total >= coins[i]) {
                ic++;
                result.add(coins[i]);
                printActualSolution(result, total - coins[i], coins, i);
                result.remove(result.size()-1);
            }
        }
    }
}