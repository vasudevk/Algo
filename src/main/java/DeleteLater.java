/**
 * Created by amit.k.mannur on 4/30/2018.
 */

public class DeleteLater {

    static int[] arr = {1, 3, 4, -20, 10, 20, -6};

    public static void main(String[] args) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum + arr[i], arr[i]);
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }


}
