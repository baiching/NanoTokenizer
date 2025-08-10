package com.baiching.rule;

public class VersionRule implements TokenRule{
    /**
     * Checks if there's any type of versioning in the path
     * @param token file paths or a string input
     * @return true if it matches, otherwise false
     */
    @Override
    public boolean matches(String token) {
        if (token.matches("^[vV]\\\\d+(\\\\.\\\\d+)*([-_][A-Za-z0-9]+)*$")) return true;

        return false;
    }
    /**
     * @return type of token being returned
     */
    @Override
    public String getTokenType() {
        return "VERSION";
    }
}
