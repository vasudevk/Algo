/**
 * Created by amit.k.mannur on 2/10/2018.
 */
public class MatrixPrintDiagonal {


    public static void main(String[] as) {
        int[][] a = {{1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 1, 2, 3}};

        int m = a.length;
        int n = a[1].length;
        for (int k = 0; k < m; k++) {
            int i = k;
            int j = 0;
            while (i >= 0) {
                System.out.print(a[i][j]);
                i--;
                j++;
            }
            System.out.println();
        }
        for (int k = 1; k < n; k++) {
            int i = m - 1;
            int j = k;
            while (j < n) {
                System.out.print(a[i][j]);
                i--;
                j++;
            }
            System.out.println();
        }
    }
}
