package tire.render

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWKeyCallback
import tire.config.Config


//import io.github.oshai.kotlinlogging.KotlinLogging

//private val logger = KotlinLogging.logger {}

abstract class Render(private val config: Config) {
    protected var window: Long = 0

    init {
        println("init render")
        initGLFW()
        openWindow()
        registerKeyCallback()
    }

    abstract fun beforeFrame()
    abstract fun frame()
    abstract fun afterFrame()

    private var keyCallback: GLFWKeyCallback? = null

    fun run() {
        while (!glfwWindowShouldClose(window)) {
            glfwPollEvents()

            beforeFrame()
            frame()
            afterFrame()
        }
    }

    // Initialize GLFW
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

    // Create and show window
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

    private fun registerKeyCallback() {
        // Setup a key callback. It will be called every time a key is pressed, repeated or released.
        keyCallback = glfwSetKeyCallback(window, object : GLFWKeyCallback() {
            override fun invoke(
                window: Long,
                key: Int,
                scancode: Int,
                action: Int,
                mods: Int,
            ) {

                if (key == GLFW_KEY_ESCAPE && action == GLFW_PRESS) {
                    glfwSetWindowShouldClose(window, true)
                }

            }
        })
    }
}
