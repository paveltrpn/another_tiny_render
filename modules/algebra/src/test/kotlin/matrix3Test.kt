package algebra

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNotEquals

class Matrix3Test {
    @Test
    fun checkSize() {
        val MATRIX_SIZE = 9

        val foo = Matrix3d()
        assertEquals(MATRIX_SIZE, foo.size)

        val bar: Matrix3d
        bar = Matrix3d(doubleArrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0))
        assertEquals(MATRIX_SIZE, bar.size)

        val baz: Matrix3d
        baz = Matrix3d(bar)
        assertEquals(MATRIX_SIZE, baz.size)

        assertFailsWith<IllegalArgumentException>(
            message = "No exception found",
            block = {
                val fuz = Matrix3d(doubleArrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0))
            }
        )
    }

    @Test
    fun idtt() {
        val foo = Matrix3d()

        assertEquals(1.0, foo[0])
        assertEquals(0.0, foo[1])
        assertEquals(0.0, foo[2])
        assertEquals(0.0, foo[3])
        assertEquals(1.0, foo[4])
        assertEquals(0.0, foo[5])
        assertEquals(0.0, foo[6])
        assertEquals(0.0, foo[7])
        assertEquals(1.0, foo[8])
    }

    @Test
    fun copy() {
        val ethalon = Matrix3d(doubleArrayOf(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0))
        val foo = Matrix3d(ethalon)

        assertEquals(0.0, foo[0])
        assertEquals(1.0, foo[1])
        assertEquals(2.0, foo[2])
        assertEquals(3.0, foo[3])
        assertEquals(4.0, foo[4])
        assertEquals(5.0, foo[5])
        assertEquals(6.0, foo[6])
        assertEquals(7.0, foo[7])
        assertEquals(8.0, foo[8])

        foo[1] = 11.0
        assertEquals(11.0, foo[1])
        assertNotEquals(11.0, ethalon[1])
    }
}