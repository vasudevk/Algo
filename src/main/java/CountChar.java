import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 11/15/2017.
 */
public class CountChar {

    public static void main(String[] as) throws IOException {
        CountChar countChar = new CountChar();
        countChar.countChar();
    }

    private void countChar() throws IOException {
        HashMap hashMap = new HashMap();
        List<Character> list = new ArrayList();
        list = "aabbac".chars().mapToObj(r -> (char) r ).collect(Collectors.toList());
        //int s= list.stream().reduce((a,b)->a+b).get();

        list.forEach(e -> {
            hashMap.computeIfPresent(e, (K, V) -> (int) V + 1);
            hashMap.computeIfAbsent(e, (V) -> 1);
        });
        hashMap.forEach((k,v)->{
            if((int)v>1)
            System.out.println(k+":"+v);
        });
        System.out.println(hashMap);

    }

    private void countCharMap() throws IOException {
        HashMap hashMap = new HashMap();
        List<Character> list = new ArrayList();
        list = "aabbac".chars().mapToObj(r -> (char) r ).collect(Collectors.toList());
        char[] chars="aabbac".toCharArray();
        System.out.println(hashMap);

    }
}
