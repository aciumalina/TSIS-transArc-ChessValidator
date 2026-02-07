package org.example;

import java.util.List;

public class DefaultFenValidator implements FenValidator {

    private final List<FenValidationRule> rules;

    public DefaultFenValidator(List<FenValidationRule> rules) {
        this.rules = rules;
    }

    @Override
    public boolean validate(String fen) {
        for (FenValidationRule rule : rules) {
            if (!rule.isValid(fen)) {
                return false;
            }
        }
        return true;
    }
}

