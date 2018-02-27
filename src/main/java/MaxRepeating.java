/**
 * Created by amit.k.mannur on 12/27/2017.
 */
// Java program to find the maximum repeating number

class MaxRepeating {

    static int maxRepeating(int arr[], int n, int k)
    {
        for (int i = 0; i< n; i++)
            arr[(arr[i] % arr.length)] = arr[(arr[i] % arr.length)] + arr.length;

        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }
        return result;
    }

    public static void main (String[] args)
    {
        int arr[] = {2, 3, 3, 3, 3, 4, 1, 7,10,2,2,2,3,3,3,3,3,3,3,3,3};
        int n = arr.length;
        int k=1;
        System.out.println("Maximum repeating element is: " +
                maxRepeating(arr,n,k));
    }
}