package org.example

class Stack<T> {
    inner class Node(val data: T) {
        var next: Node? = null
    }

    private var top: Node? = null

    fun push(data: T) {
        val newNode = Node(data)
        newNode.next = top
        top = newNode
    }

    fun pop(): T? {
        if (top == null) {
            println("Stack is empty")
            return null
        }
        val poppedData = top!!.data
        top = top!!.next
        return poppedData
    }

    fun printStack() {
        var current = top
        while (current != null) {
            println(current.data)
            current = current.next
        }
    }
}

fun main() {
    val myStack = Stack<String>()
    var myLoop = true
    while (myLoop) {
        val userInput = readLine().orEmpty()
        when (userInput) {
            "exit" -> myLoop = false
            "pop" -> myStack.pop()
            "show" -> myStack.printStack()
            else -> {
                myStack.push(userInput)
            }
        }
    }
    println("Exiting the program.")
}
