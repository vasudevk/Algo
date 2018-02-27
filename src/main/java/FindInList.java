import javax.lang.model.type.NoType;
import javax.naming.NameNotFoundException;
import java.util.*;
import java.util.stream.IntStream;

public class FindInList {
    static int d1 = 0;
    static int d2 = 0;

    static int diagonalDifference(int[][] a) {
        int n = a.length;
        int m =a[n-1].length;

            /*for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        d1 = d1 + a[i][j];
                    }
                    if (i + j == n - 1) {
                        d2 = d2 + a[i][j];
                    }
                }
            }
            */
        IntStream.range(0, a.length).parallel().forEach(i -> {
            IntStream.range(0,m).parallel().forEach(j -> {
                if (i == j) {
                    d1 = d1 + a[i][j];
                }
                if (i + j == n - 1) {
                    d2 = d2 + a[i][j];
                }

            });
        });
        return Math.abs(d1 - d2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        for (int a_i = 0; a_i < n; a_i++) {
            for (int a_j = 0; a_j < m; a_j++) {
                a[a_i][a_j] = in.nextInt();
            }
        }
        int result = diagonalDifference(a);
        System.out.println(result);
        in.close();
    }
}
