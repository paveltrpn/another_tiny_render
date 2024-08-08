package algebra

import kotlin.math.sqrt

class Vector2d() : Vectord(2) {
    init {
        data[0] = 0.0
        data[1] = 0.0
    }

    constructor(rhs: DoubleArray) : this() {
        rhs.copyInto(data)
    }

    constructor(rhs: Vector2d) : this() {
        rhs.data.copyInto(data)
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

    fun dot(rhs: Vector2d): Double {
        return sqrt(this[0] * rhs[0] + this[1] * rhs[1])
    }
}
