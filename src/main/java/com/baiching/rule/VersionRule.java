package com.baiching.rule;

public class VersionRule implements TokenRule{
    @Override
    public boolean matches(String token) {
        if (token.matches("^[vV]\\\\d+(\\\\.\\\\d+)*([-_][A-Za-z0-9]+)*$")) return true;

        return false;
    }

    @Override
    public String getTokenType() {
        return "VERSION";
    }
}
