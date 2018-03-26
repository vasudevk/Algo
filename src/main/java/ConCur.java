import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

/**
 * Created by amit.k.mannur on 3/25/2018.
 */

public class ConCur {

    public static void main(String[] args) {
        List<String> strings=new ArrayList<>();
        String s="jack Jill went up hill's Jack's head. went and fell down the hill. jack was injured".toLowerCase();
        s=s.replace(".","");
        s=s.replace("'"," ");
        String[] strings1=s.split(" ");

        strings= Arrays.asList(strings1);

        List<String> strings2= new ArrayList<>(strings);
        Map<String,Long> stringIntegerMap=strings2.stream().collect(Collectors.groupingBy(Function.identity(),counting()));
            stringIntegerMap.forEach((K,V)->{
                if(V>1){
                    System.out.println(K);
                }

            });

        System.out.println(stringIntegerMap);
    }
}


