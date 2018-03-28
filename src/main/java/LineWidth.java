import java.util.Arrays;

/**
 * Created by amit.k.mannur on 3/26/2018.
 */

public class LineWidth {

    public static void main(String[] args) {
        int[] widths = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "bbbcccdddaaa";
        String s2 = "amit adsf fasdef ac aegd efa sfdsagada werwd vascg asdfadsfadsfjgjhgjhgj h";
        int width2 = 15;
        System.out.println(Arrays.deepToString(new int[][]{numberOfLines(widths, s)}));
        System.out.println(Arrays.deepToString(new int[][]{numberOfLinesString(width2, s2)}));
    }


    private static int[] numberOfLines(int[] widths, String s) {
        int lines = 1, width = 0;
        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];
            width = width + w;
            if (width > 100) {
                lines++;
                width = w;
            }
        }

        return new int[]{lines, width};
    }

    private static int[] numberOfLinesString(int width2, String s2) {
        int lines = 1, width = 0;
        for (String s1 : s2.split(" ")) {
            int w = s1.length();
            width = width + w;
            System.out.print(s1 + " ");
            if (width > width2) {
                //gives line number
                lines++;
                //w gives last word length
                width = w;
                System.out.println();
            }
        }

        return new int[]{lines - 1, width};
    }
}
