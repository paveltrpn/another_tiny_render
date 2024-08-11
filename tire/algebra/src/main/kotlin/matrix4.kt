package tire.algebra

class Matrix4d() : Matrixd(16) {
    init {
        setIdtt()
    }

    constructor(rhs: DoubleArray) : this() {
        // may be type check here?
        rhs.copyInto(data)
    }

    constructor(rhs: Matrix3d) : this() {
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

    fun fromArray(rhs: DoubleArray) {
        rhs.copyInto(data)
    }

    fun copy(): Matrix3d {
        return Matrix3d(this.data)
    }

    fun setIdtt() {
        data[0] = 1.0
        data[1] = 0.0
        data[2] = 0.0
        data[3] = 0.0
        data[4] = 0.0
        data[5] = 1.0
        data[6] = 0.0
        data[7] = 0.0
        data[8] = 0.0
        data[9] = 0.0
        data[10] = 0.0
        data[11] = 1.0
        data[12] = 0.0
        data[13] = 0.0
        data[14] = 0.0
        data[15] = 1.0
    }
}

