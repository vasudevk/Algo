package Anish;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by amit.k.mannur on 3/31/2018.
 */

public class Helper {

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> strings = Arrays.stream(readFile("data.txt").replace("\r", "").replace("job_type", "\njob_type").split("\\n")).filter(e -> !(e.length() < 1)).collect(Collectors.toList());
        Map<String, List<String>> stringListMap = new LinkedHashMap<>();
        for (String string : strings) {
            if (string.contains("-----")) {
                continue;
            } else {
                String[] strings1 = string.split(":", 2);
                List<String> stringList = new ArrayList<>();
                stringList.add("||");
                stringListMap.put(strings1[0].trim(), stringList);
            }
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        stringListMap.forEach((K, V) -> {
            stringBuilder1.append(K + "|");

        });
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
        writer.write(stringBuilder1.toString() + "\n");
        for (int i = 0; i < strings.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (strings.get(i).contains("/* -----")) {
                if (strings.get(i).contains("/* -----") && i > 0) {
                    stringBuilder.delete(0, stringBuilder.length());
                    stringListMap.forEach((K, V) -> {
                        if(!V.isEmpty())
                        stringBuilder.append(V.get(0));
                        else
                            stringBuilder.append("|");
                    });
                    writer.write(stringBuilder.toString() + "\n");
                    stringListMap.forEach((K,V)->{
                        V.clear();
                    });
                }
                continue;
            } else {
                String[] strings1 = strings.get(i).split(":", 2);
                stringListMap.get(strings1[0].trim()).clear();
                stringListMap.get(strings1[0].trim()).add(strings1[1].trim() + "|");
            }
        }
        writer.close();
    }

    private static String readFile(String resourceFile) throws IOException, URISyntaxException {

        ClassPathResource cpr = new ClassPathResource(resourceFile);
        byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        return new String(bdata, StandardCharsets.UTF_8);
    }
}
