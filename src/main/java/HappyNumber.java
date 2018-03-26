import java.util.HashSet;

/**
 * Created by amit.k.mannur on 3/24/2018.
 */

public class HappyNumber {
    public static void main(String[] args) {
        int num=19;
        if(isHappyNumber(num)){
            System.out.println(true);
        }
    }

    private static boolean isHappyNumber(int n) {
        HashSet<Integer> set = new HashSet<Integer>();

        while(!set.contains(n)){
            set.add(n);

            n = getSum(n);

            if(n==1)
                return true;
        }

        return false;
    }

    static int getSum(int n){
        int sum =0;
        while(n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }
}
