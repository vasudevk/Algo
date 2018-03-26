import java.util.Arrays;

/**
 * Created by amit.k.mannur on 3/25/2018.
 */

public class MergeTwoArrays {

    public static void main(String[] args) {
        int[] a1={4,7,9,1};
        int[] a2={1,9,2,3};

        mergeTwoArray(a1,a2);
    }

    private static void mergeTwoArray(int[] a1,int[] a2){
    int arr[]=new int[a1.length+a2.length+1];
    int i=0;int j=0;
    int k=0;
    while(i<a1.length&&j<a2.length){
        if(a1[i]<=a2[j]){
            arr[k]=a1[i];
            i++;
            k++;
        }else {
            arr[k] = a2[j];
            j++;
            k++;
        }
    }
        Arrays.stream(arr).forEach(e-> System.out.println(e));
    }


}
