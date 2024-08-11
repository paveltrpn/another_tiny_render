package usage.vk

import tire.config.*
import tire.render.*

fun main(args: Array<String>) {
    val config = Config("src/main/resources/config.json")

    val render = RenderVK(config)

    render.run()
}
