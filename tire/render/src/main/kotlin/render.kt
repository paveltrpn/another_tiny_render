package tire.render

import tire.config.*
import org.lwjgl.glfw.GLFW.*

//import io.github.oshai.kotlinlogging.KotlinLogging

//private val logger = KotlinLogging.logger {}

abstract class Render(val config: Config) {
    var window: Long = 0

    init {
        println("init render")
        initGLFW()
        openWindow()
    }

    abstract fun beforeFrame()
    abstract fun frame()
    abstract fun afterFrame()

    fun run() {
        while (!glfwWindowShouldClose(window)) {
            glfwPollEvents()

            beforeFrame()
            frame()
            afterFrame()
        }
    }

    private fun initGLFW() {
        // Set up an error callback
        // GLFWErrorCallback.createPrint(System.err).set()
        if (!(glfwInit())) {
            throw IllegalStateException("Unable to initialize window")
        } else {
            println("glfw initialized")
        }

        // glfwSetErrorCallback(glfw_error_callback);

        if (config.doublebuffer()) {
            glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE)
        }

        if (config.resizeable()) {
            glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)
        } else {
            glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)
        }


    }

    private fun openWindow() {
        window =
            glfwCreateWindow(
                config.windowWidth().toInt(),
                config.windowHeight().toInt(),
                config.applicationName(),
                0,
                0
            )
        if (window == 0L) {
            throw RuntimeException("unable to create window")
        } else {
            println("glfw create window success")
        }
    }
}
