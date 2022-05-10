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

interface Observer<out T> {
    fun id(): String

    fun update(event: @UnsafeVariance T)
}

class LowRamObserver : Observer<RamEvent> {
    override fun update(event: RamEvent) {
        if ((event.used / event.available) * 100 < 30) {
            println("LOW MEMORY")
        }
    }

    override fun id(): String = "LOW_RAM" + LocalDateTime.now()
}

class AddNewUserObserver(private val id: String) : Observer<AddNewUserEvent> {
    override fun update(event: AddNewUserEvent) {
        println("Registering user " + event.name + " in the system " + id)
    }

    override fun id(): String = id
}

class EvenManager() {
    private val observers: MutableList<Observer<Event>> = ArrayList()

    fun <T : Event> attach(observer: Observer<T>) {
        println("Registering observer " + observer.id())
        observers.add(observer)
        println("Registered observers " + observers.size)
    }

    fun <T : Event> detach(id: String) {
        println("Removing observer $id")
        observers.removeIf { it.id() == id }
        println("Registered observers " + observers.size)
    }

    fun <T : Event> publish(event: T) {
        observers.forEach { it.update(event) }
    }

    fun detachAll() {
        println("Removing all observers")
        observers.clear()
    }
}

fun main() {
    val manager = EvenManager()

    listOf(
        LowRamObserver(),
        LowRamObserver(),
        LowRamObserver(),
        AddNewUserObserver("local"),
        AddNewUserObserver("outer"),
    ).forEach(manager::attach)

    listOf(
        RamEvent(100, 10),
        RamEvent(100, 20),
        RamEvent(100, 45),
        AddNewUserEvent("User1", "Pass1"),
        AddNewUserEvent("User2", "Pass2")
    ).forEach(manager::publish)

    manager.detachAll()
}