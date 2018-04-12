/**
 * Created by amit.k.mannur on 8/31/2017.
 */
public class FirstOccuranceOfDigit {

    public static int FirstOccurrence(String inputString) {
        char c[] = inputString.toCharArray();
        for (int i = 0; i < inputString.length(); i++) {
            int ch = '1';
            int chh = '9';
            if (ch <= c[i] && c[i] <= chh) {
                return i + 1;
            }
        }
        return 0;
    }

    static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';

    }

    public static void main(String... s) {
        System.out.println(FirstOccurrence("amit1amit"));
        stringToNumberRep("dog2cat32");
    }

    static void stringToNumberRep(String str) {

        char c[] = str.toCharArray();

        String s = "";
        for (char c1 : c) {
            if (isDigit(c1)) {
                String digit = "";
                for (int i = str.indexOf(c1); i < str.length(); i++) {
                    if (isDigit(str.charAt(i))) {
                        digit = digit.concat(String.valueOf(c1));
                    }else{
                        break;
                    }
                }
                System.out.println(s + " = " + digit);
                s = "";
                digit="";
            } else {
                s = s.concat("" + c1);
            }
        }
    }
}
