package com.leetcode.codeguru;
import com.fasterxml.jackson.databind.ObjectMapper;;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.util.*;

import com.google.common.io.Resources;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class RunSolution extends ClassLoader {

    static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

    private static Map<String, String> mapLeetcodeProblems() throws Exception {

        String mappingValues = "";
        try (InputStream props = Resources.getResource("leetcode.properties").openStream()) {
            Properties properties = new Properties();
            properties.load(props);
            mappingValues = properties.get("lookup").toString();
        }

        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();

        // Deserialization into a Map
        Map<String, String> result = objectMapper.readValue(mappingValues, Map.class);

        return result;

    }

    public static void main(String[] args) throws Exception {

        JavaClassLoader javaClassLoader = new JavaClassLoader();
        Map<String, String> mapLeetcode;
        String packageName = "com.leetcode.codeguru";
        String delimiter = "\\.";
        String[] items = args[0].split(delimiter);

        if (args[0].equals("leetcode")) {
            mapLeetcode = mapLeetcodeProblems();
            items = mapLeetcode.get(args[1]).split(delimiter);
            javaClassLoader.invokeClassMethod(packageName + "." + items[0] + "." + items[1]
                                              ,items[2]);
        } else

            javaClassLoader.invokeClassMethod(packageName + "."  + items[0] + "."  + items[1]
                                               ,items[2]);

    }

}
