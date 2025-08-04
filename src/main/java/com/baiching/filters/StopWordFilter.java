package com.baiching.filters;

import java.util.*;

public class StopWordFilter {
    /*
    * creates a set of stopwords from the array
    *
    * @param stopwords stop word array
    * @return a Set containing stopWords
     */

    public Set<String> createStopWordSet(String[] stopwords) {
        return new HashSet<>(Arrays.asList(Objects.requireNonNull(stopwords, "stopWords")));
    }

    /*
     * creates a set of stopwords from the String List
     *
     * @param stopwords stop word List
     * @return a Set containing stopWords
     */

    public Set<String> createStopWordSet(List<String> stopWords) {
        Objects.requireNonNull(stopWords, "stopWords");
        return new HashSet<>(stopWords);
    }
}
