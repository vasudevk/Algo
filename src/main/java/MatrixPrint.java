/**
 * Created by amit.k.mannur on 2/10/2018.
 */
public class MatrixPrint {

        public static int R,C;

        private static void diagonalOrder(int[][] arr) {

            for (int k = 0; k < R; k++)
            {
                System.out.print(arr[k][0] + " ");
                int i = k - 1;
                int j = 1;
                while (isValid(i, j))
                {
                    System.out.print(arr[i][j] + " ");
                    i--;
                    j++;
                }
                System.out.println("");
            }

            for (int k = 1; k < C; k++)
            {
                System.out.print(arr[R-1][k] + " ");
                int i = R - 2;
                int j = k + 1;
                while (isValid(i, j))
                {
                    System.out.print(arr[i][j] + " ");
                    i--;
                    j++;
                }
                System.out.println("");
            }
        }

        private static  boolean isValid(int i, int j)
        {
            return !(i < 0 || i >= R || j >= C || j < 0);
        }

        public static void main(String[] args) {
            int arr[][] = { {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16},
                            {17, 18, 19, 20},
                            };

            R=arr.length;
            C=arr[0].length;

            diagonalOrder(arr);
        }
}
