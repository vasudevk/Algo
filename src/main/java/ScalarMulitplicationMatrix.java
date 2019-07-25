import java.util.Arrays;

/**
 * Created by amit.k.mannur on 4/17/2018.
 */

public class ScalarMulitplicationMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}};
        int[][] mat2 = {{1, 2, 3}, {4, 5, 6}};
        int k = 4;
        MatrixScalar(mat,k);
        MatrixScalar(mat,mat2,k);
    }

    static void MatrixScalar(int[][] mat, int k) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j]=mat[i][j]*k;
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
    static void MatrixScalar(int[][] mat, int[][] mat2, int k) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = mat[i][j] * mat2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(mat));
    }
}
