package tire.render

import org.lwjgl.glfw.GLFW
import tire.config.*

class RenderVK(config: Config) : Render(config) {
    override fun beforeFrame() {

    }

    override fun frame() {

    }

    override fun afterFrame() {
        GLFW.glfwSwapBuffers(window)
    }
}