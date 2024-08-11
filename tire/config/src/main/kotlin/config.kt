package tire.config

import com.google.gson.Gson
import java.io.File
import java.io.FileNotFoundException

class Config(filePath: String) {
    data class Data(
        var applicationName: String = "",
        var fullscreen: Boolean = false,
        var resizeable: Boolean = false,
        var windowWidth: Long = 0,
        var windowHeight: Long = 0,
        var windowPosX: Long = 0,
        var windowPosY: Long = 0,
        var doublebuffer: Boolean = false,
        var vsync: Boolean = false,
        var debug: Boolean = false,
        var engineName: String = "",
        var enableValidationLayers: Boolean = false,
        var perspectiveCameraFov: Double = 50.0,
    )

    private var data = Data()

    init {
        // load json from file and serialize to data class
        if (filePath.isEmpty()) {
            throw IllegalArgumentException()
        }

        val file = File(filePath)
        if (!file.exists()) {
            throw FileNotFoundException()
        }

        val gson = Gson()

        val jsonString = file.inputStream().readBytes().toString(Charsets.UTF_8)

        data = gson.fromJson(jsonString, Data::class.java)
    }

    fun applicationName(): String {
        return data.applicationName
    }

    fun fullscreen(): Boolean {
        return data.fullscreen
    }

    fun resizeable(): Boolean {
        return data.resizeable
    }

    fun windowWidth(): Long {
        return data.windowWidth
    }

    fun windowHeight(): Long {
        return data.windowHeight
    }

    fun windowPosX(): Long {
        return data.windowPosX
    }

    fun windowPosY(): Long {
        return data.windowPosY
    }

    fun doublebuffer(): Boolean {
        return data.doublebuffer
    }

    fun vsync(): Boolean {
        return data.vsync
    }

    fun debug(): Boolean {
        return data.debug
    }

    fun engineName(): String {
        return data.engineName
    }

    fun enableValidationlayers(): Boolean {
        return data.enableValidationLayers
    }

    fun perspectiveCameraFov(): Double {
        return data.perspectiveCameraFov
    }
}
