package ru.siksmfp.java.patterns.behaviour.interpreter.implementation;

public class Main {
    public static void main(String[] args) {
        String expression = "Hi, hello, how are you?";
        String patternString = "rm:, rm:? add:,ok reverse replace:ll:LL";

        Pattern pattern = new Pattern();
        Matcher matcher = new Matcher(pattern.compile(patternString));

        System.out.println(matcher.match(expression));//ko,:?uoy era woh ,oLLeh ,iH
    }
}
