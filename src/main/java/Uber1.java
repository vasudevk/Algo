/**
 * Created by amit.k.mannur on 3/29/2018.
 */

public class Uber1 {

        private static String findSubstring(String word, String[] parts) {
            int maxLength = 0;
            int maxIndex = 0;
            String maxPart = parts[0];
            boolean matchFound = false;
            for(String part: parts) {
                int index = word.indexOf( part );
                if(index >= 0) {
                    int length = part.length();
                    if(maxLength < length) {
                        maxLength = length;
                        maxPart = part;
                        maxIndex = index;
                        matchFound = true;
                    }
                }
            }

            if(matchFound) {
                String first = word.substring(0, maxIndex);
                String last = word.substring(maxIndex + maxPart.length(), word.length());

                return first + "[" + maxPart + "]" + last;
            }
            return word;
        }

        private static String[] findSubstrings(String[] words, String[] parts) {
            String[] newWords = new String[words.length];
            int i = 0;
            for(String word : words) {
                newWords[i++] = findSubstring(word, parts);
            }
            return newWords;
        }
        public static void main(String[] args) {
            String words[] = {"Apple", "Melon", "Orange", "Watermelon"};
            String parts[] = {"a", "mel", "lon", "el", "An"};

            String[] newWords = findSubstrings(words, parts);
            for (String word: newWords ) {
                System.out.println(word);
            }
        }
}
