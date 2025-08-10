package com.baiching.rule;

import java.io.File;

public class HiddenFileRule implements TokenRule {
    /**
     *  Returns if the given path is hidden or not
     * @param token is a filepath
     * @return true if file is hidden, false if it's not
     */
    @Override
    public boolean matches(String token) {
        File file = new File(token);

        if (file.isHidden()) return true;
        if (file.getName().startsWith(".")) return true;
        return false;
    }

    @Override
    public String getTokenType() {
        return "HIDDEN";
    }
}
