package tire.render

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL46.*
import tire.config.*

class RenderGL(config: Config) : Render(config) {
    init {
        println("init openGL render...")
        initAPI()
    }

    override fun initAPI() {
        // TODO: somewhere below code throw this:
        // "[LWJGL] [ThreadLocalUtil] Unsupported JNI version detected, this may result in a crash.
        // Please inform LWJGL developers."
        // DEAL WITH IT!!!

        // Make the OpenGL context current
        glfwMakeContextCurrent(window)

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities()

        if (config.vsync()) {
            glfwSwapInterval(1)
        }

        glClearColor(1.0f, 0.0f, 0.0f, 0.0f)
    }

    override fun beforeFrame() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
    }

    override fun frame() {

    }

    override fun afterFrame() {
        glfwSwapBuffers(window)
    }
}