/**
 * Created by amit.k.mannur on 8/31/2017.
 */
public class FirstOccuranceOfDigit {

    public static int FirstOccurrence(String inputString) {
        char c[] = inputString.toCharArray();
        for (int i = 0; i < inputString.length(); i++) {
                int ch = '1';
                int chh = '9';
                if (ch<=c[i] && c[i]<=chh) {
                    Character.getNumericValue(ch);
                   return i+1;
            }
        }
        return 0;
    }

    public static void main(String... s) {
        System.out.println(FirstOccurrence("amit1amit"));
    }
}
