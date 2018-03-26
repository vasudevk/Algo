import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMissingNumber {
    public static void main(String... s) {

        int[] series = {0};
        int[] numbers = new int[series.length+1];
        /*for (int u : series) {
            numbers[(char) u] = 1;
    }*/
        Arrays.stream(series).forEach(e->{
            numbers[(char) e] = 1;
        }) ;
        /*for (int k = 1; k < IntStream.of(series).max().getAsInt(); k++) {
            if (numbers[k] == 0)
                System.out.println(k);
        }*/

        IntStream.range(0,series.length+1).forEach(k->{
            if (numbers[k] == 0)
                System.out.println(k);
        });

    }
}
