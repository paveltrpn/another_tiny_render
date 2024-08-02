package algebra

class Matrix2d() : Matrixd(4) {
    init {
        setIdtt()
    }

    constructor(rhs: DoubleArray) : this() {
        // may be type check here?
        if (rhs.size != 4) {
            throw IllegalArgumentException()
        }
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
        data[3] = 1.0
    }
}


