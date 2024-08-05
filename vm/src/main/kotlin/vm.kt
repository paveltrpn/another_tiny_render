package kov.vm

import org.lwjgl.glfw.GLFW.*

fun main(args: Array<String>) {
    println("hello virtual")

    // Setup an error callback
    // GLFWErrorCallback.createPrint(System.err).set()
    if (!(glfwInit())) {
        throw IllegalStateException("Unable to initialize window")
    } else {
        println("GLFW initialized")
    }
}
