package com.danielgergely.cgmath.mat4

import com.danielgergely.cgmath.floatArrayCopy
import kotlin.jvm.JvmInline

/**
 * Represents a column-major 4x4 matrix
 */
@JvmInline
public value class Mat4 private constructor(public val array: FloatArray) {

    public companion object {
        private val MAT4_IDENTITY = floatArrayOf(
            1f, 0f, 0f, 0f,
            0f, 1f, 0f, 0f,
            0f, 0f, 1f, 0f,
            0f, 0f, 0f, 1f
        )

        public fun zero(): Mat4 = Mat4(FloatArray(16))

        public fun identity(): Mat4 = Mat4(MAT4_IDENTITY.copyOf())

        public fun from(values: FloatArray): Mat4 {
            val m = Mat4(FloatArray(16))
            floatArrayCopy(values, m.array, 0)
            return m
        }
    }

    public fun assignIdentity() {
        floatArrayCopy(MAT4_IDENTITY, array, 0)
    }
}
