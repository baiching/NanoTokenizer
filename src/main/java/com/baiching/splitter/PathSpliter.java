package com.baiching.splitter;

import java.util.Arrays;
import java.util.List;

public class PathSpliter {
    public List<String> pathSplit(String path) {
        List<String> tokens = Arrays.asList(path.split("/"));

        return tokens;
    }
}
