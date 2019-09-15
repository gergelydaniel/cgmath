package com.danielgergely.cgmath.graphics

import com.danielgergely.cgmath.mat3.Mat3
import com.danielgergely.cgmath.vec2.Vec2

private inline fun withMat3(operation: (Mat3) -> Unit): Mat3 {
    val result = Mat3.zero()
    operation(result)
    return result
}

fun translateMatrix2d(t: Vec2) = withMat3 {
    translateMatrix2d(t.x, t.y, it)
}

fun translateMatrix2d(x: Float, y: Float) = withMat3 {
    translateMatrix2d(x, y, it)
}

fun translateMatrix2d(x: Float, y: Float, result: Mat3) {
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


fun scaleMatrix2d(s: Vec2) = withMat3 {
    scaleMatrix2d(s.x, s.y, it)
}

fun scaleMatrix2d(x: Float, y: Float) = withMat3 {
    scaleMatrix2d(x, y, it)
}

fun scaleMatrix2d(x: Float, y: Float, result: Mat3) {
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