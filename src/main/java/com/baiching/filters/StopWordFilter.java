package com.baiching.filters;

import java.util.*;

public class StopWordFilter {
    private final Set<String> stopWords;

    public StopWordFilter(Set<String> stopWords) {
        this.stopWords = Objects.requireNonNull(stopWords, "StopWords cannot be null");
    }
    /**
     * Filters out stopwords from a list of tokens.
     * @param tokens Input tokens (e.g., ["the", "quick", "brown", "fox"])
     * @return Filtered tokens (e.g., ["quick", "brown", "fox"])
     */
    public List<String> filterStopWords(List<String> tokens) {
        List<String> filteredTokens = new ArrayList<>();
        for (String token: tokens) {
            if (!stopWords.contains(token.toLowerCase())) {
                filteredTokens.add(token);
            }
        }

        return filteredTokens;
    }

    /**
    * creates a set of stopwords from the array
    *
    * @param stopWords stop word array
    * @return a Set containing stopWords
     */
    public static Set<String> createStopWordSet(String[] stopwords) {
        return new HashSet<>(Arrays.asList(Objects.requireNonNull(stopwords, "stopWords")));
    }

    /**
     * creates a set of stopwords from the String List
     *
     * @param stopWords stop word List
     * @return a Set containing stopWords
     */

    public static Set<String> createStopWordSet(List<String> stopWords) {
        Objects.requireNonNull(stopWords, "stopWords");
        return new HashSet<>(stopWords);
    }
}
