
package algebra

class Matrix3d: Matrixd(9) {
    init {
        setIdtt()
    }

    fun fromArray(rhs: DoubleArray) {
        _data = rhs
    }

    fun copy(): Matrix3d {
        val rt = Matrix3d()
        rt.fromArray(this._data)
        return rt
    }

    fun setIdtt() {
        _data[0] = 1.0
        _data[1] = 0.0
        _data[2] = 0.0
        _data[3] = 0.0
        _data[4] = 1.0
        _data[5] = 0.0
        _data[6] = 0.0
        _data[7] = 0.0
        _data[8] = 1.0
    }
}

