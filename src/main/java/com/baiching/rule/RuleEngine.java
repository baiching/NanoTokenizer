package com.baiching.rule;

import java.util.ArrayList;
import java.util.List;

public class RuleEngine {
    private final List<TokenRule> rules = new ArrayList<>();

    /**
     * Initializing rules according to their priority
     */
    public RuleEngine() {
        rules.add(new HiddenFileRule());
        rules.add(new VersionRule());
    }

    /**
     *
     * @param token input string
     * @return token type: HIDDEN, VERSION or DEFAULT
     */
    public String applyRules(String token) {
        for (TokenRule rule: rules) {
            if (rule.matches(token)) {
                return rule.getTokenType();
            }
        }

        return "DEFAULT";
    }
}
