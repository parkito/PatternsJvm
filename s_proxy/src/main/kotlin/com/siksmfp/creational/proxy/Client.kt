package com.siksmfp.creational.proxy

import com.siksmfp.creational.proxy.MessageService.Companion.SERVICE_NAME
import java.rmi.registry.LocateRegistry
import java.time.LocalDateTime

fun main() {
    val registry = LocateRegistry.getRegistry()
    val proxyMessageService: MessageService = registry.lookup(SERVICE_NAME) as MessageService

    proxyMessageService.send(LocalDateTime.now().toString())
    println(proxyMessageService.request())
}