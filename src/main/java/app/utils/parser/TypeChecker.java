package app.utils.parser;

import com.google.common.base.CharMatcher;

class TypeChecker {
    boolean isInteger(String input) {
        return CharMatcher.inRange('0', '9').or(CharMatcher.is('-')).matchesAllOf(input) &&
                input.chars().filter(ch -> ch == '-').count() <= 1;
    }

    boolean isFloat(String input) {
        return CharMatcher.inRange('0', '9').or(CharMatcher.anyOf("-.eE")).matchesAllOf(input) &&
                input.chars().filter(ch -> ch == '.').count() <= 1 &&
                input.chars().filter(ch -> ch == '-').count() <= 1 &&
                (input.contains("e") || input.contains("E") || input.contains("."));
    }
}
