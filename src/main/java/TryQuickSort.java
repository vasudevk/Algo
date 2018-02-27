/**
 * Created by amit.k.mannur on 9/2/2017.
 */
public class TryQuickSort {

    public static void main(String... asd){
        int arr[]={1,2,5,1,99,3,8,2,5,8};
        TryQuickSort tryQuickSort=new TryQuickSort();
        tryQuickSort.sort(arr,0,arr.length-1);
        printArray(arr);
    }

    private void sort(int arr[],int low,int high){
        int i=low;int j=high;
        int middle=arr[(high+low)/2];
        while(i<=j){
            while(arr[i]<middle){
                i++;
            }while(arr[j]>middle){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;

                i++;
                j--;
            }
        }
        if (low < j)
            sort(arr,low, j);
        if (i < high)
            sort(arr,i, high);

    }
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}

