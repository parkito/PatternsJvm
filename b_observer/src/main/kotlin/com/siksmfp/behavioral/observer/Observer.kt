package com.siksmfp.behavioral.observer

import java.time.LocalDateTime

interface Event

data class RamEvent(
    val available: Long,
    val used: Long,
) : Event

data class AddNewUserEvent(
    val name: String,
    val password: String
) : Event

interface Observer {
    fun id(): String

    fun update(event: Event)
}

class LowRamObserver : Observer {
    override fun update(event: Event) {
        if (event is RamEvent) {
            if ((event.used / event.available) * 100 < 30) {
                println("LOW MEMORY")
            }
        }
    }

    override fun id(): String = "LOW_RAM" + LocalDateTime.now()
}

class AddNewUserObserver(private val id: String) : Observer {
    override fun update(event: Event) {
        if (event is AddNewUserEvent) {
            println("Registering user " + event.name + " in the system " + id)
        }
    }

    override fun id(): String = id
}

class EvenManager() {
    private val observers: MutableList<Observer> = ArrayList()

    fun attach(observer: Observer) {
        println("Registering observer " + observer.id())
        observers.add(observer)
        println("Registered observers " + observers.size)
    }

    fun detach(id: String) {
        println("Removing observer $id")
        observers.removeIf { it.id() == id }
        println("Registered observers " + observers.size)
    }

    fun publish(event: Event) {
        observers.forEach { it.update(event) }
    }

    fun detachAll() {
        println("Removing all observers")
        observers.clear()
    }
}

fun main() {
    val manager = EvenManager()

    manager.attach(LowRamObserver())
    manager.attach(LowRamObserver())
    manager.attach(AddNewUserObserver("local"))
    manager.attach(AddNewUserObserver("outer"))

    listOf(
        RamEvent(100, 10),
        RamEvent(100, 20),
        RamEvent(100, 45),
        AddNewUserEvent("User1", "Pass1"),
        AddNewUserEvent("User2", "Pass2")
    ).forEach(manager::publish)

    manager.detachAll()
}