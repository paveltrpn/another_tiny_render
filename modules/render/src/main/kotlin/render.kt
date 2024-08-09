package modules.render

import modules.config.*
import org.lwjgl.glfw.GLFW.*

open class Render(val config: Config) {
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
