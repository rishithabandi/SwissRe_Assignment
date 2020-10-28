package com.bob.rest.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

public class FileParser {


    public static Map<String, Integer> readPropertiesFile(String fileName) throws IOException {
        String delimiter = "=";
        Map<String, Integer> map = new LinkedHashMap<>();

        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
            lines.filter(line -> line.contains(delimiter)).forEach(
                    line -> map.putIfAbsent(line.split(delimiter)[0], Integer.parseInt(line.split(delimiter)[1]))
            );
        }

        return map;

    }


}
