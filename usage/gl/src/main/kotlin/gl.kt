package usage.gl

import tire.config.*
import tire.render.*

fun main(args: Array<String>) {
    val config = Config("src/main/resources/config.json")

    val render = RenderGL(config)

    render.run()
}
