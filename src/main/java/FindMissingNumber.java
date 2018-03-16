import java.util.Arrays;
import java.util.stream.IntStream;

public class FindMissingNumber {
    public static void main(String... s) {

        int[] series = {1, 2, 5, 6, 10};
        int[] numbers = new int[IntStream.of(series).max().getAsInt()+1];
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

        IntStream.range(1,IntStream.of(series).max().getAsInt()).forEach(k->{
            if (numbers[k] == 0)
                System.out.println(k);
        });

    }
}
