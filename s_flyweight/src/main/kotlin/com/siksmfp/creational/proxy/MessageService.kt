package com.siksmfp.creational.proxy

import java.rmi.Remote
import java.rmi.RemoteException

interface MessageService : Remote {

    companion object{
        const val SERVICE_NAME = "MessageService"
    }

    @Throws(RemoteException::class)
    fun send(message: String)

    @Throws(RemoteException::class)
    fun request(): String
}