package com.bob.rest.client;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FileParserTest {


    @Test(expected = java.io.IOException.class)
    public void openMissingFile() throws IOException {
        FileParser.readPropertiesFile("invalid.txt");
    }

    @Test()
    public void openValidFile() throws IOException {

        String resourceName = "test.txt";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        String absolutePath = file.getAbsolutePath();

        Map<String, Integer> result = FileParser.readPropertiesFile(absolutePath);
        assertNotNull(result);

        assertEquals(result.get("BTC"), Integer.valueOf(10));

    }


}
