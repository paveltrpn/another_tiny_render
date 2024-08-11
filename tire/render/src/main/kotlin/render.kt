package tire.render

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWKeyCallback
import org.lwjgl.glfw.GLFWErrorCallback
import org.lwjgl.system.MemoryUtil.NULL
import tire.config.Config

//import io.github.oshai.kotlinlogging.KotlinLogging

//private val logger = KotlinLogging.logger {}

abstract class Render(protected val config: Config) {
    protected var window: Long = 0
    private var keyCallback: GLFWKeyCallback? = null
    private var errorCallback: GLFWErrorCallback? = null

    abstract fun initAPI()
    abstract fun beforeFrame()
    abstract fun frame()
    abstract fun afterFrame()

    init {
        println("init render...")
        initGLFW()
        openWindow()
        registerKeyCallback()
    }

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
        errorCallback = glfwSetErrorCallback(GLFWErrorCallback.createPrint(System.err))

        if (!(glfwInit())) {
            throw IllegalStateException("Unable to initialize window")
        } else {
            println("glfw initialized")
        }
    }

    // Create and show window
    private fun openWindow() {
        glfwDefaultWindowHints()
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE)

        if (config.doublebuffer()) {
            glfwWindowHint(GLFW_DOUBLEBUFFER, GLFW_TRUE)
        }

        if (config.resizeable()) {
            glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE)
        } else {
            glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)
        }

        window =
            glfwCreateWindow(
                config.windowWidth().toInt(),
                config.windowHeight().toInt(),
                config.applicationName(),
                NULL,
                NULL
            )
        if (window == NULL) {
            throw RuntimeException("unable to create window")
        } else {
            println("glfw create window success")
        }

        glfwSetWindowPos(window, config.windowPosX().toInt(), config.windowPosY().toInt())

        glfwShowWindow(window)
    }

    private fun registerKeyCallback() {
        // Set up a key callback. It will be called every time a key is pressed, repeated or released.
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
