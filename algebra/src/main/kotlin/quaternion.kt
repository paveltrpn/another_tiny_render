package algebra

class Quaternion {
    var data = DoubleArray(4)

    init {
        data[0] = 0.0
        data[1] = 0.0
        data[2] = 0.0
        data[3] = 1.0
    }

    constructor(rhs: DoubleArray) {
        if (rhs.size != 4) {
            throw IllegalArgumentException()
        }
        rhs.copyInto(data)
    }

    constructor(rhs: Quaternion) {
        rhs.data.copyInto(this.data)
    }

    constructor(rhs: Vector3d) {
        data[0] = rhs.x()
        data[1] = rhs.y()
        data[2] = rhs.z()
        data[3] = 1.0
    }

    constructor(rhs: Vector4d) {
        data[0] = rhs.x()
        data[1] = rhs.y()
        data[2] = rhs.z()
        data[3] = rhs.w()
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

    fun toVector3d(): Vector3d {
        return Vector3d(this[0], this[0], this[0])
    }
}