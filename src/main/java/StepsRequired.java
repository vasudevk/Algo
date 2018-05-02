/**
 * Created by amit.k.mannur on 4/14/2018.
 */

public class StepsRequired {
    // Function to count number of steps
    // required to reach a destination

    // source -> source vertex
    // step -> value of last step taken
    // dest -> destination vertex
    static int steps(int source, int step,
                     int dest) {
        // base cases
        if (Math.abs(source) > (dest))
            return Integer.MAX_VALUE;

        if (source == dest)
            return step;

        // at each point we can go either way

        // if we go on positive side
        int pos = steps(source + step + 1,
                step + 1, dest);

        // if we go on negative side
        int neg = steps(source - step - 1,
                step + 1, dest);

        // minimum of both cases
        return Math.min(pos, neg);
    }

    // Driver Code
    public static void main(String[] args) {
        int dest = 11;
        System.out.println("No. of steps required" +
                " to reach " + dest +
                " is " + steps(0, 0, dest));
    }
}
