package com.danielgergely.cgmath.mat3

import com.danielgergely.cgmath.floatArrayCopy
import kotlin.jvm.JvmInline

/**
 * Represents a column-major 3x3 matrix
 */
@JvmInline
public value class Mat3 private constructor(public val array: FloatArray) {

    public companion object {
        private val MAT3_IDENTITY = floatArrayOf(
            1f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 1f
        )

        public fun zero(): Mat3 = Mat3(FloatArray(9))

        public fun identity(): Mat3 = Mat3(MAT3_IDENTITY.copyOf())

        public fun from(values: FloatArray): Mat3 {
            val m = Mat3(FloatArray(9))
            floatArrayCopy(values, m.array, 0)
            return m
        }
    }

    public fun assignIdentity() {
        floatArrayCopy(MAT3_IDENTITY, array, 0)
    }
}
