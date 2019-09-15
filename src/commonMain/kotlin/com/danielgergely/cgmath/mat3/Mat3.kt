package com.danielgergely.cgmath.mat3

import com.danielgergely.cgmath.floatArrayCopy

/**
 * Represents a column-major 3x3 matrix
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Mat3 private constructor(val array: FloatArray) {
    companion object {
        private val MAT3_IDENTITY = floatArrayOf(
            1f, 0f, 0f,
            0f, 1f, 0f,
            0f, 0f, 1f
        )

        fun zero() = Mat3(FloatArray(9))

        fun identity() = Mat3(MAT3_IDENTITY.copyOf())

        fun from(values: FloatArray): Mat3 {
            val m = Mat3(FloatArray(9))
            floatArrayCopy(values, m.array, 0)
            return m
        }
    }

    fun assignIdentity() {
        floatArrayCopy(MAT3_IDENTITY, array, 0)
    }
}