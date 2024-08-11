package tire.algebra

sealed class Matrixl(val size: Int) {
    var data = LongArray(size)
}

sealed class Matrixd(val size: Int) {
    var data = DoubleArray(size)
}