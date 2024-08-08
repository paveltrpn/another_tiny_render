package algebra

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class Matrix2Test {
    @Test
    fun checkSize() {
        val MATRIX_SIZE = 4

        val foo = Matrix2d()
        assertEquals(MATRIX_SIZE, foo.size)

        val bar: Matrix2d
        bar = Matrix2d(doubleArrayOf(0.0, 1.0, 2.0, 3.0))
        assertEquals(MATRIX_SIZE, bar.size)

        val baz: Matrix2d
        baz = Matrix2d(bar)
        assertEquals(MATRIX_SIZE, baz.size)

        assertFailsWith<IllegalArgumentException>(
            message = "No exception found",
            block = {
                val fuz = Matrix2d(doubleArrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0))
            }
        )
    }

    @Test
    fun idtt() {
        val foo = Matrix2d()

        assertEquals(1.0, foo[0])
        assertEquals(0.0, foo[1])
        assertEquals(0.0, foo[2])
        assertEquals(1.0, foo[3])
    }

    @Test
    fun copy() {
        val ethalon = Matrix2d(doubleArrayOf(0.0, 1.0, 2.0, 3.0))
        val foo = Matrix2d(ethalon)

        assertEquals(0.0, foo[0])
        assertEquals(1.0, foo[1])
        assertEquals(2.0, foo[2])
        assertEquals(3.0, foo[3])

        foo[1] = 11.0
        assertEquals(11.0, foo[1])
        assertNotEquals(11.0, ethalon[1])
    }

    @Test
    fun determinant() {
        val fooIdtt = Matrix2d(doubleArrayOf(1.0, 0.0, 0.0, 1.0)) // identity

        val det = fooIdtt.det()

        assertEquals(1.0, det)
    }

    @Test
    fun multiply() {
        val idtt = Matrix2d(doubleArrayOf(1.0, 0.0, 0.0, 1.0)) // identity
        val multThisRes = Matrix2d(doubleArrayOf(1.0, 0.0, 0.0, 1.0))

        multThisRes.multSelf(idtt)
        assert(multThisRes.compare(idtt))

        val multRes = idtt * multThisRes
        assert(multRes.compare(idtt))

        val A = Matrix2d(doubleArrayOf(-1.0, 2.0, -2.0, 3.0))
        val B = Matrix2d(doubleArrayOf(1.0, -2.0, 2.0, -3.0))
        val res = A * B
        val knownRes = Matrix2d(doubleArrayOf(3.0, -4.0, 4.0, -5.0))
        assert(res.compare(knownRes))
    }
}