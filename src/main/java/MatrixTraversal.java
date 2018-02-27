import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amit.k.mannur on 9/6/2017.
 */
public class MatrixTraversal {
    // Array size: bigger the size, clearer is the difference in performance
    private static final int ARR_SIZE = 4;

    public static void main(String[] args) {
//new array
        int arr[][] = new int[ARR_SIZE][ARR_SIZE];
        long currTime = System.currentTimeMillis();
        colMajor(arr);
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Total time in colMajor : " + (System.currentTimeMillis() - currTime) + " ms");
// new array, exactly similar to arr
        int arr1[][] = new int[ARR_SIZE][ARR_SIZE];
        currTime = System.currentTimeMillis();
        rowMajor(arr1); // this is the only difference in above
        System.out.println(Arrays.deepToString(arr1));
        System.out.println("Total time in rowMajor : " + (System.currentTimeMillis() - currTime) + " ms");
        matrixArray();
    }

    /**
     * The code below traverses the matrix in column-major order,
     * i.e. it completely sweeps one column before going to the next.
     */
    private static void colMajor(int arr[][]) {
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
/*See this, we are traversing j first and then i*/
                arr[i][j] = i + j;
            }
        }
    }

    /**
     * If we switch the inner and outer loops,
     * the program will traverse the matrix in row-major order,
     * i.e. it will sweep each row before going to a new one,
     * which means it accesses a different column (and hence a different page) every time it accesses the array.
     * This slight change to the code caused the program to take more time to complete.
     */
    private static void rowMajor(int arr[][]) {
        for (int i = 0; i < ARR_SIZE; i++) {
            for (int j = 0; j < ARR_SIZE; j++) {
/*See this , we are traversing j first and then i, but to access the
                * element, more effort is involved now as they are farther located
                */
                arr[j][i] = i + j;
            }
        }
    }


    private static void matrixArray() {
        List<List> lists = new ArrayList<List>();
        for (int i = 0; i < 4; i++) {
            List list1 = new ArrayList();
            for (int j = 0; j < 4; j++) {
                list1.add(j % 2);
            }
            lists.add(list1);
        }
        System.out.println(lists);

        for (int j = 0; j < lists.size(); j++) {
            List list = lists.get(j);
            for (int k = 0; k < list.size(); k++) {
                if (list.get(k).equals(1)) {
                    System.out.println(" i m in index : " + k);
                    if (j < lists.size() - 1) {
                        List list1 = lists.get(j + 1);
                        if (k < list.size() - 1)
                            if (list1.get(k + 1).equals(1) || list1.get(k).equals(1)) {
                                System.out.println(" i m in index2 : " + k);
                            }
                    }
                }

            }
        }
    }
}