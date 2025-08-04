package com.baiching.filters;

import java.util.List;

public interface TokenFilter {
    List<String> process(List<String> tokens);
}
