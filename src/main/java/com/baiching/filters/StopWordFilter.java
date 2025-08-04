package com.baiching.filters;

import java.util.*;

public class StopWordFilter {
    /*
    * creates a set of stopwords from the array
    * @param stopwords stop word array
     */

    public Set<String> createStopWordSet(String[] stopwords) {
        return new HashSet<>(Arrays.asList(Objects.requireNonNull(stopwords, "stopWords")));
    }
}
