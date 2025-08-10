package com.baiching.rule;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private final List<TokenRule> rules = new ArrayList<>();

    public RuleEngine() {
        rules.add(new HiddenFileRule());
        rules.add(new VersionRule());
    }

    public String applyRules(String token) {
        for (TokenRule rule: rules) {
            if (rule.matches(token)) {
                return rule.getTokenType();
            }
        }

        return "DEFAULT";
    }
}
