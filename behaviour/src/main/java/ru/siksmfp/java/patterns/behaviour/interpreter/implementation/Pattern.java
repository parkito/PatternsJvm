package ru.siksmfp.java.patterns.behaviour.interpreter.implementation;

import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Pattern {

    private static final String RM_OPERATOR = "rm";
    private static final String ADD_OPERATOR = "add";
    private static final String REVERSE_OPERATOR = "reverse";
    private static final String REPLACE_OPERATOR = "reverse";
    private static final char COLON = ':';

    public List<Expression> compile(String string) {
        return Collections.list(new StringTokenizer(string, " ")).stream()
                .map(token -> (String) token)
                .map(this::parseExpression)
                .collect(Collectors.toList());
    }

    private Expression parseExpression(String operator) {
        if (operator.startsWith(RM_OPERATOR)) {
            int argumentIndex = operator.indexOf(COLON);
            String argument = operator.substring(argumentIndex);
            return new RmExpression(argument);
        }
        return null;
    }
}
