package com.danielgergely.cgmath.graphics

import com.danielgergely.cgmath.mat4.Mat4
import kotlin.math.PI
import kotlin.math.tan

/**
 * Set up a perspective projection matrix, and return a new [Mat4] instance containing the result.
 *
 * Based on gluPerspective
 */
inline fun perspective(fovy: Float, aspect: Float, zNear: Float, zFar: Float) : Mat4 {
    val result = Mat4.zero()
    perspective(fovy, aspect, zNear, zFar, result)
    return result
}

/**
 * Set up a perspective projection matrix, and writes the result into an existing [Mat4] object.
 *
 * Based on gluPerspective
 */
fun perspective(fovy: Float, aspect: Float, zNear: Float, zFar: Float, result: Mat4) {
    val f = 1.0f / tan(fovy * (PI / 360.0)).toFloat()
    val rangeReciprocal = 1.0f / (zNear - zFar)

    result.array[0] = f / aspect
    result.array[1] = 0.0f
    result.array[2] = 0.0f
    result.array[3] = 0.0f

    result.array[4] = 0.0f
    result.array[5] = f
    result.array[6] = 0.0f
    result.array[7] = 0.0f

    result.array[8] = 0.0f
    result.array[9] = 0.0f
    result.array[10] = (zFar + zNear) * rangeReciprocal
    result.array[11] = -1.0f

    result.array[12] = 0.0f
    result.array[13] = 0.0f
    result.array[14] = 2.0f * zFar * zNear * rangeReciprocal
    result.array[15] = 0.0f
}