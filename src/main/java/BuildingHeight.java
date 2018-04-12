/**
 * Created by amit.k.mannur on 3/29/2018.
 */

public class BuildingHeight {

    public static void main(String[] args) {
        int[][] ints={{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(maxIncreaseKeepingSkyline(ints));
    }
        public static int maxIncreaseKeepingSkyline(int[][] grid) {
            int N = grid.length;
            int[] rowMaxes = new int[N];
            int[] colMaxes = new int[N];

            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c) {
                    rowMaxes[r] = Math.max(rowMaxes[r], grid[r][c]);
                    colMaxes[c] = Math.max(colMaxes[c], grid[r][c]);
                }

            int ans = 0;
            for (int r = 0; r < N; ++r)
                for (int c = 0; c < N; ++c)
                    ans += Math.min(rowMaxes[r], colMaxes[c]) - grid[r][c];

            return ans;
    }
}
