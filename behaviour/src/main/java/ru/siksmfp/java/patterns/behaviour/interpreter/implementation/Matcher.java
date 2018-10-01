package ru.siksmfp.java.patterns.behaviour.interpreter.implementation;

import java.util.List;

public class Matcher {

    private List<Expression> expressions;

    public Matcher(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public String match(String string) {
        for (Expression expr : expressions) {
            string = expr.interpret(string);
        }
        return string;
    }

}
