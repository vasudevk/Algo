import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by amit.k.mannur on 4/6/2018.
 */

public class Queue {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(2);
        queue.add(1);
        queue.add(7);
        queue.add(2);
        queue.add(3);

        System.out.println(queue);

        List<Integer> integers = new ArrayList<>(2);
        integers.add(2);
        integers.add(4);
        integers.add(1);
        integers.add(5);

        System.out.println(integers);

        Map<Integer,String> integers1=new LinkedHashMap<Integer,String>(4,1f,true);

        integers1.put(1,"aaa");
        integers1.put(4,"a");
        integers1.put(10,"a");
        integers1.put(8,"a");
        integers1.put(9,"a");
        integers1.put(18,"aa");
        integers1.put(4,"b");

        System.out.println( integers1.size());
        System.out.println(integers1);



    }
}
