package com.baiching.filters;

import java.util.List;
import java.util.stream.Collectors;

public class LowerCaseFilter implements TokenFilter {
    /*
    * This method converts elements in this list to lowercase letters
     */
    @Override
    public List<String> process(List<String> tokens) {
        return tokens.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
