package com.danielgergely.cgmath.graphics

import com.danielgergely.cgmath.mat3.Mat3
import com.danielgergely.cgmath.vec2.Vec2
import kotlin.math.cos
import kotlin.math.sin

private inline fun withMat3(operation: (Mat3) -> Unit): Mat3 {
    val result = Mat3.zero()
    operation(result)
    return result
}

public fun translateMatrix2d(t: Vec2): Mat3 = withMat3 {
    translateMatrix2d(t.x, t.y, it)
}

public fun translateMatrix2d(x: Float, y: Float): Mat3 = withMat3 {
    translateMatrix2d(x, y, it)
}

public fun translateMatrix2d(x: Float, y: Float, result: Mat3) {
    result.array[0] = 1f
    result.array[1] = 0f
    result.array[2] = 0f
    result.array[3] = 0f
    result.array[4] = 1f
    result.array[5] = 0f
    result.array[6] = x
    result.array[7] = y
    result.array[8] = 1f
}

public fun scaleMatrix2d(s: Vec2): Mat3 = withMat3 {
    scaleMatrix2d(s.x, s.y, it)
}

public fun scaleMatrix2d(x: Float, y: Float): Mat3 = withMat3 {
    scaleMatrix2d(x, y, it)
}

public fun scaleMatrix2d(x: Float, y: Float, result: Mat3) {
    result.array[0] = x
    result.array[1] = 0f
    result.array[2] = 0f
    result.array[3] = 0f
    result.array[4] = y
    result.array[5] = 0f
    result.array[6] = 0f
    result.array[7] = 0f
    result.array[8] = 1f
}

private fun rotateMatrix2d(angle: Float, result: Mat3) {
    val cos = cos(angle)
    val sin = sin(angle)

    result.array[0] = cos
    result.array[1] = sin
    result.array[2] = 0f
    result.array[3] = -sin
    result.array[4] = cos
    result.array[5] = 0f
    result.array[6] = 0f
    result.array[7] = 0f
    result.array[8] = 1f
}

public fun rotateMatrix2d(angle: Float): Mat3 = withMat3 {
    rotateMatrix2d(angle, it)
}
