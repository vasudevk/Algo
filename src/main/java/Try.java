import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Try {

    static Map<String, Integer> magazineMap;
    static boolean isValid;

    public static void main(String... as) {


        /*StringBuilder stringBuilder = new StringBuilder("amit");
        System.out.println(stringBuilder.insert(0, 'c'));
        solution("I am inside", "I inside am ");
        System.out.println("solution1: " + solve());
        solution2("I am inside i", "I inside am i");
        System.out.println("solution2: " + solve());

        int[] asd = {1, 5, 11, 5};
        Arrays.sort(asd);
        System.out.println(findMedian(asd, asd.length));*/
        permutations("", "abba");

        List<String> list=new ArrayList<>();
        list.add("amit");
        list.add("asd2");
        list.add("werwer");
        System.out.println(list);
        list.add(0,"singhu");
        System.out.println(list);





    }





    public static void solution(String magazine, String note) {
        magazineMap = new HashMap<String, Integer>();
        isValid = true;

        for (String word : magazine.split(" ")) {
            Integer i = magazineMap.get(word);

            if (i == null) {
                magazineMap.put(word, 1);
            } else {
                magazineMap.put(word, i + 1);
            }
        }

        for (String word : note.split(" ")) {
            Integer i = magazineMap.get(word);

            if (i == null || magazineMap.get(word) == 0) {
                isValid = false;
                break;
            } else {
                magazineMap.put(word, i - 1);
            }
        }
    }

    public static void solution2(String magazine, String note) {
        List magazineArray = Arrays.asList(magazine.split(" "));
        List noteArray = Arrays.asList(note.split(" "));

        String[] a = magazine.split(" ");
        Arrays.sort(a);
        System.out.println(Arrays.deepToString(a));
        String[] b = note.split(" ");
        Arrays.sort(b);

        isValid = magazineArray.containsAll(noteArray);
    }

    public static boolean solve() {
        return isValid;
    }


    static int findMedian(int[] asd, int size) {
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = asd[0];
        for (int i = 1; i < size; i++) {
            left[i] = left[i - 1] + asd[i];
        }
        right[size - 1] = asd[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = right[i + 1] + asd[i];
        }

        for (int i = 0; i < size; i++) {
            if (left[i] == right[i]) {
                return asd[i];
            }
        }
        return -1;
    }


    static void permutations(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < n; i++) {
               // permutations(prefix + str.charAt(i), str.substring());
            }
        }
    }
}

