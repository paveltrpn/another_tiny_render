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

    constructor(rhs: Matrix2d) : this() {
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

    // operator
    operator fun times(rhs: Matrix2d): Matrix2d {
        val tmp = Matrix2d(this)
        tmp.multSelf(rhs)
        return tmp
    }

    fun compare(rhs: Matrix2d): Boolean {
        return this[0] == rhs[0] && this[1] == rhs[1] && this[2] == rhs[2] && this[3] == rhs[3]
    }

    fun fromArray(rhs: DoubleArray) {
        rhs.copyInto(data)
    }

    fun setIdtt() {
        data[0] = 1.0
        data[1] = 0.0
        data[2] = 0.0
        data[3] = 1.0
    }

    fun multSelf(rhs: Matrix2d) {
        val data0 = this[0]
        val data1 = this[1]
        this[0] = rhs[0] * data[0] + rhs[1] * data[2]
        this[1] = rhs[0] * data[1] + rhs[1] * data[3]
        this[2] = rhs[2] * data0 + rhs[3] * data[2]
        this[3] = rhs[2] * data1 + rhs[3] * data[3]
    }

    fun det(): Double {
        return data[0] * data[3] - data[2] * data[1]
    }

    fun trasposeSelf() {

    }

    fun getTranspose(): Matrix2d {
        return Matrix2d(doubleArrayOf(data[0], data[2], data[1], data[3]))
    }
}


