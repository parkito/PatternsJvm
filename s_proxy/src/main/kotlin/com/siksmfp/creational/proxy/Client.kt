package com.siksmfp.creational.proxy

import com.siksmfp.creational.proxy.MessageService.Companion.SERVICE_NAME
import java.rmi.registry.LocateRegistry
import java.time.LocalDateTime

fun main() {
    val registry = LocateRegistry.getRegistry()
    val service: MessageService = registry.lookup(SERVICE_NAME) as MessageService
    service.send(LocalDateTime.now().toString())
    println(service.request())
}