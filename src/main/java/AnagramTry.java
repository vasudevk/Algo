import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit.k.mannur on 3/12/2018.
 */
public class AnagramTry {
    public static void main(String[] as){
        String[] anna={"cat","dog","tac","god","gdo","asd"};

        checkAnnagram(anna);
    }

    private static void checkAnnagram(String[] anna) {
       for(int i=0;i<anna.length;i++){
           for(int j=i;j<anna.length-1;j++)
               if(anna[i].length()==anna[j+1].length()){
                   List<Character> str1=new ArrayList<>();
                   List<Character> str2=new ArrayList<>();
                   Character[] charObjectArray =
                           anna[i].chars().mapToObj(c -> (char)c).toArray(Character[]::new);
                   str1=Arrays.asList(charObjectArray);
                   str2=Arrays.asList(anna[j+1].chars().mapToObj(c -> (char)c).toArray(Character[]::new));

                   if(str1.containsAll(str2)){
                      // System.out.println("annagram is :"+str1+"  "+str2);
                       Map<List<Character>,String> map=new HashMap<>();
                       map.put(str1,str1+"  "+str2);
                       System.out.println(map);
                   }
               }
           }
       }
}
