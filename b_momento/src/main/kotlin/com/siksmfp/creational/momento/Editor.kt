package com.siksmfp.creational.momento

class Editor(
) {
    private val states = ArrayDeque<State>()
    private var currentState = State("", 0)

    fun addSymbol(symbol: Char) {
        states.addLast(currentState)
        currentState = State(currentState.content + symbol, currentState.position + 1)
    }

    fun moveCursor(offset: Int) {
        states.addLast(currentState)
        currentState = State(currentState.content, currentState.position + offset)
    }

    fun undo() {
        if (states.isEmpty()) {
            throw IllegalStateException("Editor is empty")
        }
        currentState = states.last()
    }

    fun print() {
        println("${currentState.content} : ${currentState.position}")
    }
}

class State(
    val content: String,
    val position: Int
)

fun main() {
    val editor = Editor()
    editor.addSymbol('a')
    editor.addSymbol('b')
    editor.print()
    editor.addSymbol('c')
    editor.undo()
    editor.addSymbol('d')
    editor.print()
}