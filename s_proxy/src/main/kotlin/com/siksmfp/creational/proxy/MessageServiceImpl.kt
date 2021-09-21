package com.siksmfp.creational.proxy

class MessageServiceImpl : MessageService {

    override fun send(message: String) {
        println("Sending $message")
    }

    override fun request(): String {
        return "Thread: ${Thread.currentThread().name}"
    }
}