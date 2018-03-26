import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 12/27/2017.
 */
// Java program to find the maximum repeating number

class MaxRepeating {

    static int maxRepeating(int a[], int n)
    {
        for (int i = 0; i< n; i++)
            a[(a[i] % a.length)] = a[(a[i] % a.length)] + a.length;

        int max = a[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (a[i] > max)
            {
                max = a[i];
                result = i;
            }
        }
        return result;
    }

    public static void main (String[] args)
    {
        //onlt single digit
        int arr[] = {2, 3, 3, 3, 3, 4, 1, 7,1,2,2,2,1};
        int n = arr.length;

        System.out.println("Maximum repeating element is: " +
               maxRepeating(arr,n));

        Map<Character, Long> map = "amitaammmaaaaaaaaaaa".chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> ((char) i.intValue()),
                        Collectors.counting()));

        System.out.println(map);
        Map<Character, Long> map2 = "amitamamm".chars()
                .boxed()
                .collect(Collectors.groupingBy(
                        i -> ((char) i.intValue()),
                        Collectors.counting()));
        System.out.println(map2);
        System.out.println(map.equals(map2));

    }
}