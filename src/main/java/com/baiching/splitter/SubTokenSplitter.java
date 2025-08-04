package com.baiching.splitter;

import java.util.Arrays;
import java.util.List;

public class SubTokenSplitter {
    /*
    * Splits paths based on dot, hyphen, underscore and backward slash
     */
    public List<String> split(String path){
        //path = path.split("/");

        // "[._-]"
        List<String> tokens = Arrays.asList(path.split("[./_\\\\-]"));

        return tokens;
    }
}
