package com.danielgergely.cgmath.mat4

import com.danielgergely.cgmath.floatArrayCopy

/**
 * Represents a column-major 4x4 matrix
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class Mat4 private constructor(val array: FloatArray) {
    companion object {
        private val MAT4_IDENTITY = floatArrayOf(
            1f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f
        )

        fun zero() = Mat4(FloatArray(16))

        fun identity() = Mat4(MAT4_IDENTITY.copyOf())

        fun from(values: FloatArray): Mat4 {
            val m = Mat4(FloatArray(16))
            floatArrayCopy(values, m.array, 0)
            return m
        }
    }

    fun assignIdentity() {
        floatArrayCopy(MAT4_IDENTITY, array, 0)
    }
}