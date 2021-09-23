package com.siksmfp.creational.proxy

import com.siksmfp.creational.proxy.MessageService.Companion.SERVICE_NAME
import java.rmi.registry.LocateRegistry
import java.rmi.server.UnicastRemoteObject

fun main() {
    println("Starting server")
    val ms = MessageServiceImpl()
    val proxy = UnicastRemoteObject.exportObject(ms, 0)
    val registry = LocateRegistry.createRegistry(1099)
    registry.rebind(SERVICE_NAME, proxy);
    println("exit rebinding")
}