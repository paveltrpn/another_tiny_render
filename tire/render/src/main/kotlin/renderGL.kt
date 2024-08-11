package tire.render

import org.lwjgl.glfw.GLFW
import tire.config.*

class RenderGL(config: Config) : Render(config) {
    init {
        // throw RuntimeException(message = "not implemented")
    }

    override fun beforeFrame() {

    }

    override fun frame() {

    }

    override fun afterFrame() {
        GLFW.glfwSwapBuffers(window)
    }
}