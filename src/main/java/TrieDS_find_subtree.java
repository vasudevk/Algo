import java.util.ArrayList;
import java.util.List;

// Java implementation of search and insert operations
// on Trie
public class TrieDS_find_subtree {

    // Alphabet size (# of symbols)

    // trie node
    static class TrieNode {
        List<TrieNode> trieNodes = new ArrayList<TrieNode>();
        boolean isLeaf;

        TrieNode() {
            isLeaf = false;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "trieNodes=" + trieNodes +
                    '}';
        }
    }


    static TrieNode root;

    // If not present, inserts key into trie
    // If the key is prefix of trie node,
    // just marks leaf node
    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';
            if (index > pCrawl.trieNodes.size()) {
                for (int i = 0; i < index; i++) {
                    pCrawl.trieNodes.add(new TrieNode());
                }
                pCrawl.trieNodes.add(index, new TrieNode());
            }

            pCrawl = pCrawl.trieNodes.get(index);
        }

        // mark last node as leaf
        pCrawl.isLeaf = true;
    }

    // Returns true if key presents in trie, else false
    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;
        for (level = 0; level < length; level++) {
            index = key.charAt(level) - 'a';

            if (index >= pCrawl.trieNodes.size()) {
                return false;
            }


            pCrawl = pCrawl.trieNodes.get(index);
        }

        return (pCrawl != null && pCrawl.isLeaf);
    }

    // Driver
    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};


        root = new TrieNode();

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++)
            insert(keys[i]);

        // Search for different keys
        if (search("the"))
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if (search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if (search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if (search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);

    }
}
// This code is contributed by Sumit Ghosh