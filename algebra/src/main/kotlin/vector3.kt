package algebra

import kotlin.math.sqrt

class Vector3d() : Vectord(3) {
    init {
        data[0] = 0.0
        data[1] = 0.0
        data[2] = 0.0
    }

    constructor(rhs: DoubleArray) : this() {
        rhs.copyInto(data)
    }

    constructor(rhs: Vector3d) : this() {
        rhs.data.copyInto(data)
    }

    constructor(x: Double, y: Double, z: Double) : this() {
        data[0] = x
        data[1] = y
        data[2] = z
    }

    // operator
    operator fun get(index: Int): Double {
        return data[index]
    }

    // operator
    operator fun set(index: Int, value: Double) {
        data[index] = value
    }

    fun x(): Double {
        return data[0]
    }

    fun y(): Double {
        return data[1]
    }

    fun z(): Double {
        return data[2]
    }

    fun dot(rhs: Vector3d): Double {
        return sqrt(this[0] * rhs[0] + this[1] * rhs[1] + this[2] * rhs[2])
    }
}
