package com.baiching.rule;

public interface TokenRule {
    boolean matches(String token);
    String getTokenType();
}
