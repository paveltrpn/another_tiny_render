package modules.config

import kotlin.test.Test
import kotlin.test.assertFailsWith
import java.io.File
import kotlin.test.assertEquals

class ConfigTest {
    @Test
    fun fileNameTest() {
        assertFailsWith<IllegalArgumentException>(
            message = "No exception found",
            block = {
                val emptyString = Config("")
            }
        )
    }

    @Test
    fun checkFileExist() {
        val file = File("src/test/resources/config.json")
        assert(file.exists())
    }

    @Test
    fun checkValues() {
        val config = Config("src/test/resources/config.json")

        assertEquals("testApp", config.applicationName())
        assertEquals(false, config.fullscreen())
        assertEquals(false, config.resizeable())
        assertEquals(800, config.windowWidth())
        assertEquals(600, config.windowHeight())
        assertEquals(100, config.windowPosX())
        assertEquals(100, config.windowPosY())
        assertEquals(true, config.doublebuffer())
        assertEquals(true, config.vsync())
        assertEquals(true, config.debug())
        assertEquals("testEngine", config.engineName())
        assertEquals(false, config.enableValidationlayers())
        assertEquals(50.0, config.perspectiveCameraFov())
    }

}
