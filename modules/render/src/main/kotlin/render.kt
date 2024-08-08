package modules.render

import org.lwjgl.glfw.GLFW.*

class Render {
    init {
        println("init render")

        // Set up an error callback
        // GLFWErrorCallback.createPrint(System.err).set()
        if (!(glfwInit())) {
            throw IllegalStateException("Unable to initialize window")
        } else {
            println("GLFW initialized")
        }
    }
}
