package com.baiching.core.rule;

import java.io.File;

public class RuleEngine {
    public boolean hiddenFileRule(String path) {
        File file = new File(path);

        if (file.isHidden()) return true;
        if (file.getName().startsWith(".")) return true;
        return false;
    }
}
