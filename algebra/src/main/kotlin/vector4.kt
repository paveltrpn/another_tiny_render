package algebra

import algebra.Vectord
import kotlin.math.sqrt

class Vector4d() : Vectord(4) {
    init {
        data[0] = 0.0
        data[1] = 0.0
        data[2] = 0.0
        data[3] = 0.0
    }

    constructor(rhs: DoubleArray) : this() {
        rhs.copyInto(data)
    }

    constructor(rhs: Vector4d) : this() {
        rhs.data.copyInto(data)
    }

    constructor(x: Double, y: Double, z: Double, w: Double) : this() {
        data[0] = x
        data[1] = y
        data[2] = z
        data[2] = w
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

    fun w(): Double {
        return data[3]
    }

    fun plus(rhs: Vector4d) {
        this[0] += rhs[0]
        this[1] += rhs[1]
        this[2] += rhs[2]
        this[3] += rhs[3]
    }

    fun minus(rhs: Vector4d) {
        this[0] -= rhs[0]
        this[1] -= rhs[1]
        this[2] -= rhs[2]
        this[3] -= rhs[3]
    }

    fun sum(rhs: Vector4d): Vector4d {
        val tmp = Vector4d(this)
        tmp.plus(rhs)
        return tmp
    }

    fun sub(rhs: Vector4d): Vector4d {
        val tmp = Vector4d(this)
        tmp.minus(rhs)
        return tmp
    }

    fun dot(rhs: Vector4d): Double {
        return this[0] * rhs[0] + this[1] * rhs[1] + this[2] * rhs[2] + this[3] * rhs[3]
    }

    fun length(): Double {
        return sqrt(dot(this))
    }
}
