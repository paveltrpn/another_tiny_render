package modules.config

import com.google.gson.Gson
import java.io.File


class Config(file: String) {
    data class Data(
        var windowWidth: Long = 0,
        var windowHeight: Long = 0,
    )

    private var data = Data()

    init {
        // load json from file and serialize to data class
        val gson = Gson()
        val jsonString = File(file).inputStream().readBytes().toString(Charsets.UTF_8)
        data = gson.fromJson(jsonString, Data::class.java)
    }

    fun windowWidth(): Long {
        return 0
    }

    fun windowHeight(): Long {
        return 0
    }
}
