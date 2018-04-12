/**
 * Created by amit.k.mannur on 3/29/2018.
 */

public class ReverseString {

    public static void main(String[] args) {
        String s = "amit is from tmobile oliver team";
        String reverse = "";
        String[] strings = s.split(" ");
        for (int i = strings.length-1; i >= 0; i--) {
            reverse= reverse.concat(strings[i]+" ");
        }
        System.out.println(reverse);
    }
}
