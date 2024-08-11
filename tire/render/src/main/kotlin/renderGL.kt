package tire.render

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11.*
import tire.config.*

class RenderGL(config: Config) : Render(config) {
    init {
        println("init openGL render...")
    }

    override fun initAPI() {
        // Make the OpenGL context current
        glfwMakeContextCurrent(window)

        if (config.vsync()) {
            glfwSwapInterval(1)
        }
        
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities()

        glClearColor(1.0f, 0.0f, 0.0f, 0.0f);
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