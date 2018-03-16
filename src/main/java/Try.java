import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Try {

    static Map<String, Integer> magazineMap;
    static boolean isValid;

    public static void main(String... as) {

        solution("I am inside", "I inside am ");
        System.out.println("solution1: " + solve());
        solution2("I am inside i", "I inside am i");
        System.out.println("solution2: " + solve());
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

        String[] a=magazine.split(" ");
        Arrays.sort(a);
        System.out.println(Arrays.deepToString(a));
        String[] b=note.split(" ");
        Arrays.sort(b);

        isValid = magazineArray.containsAll(noteArray);
    }

    public static boolean solve() {
        return isValid;
    }



}

