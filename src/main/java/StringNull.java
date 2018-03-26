import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * Created by amit.k.mannur on 3/6/2018.
 */
public class StringNull {

    public static void main(String[] args) {

        List<String> list = new ArrayList();
        list.add("amit");
        list.stream().forEach(e -> System.out.println(e));
        List list2 = new ArrayList();
        Set set = new HashSet();
        String a = "hg";
        System.out.println(Arrays.asList(a.toCharArray().toString()));
        List<Character> list6 = "amit".chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        System.out.println(list6);
        System.out.println(convertStringToInt("789"));
        System.out.println(strToInt("1289"));


        int mask = 1;
        mask <<= 1;
        System.out.println(mask);


    }

    private static int convertStringToInt(String num) {
        int result = 0;

        for (char c : num.toCharArray()) {
            c -= 48;
            if (c <= 9) {
                result = (result << 3) + (result << 1) + c;
            } else return -1;
        }
        return result;
    }

    private static int strToInt(String str) {
        int i = 0;
        int num = 0;

        //Process each character of the string;
        while (i < str.length()) {
            num *= 10;
            num += str.charAt(i++) - '0'; //Minus the ASCII code of '0' to get the value of the charAt(i++).
        }
        return num;
    }


}
