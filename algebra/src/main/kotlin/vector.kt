package algebra

sealed class Vectorl(size: Int) {
    var data = LongArray(size)
}

sealed class Vectord(size: Int) {
    var data = DoubleArray(size)
}
