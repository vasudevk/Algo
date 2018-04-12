/**
 * Created by amit.k.mannur on 4/10/2018.
 */

import java.util.HashMap;
import java.util.Stack;
public class LRU {
    private HashMap<String,Object> map;
    private Stack<String> stack;
    private int capacity;
    LRU(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<String, Object>(capacity);
        this.stack = new Stack<String>();
    }
    public void put(String key, Object value){
        if(map.containsKey(key) || this.capacity < map.size() + 1) {
            String remove;
            if(map.containsKey(key)){
                remove = key;
            }else{
                remove = this.stack.firstElement();
            }
            this.stack.removeElement(remove);
            this.map.remove(remove);
        }
        this.map.put(key, value);
        this.stack.add(key);
    }
    Stack<String> display(){
        return this.stack;
    }
    public Object get(String key){
        Object value = map.get(key);
        put(key, value);
        return value;
    }


    public static void main(String[] args) {

        LRU lru = new LRU(3);
        lru.put("k1","v1");
        lru.put("k2","v2");
        lru.put("k3","v3");
        lru.put("k4","v4");
        lru.put("k1","v1.1");
        System.out.println(lru.display());
        lru.get("k2");
        System.out.println(lru.display());
        lru.put("k4","v4");
        System.out.println(lru.display());
    }
}