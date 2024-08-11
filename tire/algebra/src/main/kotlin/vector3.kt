package tire.algebra

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

    fun plus(rhs: Vector3d) {
        this[0] += rhs[0]
        this[1] += rhs[1]
        this[2] += rhs[2]
    }

    fun minus(rhs: Vector3d) {
        this[0] -= rhs[0]
        this[1] -= rhs[1]
        this[2] -= rhs[2]
    }

    fun sum(rhs: Vector3d): Vector3d {
        val tmp = Vector3d(this)
        tmp.plus(rhs)
        return tmp
    }

    fun sub(rhs: Vector3d): Vector3d {
        val tmp = Vector3d(this)
        tmp.minus(rhs)
        return tmp
    }

    fun dot(rhs: Vector3d): Double {
        return this[0] * rhs[0] + this[1] * rhs[1] + this[2] * rhs[2]
    }

    fun length(): Double {
        return sqrt(dot(this))
    }

    fun normalize() {
        val len = length()

        if (len > 0.0) {
            this[0] /= len
            this[1] /= len
            this[2] /= len
        }
    }

    fun cross(rhs: Vector3d): Vector3d {
        return Vector3d(
            this[1] * rhs[2] - this[2] * rhs[1],
            this[2] * rhs[0] - this[0] * rhs[2],
            this[0] * rhs[1] - this[1] * rhs[0]
        )
    }
}
