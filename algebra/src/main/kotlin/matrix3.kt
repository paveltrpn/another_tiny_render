package algebra

class Matrix3d() : Matrixd(9) {
    init {
        setIdtt()
    }

    constructor(rhs: DoubleArray) : this() {
        // may be type check here?
        if (rhs.size != 9) {
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
        data[3] = 0.0
        data[4] = 1.0
        data[5] = 0.0
        data[6] = 0.0
        data[7] = 0.0
        data[8] = 1.0
    }

    fun multSelf(rhs: Matrix3d) {

    }

    fun trasposeSelf() {

    }

    fun transposeGet(): Matrix3d {
        return Matrix3d()
    }
}

