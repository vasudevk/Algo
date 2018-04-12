import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by amit.k.mannur on 4/10/2018.
 */

public class LRUWithLinkedHashMap {
    int capacity = 3;
    Map<String, String> map = new LinkedHashMap<>();

    LRUWithLinkedHashMap(Map<String, String> map) {
        this.map = map;
    }

    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>(3,0.9f,true);
        LRUWithLinkedHashMap lruWithLinkedHashMap = new LRUWithLinkedHashMap(map);
        lruWithLinkedHashMap.put("k1", "v1");
        lruWithLinkedHashMap.put("k2", "v2");
        lruWithLinkedHashMap.put("k1", "v3");

        lruWithLinkedHashMap.print();


    }

    void put(String k, String v) {
        if (map.containsKey(k) &&capacity == map.size() ) {
            map.remove(k);
        }
        if (capacity == map.size()) {
            String remove=null;
            for (String key : map.keySet()) {
                remove = key;
                break;
            }
            map.remove(remove);
        }
        map.put(k, v);
    }

    void print() {
        System.out.println(map);
    }
}
