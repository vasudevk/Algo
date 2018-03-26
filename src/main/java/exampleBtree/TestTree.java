package exampleBtree;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTree {

    public static final String DELIMITER = "/";

    public static final String RESOURCES_FILE = "resoucetest.txt";

    public static void main(String arg[]) throws IOException, URISyntaxException {
        List<String> data =  getData();
        data.forEach(line -> {
            String[] splitString = line.split(DELIMITER);
            TreeModel treeModel = new TreeModel(splitString[1]);
            List<String> filteredList = data.stream()
                    .filter(e -> !e.equalsIgnoreCase(line)).collect(Collectors.toCollection(CopyOnWriteArrayList::new));
            List<String> toConcat = ispresent(splitString[1], filteredList, treeModel);
        });
    }

    /**
     * Method to verify if the element is eligible to conact with its parent.
     *
     * @param s
     * @param filteredList
     * @param treeModel
     * @return
     */
    private static List<String> ispresent(String s, List<String> filteredList, TreeModel treeModel) {
        for (String line : filteredList) {
            String[] splitString = line.split(DELIMITER);
            if (s.equalsIgnoreCase(splitString[0])){
                filteredList.remove(line);
                treeModel.addChild(splitString[1]);
            }
        }
        return null;
    }

    /**
     * Method to read the resources file and add each line in list
     *
     * @return
     * @throws IOException
     * @throws URISyntaxException
     */
    public static List<String> getData() throws IOException, URISyntaxException {
        Path path = Paths.get(Testclass.class.getClassLoader().getResource(RESOURCES_FILE).toURI());
        List<String> data = new CopyOnWriteArrayList<>();
        Stream<String> lines = Files.lines(path);
        lines.forEach(line -> data.add(line));
        lines.close();
        return data;
    }
}
