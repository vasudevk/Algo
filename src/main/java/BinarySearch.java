import static java.util.Arrays.binarySearch;

/**
 * Created by amit.k.mannur on 2/27/2018.
 */
public class BinarySearch {

    public static void main(String p[]){

        int[] a={1,2,3,4,5,6,7,8};
        System.out.println( binnarySearch(a,0,a.length-1,6));
    }

    static int binnarySearch(int[] a,int low,int high,int key){

        while(low <= high) {
            int mid = low + high >>> 1;
            Comparable var7 = (Comparable)a[mid];
            int var8 = var7.compareTo(key);
            if(var8 < 0) {
                low = mid + 1;
            } else {
                if(var8 <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }
}
