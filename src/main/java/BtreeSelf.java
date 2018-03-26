import exampleBtree.Testclass;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Stream;

/**
 * Created by amit.k.mannur on 3/16/2018.
 */
public class BtreeSelf {

    public static final String RESOURCES_FILE = "resoucetest.txt";
    public static final String DELIMITER = "/";
    static List<String> btreeList = new ArrayList<>();
    static Map<String, LinkedHashSet<String>> btreemap = new ConcurrentHashMap<>();
    static int i = 0;
    String data;
    List<String> list;

    public BtreeSelf(String data, List<String> list) {
        this.data = data;
        this.list = new ArrayList<>();
    }

    public static void main(String[] as) throws IOException, URISyntaxException {
        Set<String> data = getData();
        Optional.ofNullable(data).orElseGet(Collections::emptySet).forEach((String line) -> {
            String[] splitString = line.split(DELIMITER);
            if (btreemap.isEmpty()) {
                LinkedHashSet<String> list1 = new LinkedHashSet<>();
                list1.add(splitString[1]);
                btreemap.put(splitString[0], list1);
            } else {
                if (btreemap.containsKey(splitString[0])) {
                    if (btreemap.get(splitString[0]).contains(splitString[1])) {
                        btreemap.get(splitString[0] + 1).add(splitString[1]);
                    } else {
                        LinkedHashSet<String> list1 = new LinkedHashSet<>();
                        list1.add(splitString[1]);
                        btreemap.put(splitString[0] + 1, list1);
                    }
                } else {
          /*A/B
            B/C
            C/D
            A/F*/
                    btreemap.keySet().stream().forEach(e -> {
                        LinkedHashSet<String> strings = btreemap.get(e);
                        int index = new ArrayList<String>(strings).indexOf(splitString[0]);
                        if (btreemap.get(e).contains(splitString[0])) {
                            if (index == btreemap.get(e).size() - 1) {
                                btreemap.get(e).add(splitString[1]);
                            }else{
                                LinkedHashSet<String> list1 = new LinkedHashSet<>();
                                list1.add(splitString[0]);
                                list1.add(splitString[1]);
                                btreemap.put(e + 2, list1);
                            }
                        } else {
                            LinkedHashSet<String> list1 = new LinkedHashSet<>();
                            list1.add(splitString[1]);
                            btreemap.put(splitString[0], list1);
                        }
                    });
                }
            }
        });


        printMap(btreemap);
    }

    private static void printMap(Map<String, LinkedHashSet<String>> btreemap) {
        StringBuffer print1 = new StringBuffer();
        btreemap.keySet().stream().forEach(e -> {
            print1.append(e);
            btreemap.get(e).stream().forEach(e1 -> {
                print1.append("/" + e1);
            });
            print1.append("\n");
        });

        System.out.println(print1.toString().replaceAll("\\d+", ""));
    }

    public static Set<String> getData() throws IOException, URISyntaxException {
        Path path = Paths.get(Testclass.class.getClassLoader().getResource(RESOURCES_FILE).toURI());
        Set<String> data = new CopyOnWriteArraySet<>();
        Stream<String> lines = Files.lines(path);
        lines.forEach(data::add);
        lines.close();
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BtreeSelf btreeSelf = (BtreeSelf) o;

        return data != null ? data.equals(btreeSelf.data) : btreeSelf.data == null;
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
