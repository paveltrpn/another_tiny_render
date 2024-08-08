package algebra

import kotlin.math.sqrt
import kotlin.math.atan2

class Quaternion() {
    var data = DoubleArray(4)

    init {
        data[0] = 0.0
        data[1] = 0.0
        data[2] = 0.0
        data[3] = 0.0
    }

    constructor(rhs: DoubleArray) : this() {
        if (rhs.size != 4) {
            throw IllegalArgumentException()
        }
        rhs.copyInto(data)
    }

    constructor(rhs: Quaternion) : this() {
        rhs.data.copyInto(this.data)
    }

    constructor(rhs: Vector3d) : this() {
        data[0] = rhs.x()
        data[1] = rhs.y()
        data[2] = rhs.z()
        data[3] = 1.0
    }

    constructor(rhs: Vector4d) : this() {
        data[0] = rhs.x()
        data[1] = rhs.y()
        data[2] = rhs.z()
        data[3] = rhs.w()
    }

    constructor(x: Double, y: Double, z: Double, w: Double) : this() {
        data[0] = x
        data[1] = y
        data[2] = z
        data[2] = w
    }

    operator fun get(index: Int): Double {
        return data[index]
    }

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

    fun asVector3d(): Vector3d {
        return Vector3d(this[0], this[1], this[2])
    }

    fun asVector4d(): Vector4d {
        return Vector4d(this[0], this[1], this[2], this[4])
    }

    fun mult(rhs: Quaternion): Quaternion {
        val tmp = Quaternion()
        tmp[0] = rhs[3] * this[0] + rhs[0] * this[3] + rhs[1] * this[2] - rhs[2] * this[1]
        tmp[1] = rhs[3] * this[1] - rhs[0] * this[2] + rhs[1] * this[3] + rhs[2] * this[0]
        tmp[2] = rhs[3] * this[2] + rhs[0] * this[1] - rhs[1] * this[0] + rhs[2] * this[3]
        tmp[3] = rhs[3] * this[3] - rhs[0] * this[0] - rhs[1] * this[1] - rhs[2] * this[2]
        return tmp
    }

    fun multSelf(rhs: Quaternion) {
        val x = rhs[3] * this[0] + rhs[0] * this[3] + rhs[1] * this[2] - rhs[2] * this[1]
        val y = rhs[3] * this[1] - rhs[0] * this[2] + rhs[1] * this[3] + rhs[2] * this[0]
        val z = rhs[3] * this[2] + rhs[0] * this[1] - rhs[1] * this[0] + rhs[2] * this[3]
        this[3] = rhs[3] * this[3] - rhs[0] * this[0] - rhs[1] * this[1] - rhs[2] * this[2]

        this[2] = z
        this[1] = y
        this[0] = x
    }

    // Make a rotation Quat which will rotate vec1 to vec2.
    // Generally take a dot product to get the angle between these
    // and then use a cross product to get the rotation axis
    // Watch out for the two special cases of when the vectors
    // are co-incident or opposite in direction.
    fun makeRotate(vec1: Vector3d, vec2: Vector3d) {

    }

    fun asAxisAngle(quat: Quaternion): Pair<Double, Vector3d> {
        val sinhalfangle = sqrt(quat[0] * quat[0] + quat[1] * quat[1] + quat[2] * quat[2])

        // while angle=2*acos(W) works, it is numerically unstable (inaccurate)
        // near W=+-1 for numbers with finite precision
        val angle = 2.0 * atan2(sinhalfangle, quat[3])

        // if (quat[3] < 0)
        // angle = 2.0 * atan2(-sinhalfangle, -quat[3]) //-PI,0
        // else
        // angle = 2.0 * atan2(sinhalfangle, quat[3]) //0,PI

        val x: Double
        val y: Double
        val z: Double

        if (sinhalfangle != 0.0) {
            x = quat[0] / sinhalfangle
            y = quat[1] / sinhalfangle
            z = quat[2] / sinhalfangle
        } else {
            x = 0.0
            y = 0.0
            z = 1.0
        }

        return Pair(angle, Vector3d(x, y, z))
    };
}