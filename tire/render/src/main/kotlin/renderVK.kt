package tire.render

import org.lwjgl.glfw.GLFW
import tire.config.*

class RenderVK(config: Config) : Render(config) {
    init {
        println("init vulkan render...")
        initAPI()
    }

    override fun initAPI() {
    }

    override fun beforeFrame() {

    }

    override fun frame() {

    }

    override fun afterFrame() {
    }
}