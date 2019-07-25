//import java.util.HashMap;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Sindhu {
//
//    private static String getRanking(char[] ch) {
//        HashMap<char[], Integer> hashMap = new HashMap<>();
//        int len = ch.length;
//        for (int i = 0; i < len; i++) {
//            if (!hashMap.containsValue(ch[i])) {
//                hashMap.put(ch, i);
//            } else {
//                hashMap.put(ch, hashMap.get(ch[i]) + 1);
//            }
//        }
//
//        int size = hashMap.size();
//        for (int i)
//
//        return null;
//    }
//}
//
//
////public class Test {
////    public static void main(String[] args) {
////
////        String str = "ramakoteswararao";
////
////        char[] char_array = str.toCharArray();
////
////        System.out.println("The Given String is : " + str);
////
////        Map<Character, Integer> charCounter = new TreeMap<Character, Integer>();
////
////        for (char i : char_array) {
////
////            charCounter.put(i, charCounter.get(i) == null ? 1 : charCounter.get(i) + 1);
////
////        }
////
////        for (Character key : charCounter.keySet()) {
////            System.out.println("occurrence of '" + key + "' is  " + charCounter.get(key));
////        }
////
////    }
////
////}