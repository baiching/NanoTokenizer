package com.baiching.core;

import java.util.Arrays;
import java.util.List;

public class FilePathTokenizer {
    /*
    *
    * This is a simplest tokenizer. It takes file path as input then breaks it based on '/'
    * sign and breaks each as an element in a list
     */

    public List<String> tokenize(String path) {
        path = path.replace( '\\', '/');

        List<String> tokens = Arrays.asList(path.split("/"));

        return tokens;
    }
}
