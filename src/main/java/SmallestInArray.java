/**
 * Created by amit.k.mannur on 3/27/2018.
 */

public class SmallestInArray {

    static void print2Smallest(int arr[])
    {
        int first, second, arr_size = arr.length;

        if (arr_size < 2)
        {
            System.out.println(" Invalid Input ");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (int anArr : arr) {

            if (anArr < first) {
                second = first;
                first = anArr;
            } else if (anArr < second && anArr != first)
                second = anArr;
        }
        if (second == Integer.MAX_VALUE)
            System.out.println("There is no second" +
                    "smallest element");
        else
            System.out.println("The smallest element is " +
                    first + " and second Smallest" +
                    " element is " + second);
    }

    /* Driver program to test above functions */
    public static void main (String[] args)
    {
        int arr[] = {12, 13, 1, 10, 34, 1};
        print2Smallest(arr);
    }
}
