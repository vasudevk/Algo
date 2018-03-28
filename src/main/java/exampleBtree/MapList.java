package exampleBtree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Stream;

public class MapList {

    public static final String RESOURCES_FILE = "resoucetest.txt";
    public static final String DELIMITER = "/";

    public static void main(String arg[]) throws IOException, URISyntaxException {
        Map<String, LinkedHashSet<LinkedHashSet<String>>> characterListMap = new ConcurrentHashMap<>();
        List<String> data = getData();
        Optional.ofNullable(data).orElseGet(Collections::emptyList).forEach((String line) -> {
            String[] splitString = line.split(DELIMITER);
            if(characterListMap.keySet().size()==0){
                LinkedHashSet<LinkedHashSet<String>> linkedHashSets=new LinkedHashSet<>();
                LinkedHashSet<String> stringList1 = new LinkedHashSet<String>();
                stringList1.add(splitString[1]);
                linkedHashSets.add(stringList1);
                characterListMap.put(splitString[0], linkedHashSets);
            }
            /* A/B
            B/C
            C/D
            A/F*/
            if (characterListMap.containsKey(splitString[0])) {
                LinkedHashSet<LinkedHashSet<String>> linkedHashSets1= characterListMap.get(splitString[0]);
                linkedHashSets1.stream().findFirst().get().add(splitString[1]);
                characterListMap.put(splitString[0],linkedHashSets1);
            } else {
               characterListMap.keySet().stream().forEach((String e) -> {
                     /*if (characterListMap.get(e).contains(splitString[0])) {
                        LinkedHashSet<String> stringList1 = new LinkedHashSet<String>();
                        stringList1.add(splitString[1]);

                        characterListMap.get(e).add(stringList1);
                    } else {
                        LinkedHashSet<String> stringList1 = new LinkedHashSet<String>();
                        stringList1.add(splitString[1]);
                        LinkedHashSet<LinkedHashSet<String>> linkedHashSets1= new LinkedHashSet<>();
                        linkedHashSets1.add(stringList1);
                        characterListMap.put("" + splitString[0], linkedHashSets1);
                    }*/
                   characterListMap.get(e).stream().forEach(e2->{
                      if(e2.contains(splitString[0])){
                          LinkedHashSet<String> stringList1 = new LinkedHashSet<String>();
                          stringList1.add(splitString[1]);
                          characterListMap.get(e).add(stringList1);
                       }
                      else {
                          LinkedHashSet<String> stringList1 = new LinkedHashSet<String>();
                          stringList1.add(splitString[1]);
                          LinkedHashSet<LinkedHashSet<String>> linkedHashSets1= new LinkedHashSet<>();
                          linkedHashSets1.add(stringList1);
                          characterListMap.put( splitString[0], linkedHashSets1);
                      }
                   });

                });
            }
        });
        System.out.println(characterListMap);
    }

    public static List<String> getData() throws IOException, URISyntaxException {
        Path path = Paths.get(Testclass.class.getClassLoader().getResource(RESOURCES_FILE).toURI());
        List<String> data = new CopyOnWriteArrayList<>();
        Stream<String> lines = Files.lines(path);
        lines.forEach(data::add);
        lines.close();
        return data;
    }
}
