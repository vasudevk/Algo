import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



/**
 * Created by amit.k.mannur on 3/6/2018.
 */
public class StringNull {

    public static void main(String[] args) {

        List<String> list = new ArrayList();
        list.add("amit");
        list.stream().forEach(e -> System.out.println(e));
        List list2=new ArrayList();
        Set set=new HashSet();
        String a="hg";
        System.out.println(Arrays.asList(a.toCharArray().toString()));
        List<Character> list6 = "amit".chars().mapToObj(i -> (char) i).collect(Collectors.toList());
        System.out.println(list6);
    }
}
