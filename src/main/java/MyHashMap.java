/**
 * Created by amit.k.mannur on 4/9/2018.
 */

public class MyHashMap {
    // for better re-sizing is taken as 2^4
    private static final int SIZE = 1;

    private Entry table[] = new Entry[SIZE];

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul", "SSE");
        myHashMap.put("Sattu", "SE");
        myHashMap.put("Gaurav", "SE");
        myHashMap.put("Awadh", "SSE");
        myHashMap.put("Rahul1", "SSE");
        myHashMap.put("Sattu1", "SE");
        myHashMap.put("Gaurav1", "SE");
        myHashMap.put("Awadh1", "SSE");
        myHashMap.put("Rahul2", "SSE");
        myHashMap.put("Sattu2", "SE");
        myHashMap.put("Gaurav2", "SE");

        Entry e = myHashMap.get("Awadh");
        System.out.println("" + e.getValue());
    }

    /**
     * Returns the entry mapped to key in the HashMap.
     */
    public Entry get(String k) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        // Bucket is identified by hashCode and traversed the bucket
        // till element is not found.
        while (e != null) {
            if (e.key.equals(k)) {
                return e;
            }
            e = e.next;
        }
        return null;
    }

    /**
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(String k, String v) {
        int hash = k.hashCode() % SIZE;
        Entry e = table[hash];

        if (e != null) {
            // If we will insert duplicate key-value pair,
            // Old value will be replaced by new one.
            if (e.key.equals(k)) {
                e.value = v;
            } else {
                // Collision: insert new element at the end of list
                // in the same bucket
                while (e.next != null) {
                    e = e.next;
                }
                e.next = new Entry(k, v);
            }
        } else {
            // create new bucket for new element in the map.
            table[hash] = new Entry(k, v);
        }
    }

    /**
     * To store the Map data in key and value pair.
     * Used linked list approach to avoid the collisions
     */
    class Entry {
        final String key;
        String value;
        Entry next;

        Entry(String k, String v) {
            key = k;
            value = v;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getKey() {
            return key;
        }
    }
}
