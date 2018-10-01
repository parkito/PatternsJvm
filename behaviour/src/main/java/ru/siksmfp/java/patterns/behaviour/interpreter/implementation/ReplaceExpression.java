package ru.siksmfp.java.patterns.behaviour.interpreter.implementation;

public class ReplaceExpression extends Expression {

    public ReplaceExpression(String leftOperand, String rightOperand) {
        super(leftOperand, rightOperand);
    }

    @Override
    public String interpret(String string) {
        return string.replace(leftOperand, rightOperand);
    }
}
